# IAM - Identity and Access Management Overview
  
# IAM Definition

  - James A. Martin

    ```
      Identity and access management (IAM) in enterprise IT is about defining and managing the roles
    and access privileges of individual network users and the circumstances in which users are granted
    (or denied) those privileges. Those users might be customers (customer identity management) or
    employees (employee identity management. The core objective of IAM systems is one digital identity
    per individual. Once that digital identity has been established, it must be maintained, modified 
    and monitored throughout each user’s “access lifecycle.”
      IAM systems provide administrattors with the tools and technologies to change a user's role,track
    user activies, create reports on those activities, and enforce policies on an ongoing basis. These
    systems are designed to provide a means of administering user access across an entire enterprise 
    and to ensure compliance with corporate policies and government regulations.
    ```

  - Yassir Abousselham

   ```
     grant access to the right enterprise assets to the right users in the right context, from a user’s
    system onboarding to permission authorizations to the offboarding of that user as needed in a timely 
    fashion     
   ```
 
# IAM Capabilities Model
 
  - [API Security]
   
    ```
     API security enables IAM for use with B2B commerce, integration with the cloud, and microservices-based 
    IAM architectures. Forrester sees API security solutions being used for single sign-on (SSO) between
    mobile applications or user-managed access. This would allow security teams to manage IoT device
    authorization and personally identifiable data.
    ```

   - [CIAM - Customer identity and access management]
    
    ```
      allow "kcomprehensive management and authentication of users; self-service and profile management;
    and integration with CRM, ERP and other customer management systems and databases"
    ```

  - [IA - Identity Analytics]

    ```
      allow security teams to detect and stop risky identity behaviors usring rules,machine learning, and
    other statistical algorithms
    ```

  - [IDass - Identity as a service]

    ```
      include "software-as-a-service(SaaS) solutions that offer SSO from a portal to web application and 
    native mobile applications as well as some level of user account provisioning and access request 
    management"
    ```

  - [IMG - Identity Management and Governance]
 
    ```
      provides automated and repeated ways to govern the identity life cycle. This is important when it 
    comes to compliance with identity and privacy regulations
    ```

  - [RBA - Risk-based authentication]
 
    ```
      solution " take in the context of a auser session and authentication and form a risk score. The 
    firm can then prompt high-risk users for 2FA and allow low-risk users to authenticate with single
    factor(e.g., username plus password)credentials"
    ```
# IAM terms
  
  - [Access Management]

    ```
      Access management refers to the processes and technologies used to control
    and monitor network access. Access management features, such as authentication,
    authorization, trust and security auditing, are part and parcel of the top 
    ID management systems for both on-prmises and cloud-based systems. 
    ```
  - [Active Directory]
    
    ```
      Microsoft developed AD as a user-identity directory service for Windows
    domain networks. Though properietary, AD is included in the Windows Server
    operating system and is thus widely deployed.
    ```

  - [Context-aware network access control]

    ```
      Context-aware network access conrol is a policy-based method of granting
    access to netowrk resources according to the current context of the user
    seeking access. For example, a user attempting to authenticate from an IP
    address that hasn't been whitelisted would be blocked.
   ```

  - [Credential]

    ```
      An identifier employed by the user to gain access to a network such as 
    the user's password, public key infrastructure(PKI) certificate, or biometric
    information(fingerprint, iris scan)

  - [De-provisioning]

    ```
      The process of removing an identity from an ID repository and terminating
    access privileges
    ```

  - [Digital identity]
   
    ```
      The ID itself, including the description of the user and his/her/its 
     access privileges. ("it's" because an endpoint, such as a laptop or 
     smartphone, can have its own digital identity.
    ```

  - [Entitlement]

    ```
      The set of attributes that specify the access rights and privileges of 
     an authenticated security principal.
    ```

  - [Identity lifecycle managment]

    ```
      Similar to access lifecycle management, the term refers to the entire set
    of processes and technologies for maintaining and updating digital identities.
    Identity lifecycle management includes identity synchronization, provisioning,
    de-provisioing, and the ongoing management of user attributes, credentials
    and entitlements.
    ```
  - [LDAP - Lightweight Idrectory Access Protocal]

    ```
      LDAP is open standards-based protocol for managing and accessing a distributed
    directory service, such as Microsoft's AD
    ```

  - [MFA - Multi-factor authentication]

    ```
      MFA is when more than just a single factor, such as a user name and password
    is required for authentication to a network or system. At least one additional 
    step is also required, such as receiving a code sent via SMS to a smartphone,
    inserting a smart card or USB stick, or satisfying a biometric authentication
    requirement, such as a fingerprint scan.
    ```

  - [Password reset]
    
    ```
      in this context, it's a feature of an ID management system that allows
    users ot re-establish their own passwords, relieving the administrators of
    the job and cutting support calls. The reset applicaiton is often accessed
    by the user through a brower. The application asks for a secret word or a 
    set of questions to verify the user's identity.
    ```
  
  - [Privileges account management]

    ```
      This term refers to managing and auditing accounts and data access based
    on the privileges of the user. In general terms, because of his or her job
    or function, a privileges user has been granted administrative access to 
    systems. A privileged user, for example, would be able set up and delete user
    accounts and roles.
    ```
   
  - [Provisioning]

    ```
      The process of creating identities, defining their access privileges and
    adding them to an ID repository.
    ```
  
  - [RBA - Risk-based authentication]

    ```
      Risk-based authentication dynamically adjust authentication requirements
    based on the user's situation at the moment authentication is attempted.
    For example, when users attempt to authenticate from a geopraphic location
    or IP address not previously associated with them, those users may face
    addtional authentication requirements.
    ```

  - [Security principal]

    ```
      A digital identity with one or more credentials that can be authenticated
    and authorized to interact with the network
   ```
  
  - [SSO - Single sign-on]

    ```
      A type of access control for multiple related but separate systems. With
    a single username and password, a user can access a system or systems without
    using different credentials.
    ```

  - [UBA - User behavior analytics]

    ```
      UBA technologies examine patterns of user behavior and automatically apply
    algorithms and analytics to detect importnat anomalies that may indicate
    potential security threats. UBA differs form other seucrity technologies,
    which focus on tracking devices or security event. UBA is also sometimes 
    grouped with entity behavior analytics and knwon as UEBA.
    ```

# IAM vendors

  - [Atos(Edidan)]
  - [CA Technologies]
  - [Centrify]
  - [Covisint]
  - [ForgeRock]
  - [IBM Security Identity and Access Assurance]
  - [I-Spring Innovations]
  - [Mico Focus]
  - [Microsoft Azure Active Directory]
  - [Okta](https://www.okta.com )
  - [OneLogin]
  - [Optimal idM]
  - [Oracle Identity Cloud Service]
  - [Ping]
  - [SecureAuth]


# Reference

 - [What is IAM? Identity and access management explained](https://www.csoonline.com/article/2120384/identity-management/what-is-iam-identity-and-access-management-explained.html )
 - [Tech Tide: Identity and Access Management,Q4 2017](https://www.forrester.com/report/The+Forrester+Tech+Tide+Identity+And+Access+Management+Q4+2017/-/E-RES127871# )
