# Security Overview

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


* [Authentication and Authorization](authentication-authorization/authentication-authorization.md)
* [Open Web Application Security Project](https://www.owasp.org/index.php/About_The_Open_Web_Application_Security_Project)

# Security Insight

* [API Security](api-security/api-security.md)
* [Applicaiton Security]
* [CIAM - Customer Identity & Access Management]
* [IAM - Identity & Access Managment](identity-access-management.md)
* [IDaaS - Identity-As-A-Service]
* [Passwords](password.md)
* [RBA - Risk-Based Authentication]
* [SSO - Single Sign-On](single-sign-on/single-sign-on.md)
* [2FA - Two-Factor Authentication](two-factoro-authentication.md)

# common security issues

* [CORS - cross origin resource sharing](https://en.wikipedia.org/wiki/Cross-origin_resource_sharing)
* [跨域资源共享 CORS 详解](http://www.ruanyifeng.com/blog/2016/04/cors.html)
* [CSRF - Cross-Site Request Forgery](https://www.owasp.org/index.php/Cross-Site_Request_Forgery_(CSRF) )
* [java.util.Random and java.security.SecureRandom](https://stackoverflow.com/questions/11051205/difference-between-java-util-random-and-java-security-securerandom)
* [ransomware](ransomware.md)
* [spring boot微服务之https调用](https://www.jianshu.com/p/32c73f12db9e)
  
# common security issues prevention
  
* [Cross-Site Request Forgery (CSRF) Prevention Cheat Sheet](https://www.owasp.org/index.php/Cross-Site_Request_Forgery_(CSRF)_Prevention_Cheat_Sheet)
* [CSRF for springboot](../code/java/springboot/springboot.md)
* [Key Management Lifecycle Best Practices](https://www.owasp.org/index.php/Key_Management_Cheat_Sheet#Key_Management_Lifecycle_Best_Practices

# vulnerability scanner

* [vulnerability scanner](../too/vulnerability-scanner/vulnerability-scanner.md)

# security association

* [OWASP- Open Web Application Security Project](https://www.owasp.org )
* [CSA - Cloud Security Alliance](https://cloudsecurityalliance.org )
* [ISACA- Information Systems Audit and Control Association](https://www.isaca.org/Pages/default.aspx )

## Big Four accounting firms

* [Emst & Young](https://www.ey.com )
* [Deloitte & Touche](https://www2.deloitte.com/cn/en.html )
* [KPMG](https://home.kpmg.com/xx/en/home.html )
* [PricewaterhouseCoopers](https://www.pwc.com )

## Research Company

* [Forrester](https://go.forrester.com )
* [Dimensional Research](http://dimensionalresearch.com )

# Security Position

* [CISO - Chief Information Security Officer](chief-information-security-officer.md)

# Security Training

* [knowbe4](https://www.knowbe4.com )
