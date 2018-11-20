# Develop Security Overview

* [Java Security](java.md)
* Unrestricted HTML5 Cross-Domain Resource Sharing

Both of these steps rely on examining an HTTP request header value. Although it is usually trivial to spoof any header from a browser using JavaScript, it is generally impossible to do so in the victim's browser during a CSRF attack, except via an XSS vulnerability in the site being attacked with CSRF. More importantly for this recommended Same Origin check, a number of HTTP request headers can't be set by JavaScript because they are on the 'forbidden' headers list. Only the browsers themselves can set values for these headers, making them more trustworthy because not even an XSS vulnerability can be used to modify them
        so ,if we already have domain name , we use it in code instead of "*", if not, we can temporarily use request.getHeader("Origin") instead .

* Hard-Coded Secret Tokens Present in Application Code
       
Will remove the token in the code and will use KMS when we deploy at AWS.

* never commit any kind of credentials into source repositories
* API invoking Parameter will be encrypted by token and timestamp
 Frontend and backend input validation mechanism should be applied to avoid cross-site scripting and SQL injection
* Sensitive configuration information is stored and transmitted with “salt” encryption
* Integrate static application security testing into the build process with SonarQube
* Encrypt Android APK package

## Reference