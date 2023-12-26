# spring-boot-quartz-scheduler

### Introduction

This is a simple spring boot application used to demonstrate the capabilities of Quartz scheduler

The application is making use of, mainly, the following packages:

* Spring Boot Web: to create / retrieve / list / update / start and stop schedules dynamically.
* JPA: used to store custom schedules and quartz data.
* Flyway: to manage database migrations (avoid JPA automatic creation of schemas)
* Quartz: The scheduler framework.
