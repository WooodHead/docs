# Security Best Practices Overview


* Network-Layer controls by defining and enforcing IP whitelists and blacklists, we can allow or restrict requests from specific geographical regions and certain IP addresses.
* Application-Layer controls by pre-defined, configurable application-layer firewall rules, let us address categories such as protocol violations, request limit violations, HTTPS policy violations and more.
* Adaptive rate controls by monitoring and controlling the rate of requests against applications, we can automatically protect them against application-layer DDoS and other volumetric attacks. 
* We can cloak our origin from the public Internet to protect against direct-to-origin attacks.
* We get real-time visibility into security events and drill down into attack alerts by security monitor:
* Robust, centralized authentication and authorization policies for access
* Use 3-tier architecture for frontend, backend and database. The backend tier and database tier are in the internal network environment. The backend server will be running under a specific user. Access to production environment is only granted to operations team. Database based authentication will be used. Security domain boundaries will be role-based authentication in place. Identification and authentication propagate security from the database tier to the application API – who can access, deploy, scale.  Do not lose control over the service
* We use POST over HTTPS protocol with external system communication
* Frontend and backend input validation mechanism should be applied to avoid cross-site scripting and SQL injection  
* All login information will be logged 
* passwords are stored and transmitted with “salt” encryption
* We use key-value database to store shared session for distributed session management
* Confidential information is stored in database or stored with encryption in file system 
* Integrate static application security testing into the build process
* Work with information security, architects, and engineers for code reviews and static code analysis. we take problem reports and watches for patterns
* https://moz.com/learn/seo/robotstxt
* https://www.mewx.org/blog/201801/anti-crawler-ideas/

## Middleware 

* [Middleware](middleware/middleware.md)

## Design

*  [Design](design/design.md)


## Develop

* [Develop](develop/develop.md)

## Private

* [Private](private/private.md)

## Training

* [ISO27001](https://www.iso.org/isoiec-27001-information-security.html)