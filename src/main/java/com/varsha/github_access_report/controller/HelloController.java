package com.varsha.github_access_report.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.varsha.github_access_report.DTO.UserAccessDTO;
import com.varsha.github_access_report.service.GithubService;

@RestController
public class HelloController {

    private final GithubService githubService;

    public HelloController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/report/{org}")
    public List<UserAccessDTO> getAccessReport(@PathVariable String org) {
        return githubService.generateAccessReport(org);
}
}