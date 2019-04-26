# Exercise 02

This application is designed to run against HR sample schema on Oracle Database,
version 11gR2, Express Edition.

This application provides `/exercise02/employees` web service, which returns some 
data on employees.

You task is to expand this application. 

## Functional requirements
Please implement service `/exercise02/departments`.
GET method on this endpoint must return JSON encoded array of departments.

 1. You will recieve thirty percent of points for this exercise
    for returning identifiers and names of departments.
 2. You will recieve an additional forty percent of points for supplementing
    department data with the number of employees in each department.

## Non functional requirements
Fulfilling the following requirements will earn you the remaining thirty
percent of points. 

 1. Please keep your solution consistent in style and architecture
    with the existing code.
 2. If possible, do not use native JDBC queries. Use JPA calls, JPQL or
    CriteriaQueries instead.
 3. Avoid N+1 queries issue.

# Technical details

This project builds with maven: `mvn clean install`.

This project was tested on Apache TomEE 7.1.0. It is preconfigured to run
with this server via: `mvn tomee:run`.
