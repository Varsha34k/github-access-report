package com.varsha.github_access_report.DTO;

import java.util.List;

public class UserAccessDTO {

    private String user;
    private List<String> repositories;

    public UserAccessDTO() {
    }

    public UserAccessDTO(String user, List<String> repositories) {
        this.user = user;
        this.repositories = repositories;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<String> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<String> repositories) {
        this.repositories = repositories;
    }
}