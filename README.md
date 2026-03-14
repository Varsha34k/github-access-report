# GitHub Access Report API

## Overview
This project is a Spring Boot service that connects to the GitHub API and generates a report showing which users have access to which repositories within a given organization.

## Tech Stack
- Java
- Spring Boot
- GitHub REST API
- RestTemplate

## Project Structure

## Project Structure

```
github-access-report
 ├─ src
 │  ├─ main
 │  │  ├─ java
 │  │  │  └─ com.varsha.github_access_report
 │  │  │     ├─ controller
 │  │  │     │   └─ HelloController.java
 │  │  │     ├─ service
 │  │  │     │   └─ GithubService.java
 │  │  │     ├─ DTO
 │  │  │     │   ├─ UserAccessDTO.java
 │  │  │     │   └─ RepositoryDTO.java
 │  │  │     └─ GithubAccessReportApplication.java
 │  │
 │  └─ resources
 │      └─ application.properties
 │
 ├─ pom.xml
 └─ README.md
```

## How to Run

1. Clone the repository
2. Open the project in VS Code or IntelliJ
3. Run the Spring Boot application

mvn spring-boot:run

## Authentication

The application authenticates with GitHub using a Personal Access Token.

Set your GitHub token as an environment variable before running the application.

Windows:

set GITHUB_TOKEN=your_token_here

Mac/Linux:

export GITHUB_TOKEN=your_token_here

## API Endpoint

GET /report/{organization}

Example:

http://localhost:8080/report/octokit

## Example Output

[
  {
    "user": "username",
    "repositories": ["repo1","repo2"]
  }
]

## Design Decisions

- DTO pattern used for clean data transfer
- Service layer handles GitHub API communication
- Aggregation performed using HashMap for efficient lookup