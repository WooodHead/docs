# Design Security Overview

## Layered architecture

* Use 3-tier architecture for frontend, backend and database.

The backend tier and database tier are in the internal network environment. The backend server will be running under a specific user. Access to production environment is only granted to operations team. Database based authentication will be used. Security domain boundaries will be role-based authentication in place. Identification and authentication propagate security from the database tier to the application API – who can access, deploy, scale.  Do not lose control over the service

## Cache

* 缓存穿透
* 缓存雪崩