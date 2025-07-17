# Blog Application
A simple Spring Boot blog application with a web UI, REST API, and JPA persistence.

## Setup
1. Run `mvn spring-boot:run` to start the application.
2. Access the web UI at `http://localhost:8080/`.
3. Use the H2 console at `http://localhost:8080/h2-console` for database access.

## Features
- View all blog posts
- Create new blog posts via web UI or REST API
- REST endpoints: `/api/posts`, `/api/posts/{id}`, `/api/posts` (POST)
