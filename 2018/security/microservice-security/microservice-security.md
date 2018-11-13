# MicroServices Security Overview



* APIs, Acess Controls, and Gateways
```
Well, most of our microservices support our internal API, so they are just not 
visible and not reachable by external agents. If you break our API, you have 
HTTP-only access to our microservices: limit what can be done in HTTP, open only
 HTTP access from your Cloud itself and it is enough for our needs. A rule of thumb
 we applied to many microservices: no access to DB. Just process JSONs and reach 
 other microservices or API itself again.
Security domain boundaries – role-based authentication in place. Identification 
and authentication – propagate security from the database tier to the application
 API – who can access, deploy, scale. Do not lose control over the service.
API access control for microservices. Borrowing open-web API capability. Put 
together standards for access control in the API architecture – certificates, 
tokens, networks using Torch, Kubernetes, and CloudFoundry.
Need API gateway key or login. SSL at the transport layer. Whitelist ISPs that 
can access.
JSON Web Tokens, Amazon Virtual Private Cloud, and API Gateway pattern.
API gateways.
There are no silver bullets. We take a layered approach with coding standards, 
peer reviews, automated testing, and third-party pen testing. More secure profile
 in public with APIs.
API gateways are the most commonly used solution, and with good reason – they 
provide many great out-of-the box management services in addition to security. 
But when we’re talking standalone microservices, OpenID and OAuth is the way to go.
Design thinking for security with developers and architects. Think about security
 from the beginning. Best practice is OWAT2 with user authentication. Make sure 
 you are doing regular security scans and that you have no leaks. Docker has 
 security scanning. All talking via APIs. One single point of entry with API 
 gateways and security platforms.
API security is just as critical as application security. Not just native first-party 
apps. That’s where ID becomes more critical. Need to integrate to the identity 
layer- how to onboard, how to authorize access and have end-to-end coverage from
 the frontend to the backend. More complex patterns from the developer perspective.
 Not just front door access security. Zero-trust architecture.
APIs are an effective way to build governance right into the microservices architecture. 
APIs become these contracts by the developers on what the microservices will do 
and more importantly what it won't do. This makes it easy for central IT to govern 
these microservices since their SLAs can be managed through API gateways that act
 as proxies for the microservices. This ensures that there is the right balance 
 of governance for IT and flexibility for the domain teams.
```

* Other

```
SELinux is essentially required if you're running microservices. SELinux will prevent
 a program from running anything on the system outside of its own context. This 
 makes it so that an attacker capable of compromising your container has very few
 options and often can't do anything on the system. Proper knowledge and use of 
 SELinux for any production workload containers is a must. Apart from that
```
# Reference

* [How Do You Secure Microservices](https://dzone.com/articles/how-do-you-secure-microservices)