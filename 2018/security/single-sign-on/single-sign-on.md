# Single Sign-On Overview

# Single Sign-On Capability Model

  - [Doug Drinkwater](https://www.csoonline.com/author/Doug-Drinkwater )
  
    ```
      Single sign-on(SSO) is centralized session and user authentication service
    in which one set of login credentials can be used to access multiple applicaitons
    Its beauty is in its simplicity; the service authenticates you one on one
    designated platform, enabling you to then a plethora of services without
    having to log in and out each time.

    ```
# Capability Model
 
  - Barry Scott, CTO at Centrify EMEA

   ```
     The first is that it improves the user experience by stopping the sprawl of
   different usernames and passwords which came about through the incredible rise
   in SaaS cloud-based applications.
     The second reason is improved security. The main cause of breaches is 
   compromised credentials and the more usernames and passwords we have, the worse
   our password hygiene becomes. We start to use the same passwords everywhere
   and they often becom less complex, making it easier for credentials to be
   compromiesed.
   ```

# Specification
 
  - [SAML 2.0- Security Assertion Markup Language](saml/saml.md)
  - [OAuth](https://oauth.net )
  - [OpenID Connect](https://openid.net/connect )
  
  ```
    Josh Fruhlinger
      SAML vs OAuth
      OAuth is a somewhat newer standard than SMAL, developed jointly by Google
   and Twitter beginning in 2006. It was developed in part to compensated for
   SAML's deficiencies on mobile platforms and is based on JSON rather than XML.
      Other than SAML's less-than-stellar mobile support, what's the difference
   between the two? as we've seen, the SAML standard defines how provides can
   offer both authentication and authorization services. OAuth, on the other hand,
   only deals with authorization. OpenID Connect is an even newer standard, 
   developed in 2014, that provides authentication services, and is layered on 
   top of OAuth.
      Another major difference is their use cases. While SAML theoretically was
   designed for use on the open internet, in practice it's most often deployed
   within enterprise networks for single sign-on. OAuth, by contrast, was designed
   by Google and Twitter for internet scale.
  ``` 

# Contenders

  - [Centrify](https://www.centrify.com )

# Reference

 - [What is single sign-on? How SSO improves security and the user experience](https://www.csoonline.com/article/2115776/authentication/what-is-single-sign-on-how-sso-improves-security-and-the-user-experience.html '
 - [OneLogin outlines how to develop for SAML on five different Web development  platforms](https://developers.onelogin.com/saml )
 - [Amzon explains how to create a SAML identity provider AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_create_saml.html )
 - [ZenDesk - set up single sign-on using Active Directory with ADFS and SAML](https://support.zendesk.com/hc/en-us/articles/203663886-Setting-up-single-sign-on-using-Active-Directory-with-ADFS-and-SAML-Professional-and-Enterprise- )
 - [Rail - learn how SAML can add SSO functionality to your Rails applicaiton](https://blog.cloud66.com/adding-sso-to-your-rails-application-with-saml )
 - [How SAML authentication works](https://auth0.com/blog/how-saml-authentication-works )

