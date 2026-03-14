package com.varsha.github_access_report.DTO;

public class RepositoryDTO {

    private String repoName;
    private String repoUrl;

    public RepositoryDTO() {
    }

    public RepositoryDTO(String repoName, String repoUrl) {
        this.repoName = repoName;
        this.repoUrl = repoUrl;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }
}