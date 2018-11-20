# Terminology Overview

## Architect

* stateless

Stateless means that an application should not assume any data to be in the memory before and after it executes an operation.

* self-container

If you take a traditional web application, let’s say a Java EE application,
it is deployed in some kind of Java EE container, for example a Tomcat, WebLogic, or WebSphere server, as a WAR (Web Application aRchive) file. The web application does not worry about how people (or systems) access it, under which transport (HTTP or HTTPS) or which port. Those decisions are made at the web container level (Tomcat, WebLogic, or WebSphere server configuration). A WAR file cannot exist on its own; it relies on the underneath container to do the transport/port bindings. They are not self- contained.Spring Boot14, a popular Java-based microservices framework, lets you build microservices as self contained, self-executable JAR files. There are many other microservice frameworks (Dropwizard15 and MSF4J16) out there that do the same.


## Reference

* [12 factors](https://12factor.net/backing-services)
* Microservices for the Enterprise_Dessigning,Developing, and Developing