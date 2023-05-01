# JBA Code Sharing Platform
My implementation of the JBA Code Sharing Platform project for the Java Backend Developer track.

## Description
This is a code sharing website with both an API and a UI, you can:
 - Share codes
 - Read codes
 - View latest uploaded codes
 - Mark codes as private by adding a time or view limit to them
 - Private codes do not appear in the latest uploaded codes
 
## Availible endpoints
Web UI:
 - /code/[latest | {uuid} | new]
API:
 - api/code/[latest | {uuid} | new]
Note: you can play with the API from the src/main/java/platform/api/apitests.http
but this works only on IntelliJ
## Technologies used
 - Spring Web, Data JPA, Actuator
 - H2
 - Freemarker
 - Lombok
 - HTML, CSS & JavaScript
 - Java LocalDateTime API