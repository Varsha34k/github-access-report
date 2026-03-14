package com.varsha.github_access_report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.varsha.github_access_report.DTO.UserAccessDTO;

@Service
public class GithubService {

    private RestTemplate restTemplate;

    public GithubService() {
        this.restTemplate = new RestTemplate();
    }

    public List<UserAccessDTO> generateAccessReport(String org) {

        HttpHeaders headers = new HttpHeaders();
         String token = System.getenv("GITHUB_TOKEN");

            if (token == null) {
                token = "PASTE_TOKEN_HERE";
            }

        headers.set("Authorization", "Bearer " + token);
        headers.set("User-Agent", "SpringBoot-App");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String repoUrl = "https://api.github.com/orgs/" + org + "/repos";

        ResponseEntity<List> repoResponse = restTemplate.exchange(
                repoUrl,
                HttpMethod.GET,
                entity,
                List.class
        );

        List<Map<String, Object>> repos = repoResponse.getBody();

        Map<String, List<String>> userRepoMap = new HashMap<>();

        for (Map<String, Object> repo : repos) {

            String repoName = (String) repo.get("name");

            String collaboratorUrl =
                    "https://api.github.com/repos/" + org + "/" + repoName + "/contributors";

            ResponseEntity<List> collabResponse = restTemplate.exchange(
                    collaboratorUrl,
                    HttpMethod.GET,
                    entity,
                    List.class
            );

            List<Map<String, Object>> collaborators = collabResponse.getBody();

            if (collaborators == null) continue;

            for (Map<String, Object> user : collaborators) {

                String username = (String) user.get("login");

                userRepoMap.putIfAbsent(username, new ArrayList<>());

                userRepoMap.get(username).add(repoName);
            }
        }

        List<UserAccessDTO> report = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : userRepoMap.entrySet()) {

            report.add(new UserAccessDTO(entry.getKey(), entry.getValue()));
        }

        return report;
    }
}