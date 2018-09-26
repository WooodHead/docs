# features

## configuration

   - [Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config)
   - [Spring Boot 环境变量读取 和 属性对象的绑定](https://blog.csdn.net/catoop/article/details/50548009)
  
## logging

   - [logging](https://www.mkyong.com/spring-boot/spring-boot-slf4j-logging-example/)
   - [LOGBACK CONFIGURATION: USING XML](https://springframework.guru/logback-configuration-using-xml/)
   - [Spring Boot - Profile-specific Logback configuration selection in logback-spring.xml file](https://www.logicbig.com/tutorials/spring-framework/spring-boot/profile-logback-logging-config.html)
   
## jpa 

   - [many2many](https://github.com/hellokoding/jpa-manytomany-springboot-maven-mysql)
   - [one2many](https://github.com/hellokoding/jpa-onetomany-springboot-maven-mysql)
   
## Test

   - [springboot Testing](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html )
   
## Api Document

   - [spring restdocs](https://spring.io/projects/spring-restdocs)
   - [asciicoder](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html#boot-features-testing-spring-boot-applications-testing-autoconfigured-rest-docs)
  
## security

## jwt

   - [jwt sso](https://github.com/hellokoding/hello-sso-jwt)

# issues 
 
## CSRF 

   - [Spring Boot Security - Enabling CSRF Protection](http://www.javainuse.com/spring/boot_security_csrf)
   - [Securing Spring Boot with JWTs](https://auth0.com/blog/securing-spring-boot-with-jwts/)
   - [Java 后端处理跨域问题](https://blog.csdn.net/u011318142/article/details/79499302)
   
   ```
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
    
    上面方式设置可以实现跨域请求，但是不支持Cookie，从而导致session也无法使用。
    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
    response.setHeader("Access-Control-Allow-Credentials", "true");
   ```