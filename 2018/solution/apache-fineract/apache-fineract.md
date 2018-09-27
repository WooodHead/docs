# finance cn

  - [finance cn](https://cwiki.apache.org/confluence/display/FINERACT/Fineract+CN )
  
# demo

  - [generation 1- mifos2.x mifos/password](https://demo.openmf.org )
  
# rumtine configuration 

  - [runtime configuration](https://cwiki.apache.org/confluence/display/FINERACT/Requesting+An+Ubuntu+VM+For+Apache+Fineract+CN )
 
# runtime enviroment

  - [runtime environment](https://cwiki.apache.org/confluence/display/FINERACT/How+To+Build+Apache+Fineract+CN )
  
# Build Instructions
  
  - [Build Instructions](https://cwiki.apache.org/confluence/display/FINERACT/Build+Instructions )
  
# Documentation

  - [Getting Started Docs](https://cwiki.apache.org/confluence/display/FINERACT/How+To+Build+Apache+Fineract+CN )
  - [Architecture](https://cwiki.apache.org/confluence/display/FINERACT/Fineract+2.0+Introduction )
  - [Intial System Setup](https://mifosforge.jira.com/wiki/spaces/docs/pages/67895348/Initial+System+Set+Up )

# API
  
  - [Generation 1 - Mifos 2.x]( )
  - [Generation 2 - Mifos X](https://demo.openmf.org/api-docs/apiLive.htm ) 
  - [fineract-cn api](http://smartfinance.tech/fineract-cn-api-docs/ )
  - [group-based methodology](https://cwiki.apache.org/confluence/display/FINERACT/Group-Based+Financial+Inclusion+Methodologies )
  
# Key Design Principles

  - [Key Design Principles](https://cwiki.apache.org/confluence/display/FINERACT/Key+Design+Principles )
  
# download

  - [1.1.0](https://dist.apache.org/repos/dist/release/fineract/1.1.0/ )
  
# installation

  - [fineract installation on ubuntu](https://cwiki.apache.org/confluence/display/FINERACT/How+To+Build+Apache+Fineract+CN)
  - [fineract installation on windows](https://cwiki.apache.org/confluence/display/FINERACT/Fineract-platform+Installation+on+Windows )
  
# to build

  ```
    ./gradlew build
  ```  
    
# project dependencies

  ```
  [fineract-cn-anubis](https://github.com/apache/fineract-cn-anubis *)
  [fineract-cn-identity](https://github.com/apache/fineract-cn-identity )
   | --> [fineract-cn-command](https://github.com/apache/fineract-cn-command *)
          | --> [fineract-cn-anubis](https://github.com/apache/fineract-cn-anubis *)
                 | --> [fineract-cn-test](https://github.com/apache/fineract-cn-test )
                        | --> [fineract-cn-cassandra](https://github.com/apache/fineract-cn-cassandra ) 
                               | --> [cassandra 3.0.1 127.0.0.1:9042,127.0.0.2:9042,127.0.0.3:9042](https://github.com/apache/fineract-cn-cassandra/blob/develop/src/main/java/org/apache/fineract/cn/cassandra/util/CassandraConnectorConstants.java )
                        | --> [fineract-cn-mariadb](https://github.com/apache/fineract-cn-mariadb )
   | --> 
   | --> [fineract-cn-async] (https://github.com/apache/fineract-cn-async *)
          | --> [fineract-cn-api](https://github.com/apache/fineract-cn-api *)
                 |-->[fineract-cn-lang](https://github.com/apache/fineract-cn-lang *)
  [fineract-cn-permitted-feign-client](https://github.com/apache/fineract-cn-permitted-feign-client ) 
  [fineract-cn-provisioner](https://github.com/apache/fineract-cn-provisioner )
    | --> [fineract-cn-permitted-feign-client](https://github.com/apache/fineract-cn-permitted-feign-client ) 
           | --> [fineract-cn-identity](https://github.com/apache/fineract-cn-identity )
  [fineract-cn-rhythm](https://github.com/apache/fineract-cn-rhythm.git )
  [fineract-cn-template](https://github.com/apache/fineract-cn-template.git )
  [fineract-cn-office](https://github.com/apache/fineract-cn-office )
  [fineract-cn-customer](https://github.com/apache/fineract-cn-customer )
  [fineract-cn-accounting](https://github.com/apache/fineract-cn-accounting )
   | --> [fineract-cn-customer](https://github.com/apache/fineract-cn-customer )
   [fineract-cn-portfolio](https://github.com/apache/fineract-cn-portfolio )
  [fineract-cn-deposit-account-management/](https://github.com/apache/fineract-cn-deposit-account-management )
  [fineract-cn-cheques](https://github.com/apache/fineract-cn-cheques )
  [fineract-cn-group](https://github.com/apache/fineract-cn-group )
  [fineract-cn-payroll](https://github.com/apache/fineract-cn-payroll )  
  [fineract-cn-teller](https://github.com/apache/fineract-cn-teller )
   | --> [fineract-cn-portfolio](https://github.com/apache/fineract-cn-portfolio )
   | --> [fineract-cn-cheques](https://github.com/apache/fineract-cn-cheques )
  [fineract-cn-reporting](https://github.com/apache/fineract-cn-reporting )
  [fineract-cn-notifications](https://github.com/apache/fineract-cn-notifications )
  
  core
  
  - [fineract-cn-lang](https://github.com/apache/fineract-cn-lang *)
  - [fineract-cn-api](https://github.com/apache/fineract-cn-api *)
  - [fineract-cn-async] (https://github.com/apache/fineract-cn-async *)
  - [fineract-cn-cassandra](https://github.com/apache/fineract-cn-cassandra )
  - [fineract-cn-mariadb](https://github.com/apache/fineract-cn-mariadb )
  - [fineract-cn-data-jpa](https://github.com/apache/fineract-cn-data-jpa )
  - [fineract-cn-command](https://github.com/apache/fineract-cn-command *)
  - [fineract-cn-test](https://github.com/apache/fineract-cn-test )
  
  tools
  
  -  [fineract-cn-crypto](https://github.com/apache/fineract-cn-crypto *)
  
  integeration-tests
  
  - [fineract-cn-service-starter](https://github.com/apache/fineract-cn-service-starter )
  - [fineract-cn-default-setup](https://github.com/apache/fineract-cn-default-setup )
  - [fineract-cn-demo-server](https://github.com/apache/fineract-cn-demo-server )
  ```
  
# issuses

  -  Could not find org.apache.fineract.cn:lang:0.1.0-BUILD-SNAPSHOT 依赖问题
  -  Task with path 'build' not found in root project
     ```
   #    first run 
        gradle build
       then 
       Window
       mvn install:install-file -Dfile=C:\Users\tony\git\github\fineract-cn-lang\build\libs\lang-0.1.0-BUILD-SNAPSHOT.jar -DgroupId=org.apache.fineract.cn -DartifactId=lang -Dversion=0.1.0-BUILD-SNAPSHOT -Dpackaging=jar
       Linux
       mvn install:install-file -Dfile=/home/tony/github/fineract-cn/fineract-cn-identity/fineract-cn-lang/build/libs/lang-0.1.0-BUILD-SNAPSHOT.jar -DgroupId=org.apache.fineract.cn -DartifactId=lang -Dversion=0.1.0-BUILD-SNAPSHOT -Dpackaging=jar
       
     ```
  - fineract-cn-cassandra
  
     ```
        javacomile faild
        vim build.gradle
        
        dependencies {
            compile(
                    [group: 'org.springframework.boot', name: 'spring-boot-starter', version: versions.springboot], <====== add 
                    [group: 'org.springframework', name: 'spring-context', version: versions.springcontext],
                    [group: 'com.google.code.findbugs', name: 'jsr305', version: versions.findbugs],
                    [group: 'org.apache.fineract.cn', name: 'lang', version: versions.frameworklang],
                    [group: 'com.datastax.cassandra', name: 'cassandra-driver-core', version: '3.0.1'],
                    [group: 'com.datastax.cassandra', name: 'cassandra-driver-mapping', version: '3.0.1'],
                    [group: 'com.datastax.cassandra', name: 'cassandra-driver-extras', version: '3.0.1']
            )

            testCompile(
                    [group: 'org.springframework.boot', name: 'spring-boot-starter-test', version: versions.springboot]
            )
        }

     ```
     
  - fineract-cn-test
  
    ```
        mysql -u root -pmysql
        CREATE DATABASE IF NOT EXISTS system_console;
        
        cqlsh
        CREATE KEYSPACE IF NOT EXISTS system_console
          WITH REPLICATION = {
              'class' : 'SimpleStrategy',
              'replication_factor' : 3
          };
          
        
        ext.versions = [
                validation                : '2.0.1.Final', <=== add
                springcontext             : '4.3.3.RELEASE',
                springboot                : '1.4.1.RELEASE',
                gson                      : '2.5',
                findbugs                  : '3.0.1',
                frameworklang             : '0.1.0-BUILD-SNAPSHOT',
                frameworkmariadb          : '0.1.0-BUILD-SNAPSHOT',
                frameworkcassandra        : '0.1.0-BUILD-SNAPSHOT'
        ]


        dependencies {
            compile(
                    [group: 'org.springframework', name: 'spring-context', version: versions.springcontext],
                    [group: 'com.google.code.findbugs', name: 'jsr305', version: versions.findbugs],
                    [group: 'org.springframework.boot', name: 'spring-boot-starter', version: versions.springboot],
                    [group: 'org.springframework.boot', name: 'spring-boot-starter-test', version: versions.springboot],
                    [group: 'com.google.code.gson', name: 'gson', version: versions.gson],
                    [group: 'org.apache.fineract.cn', name: 'cassandra', version: versions.frameworkcassandra],
                    [group: 'org.apache.fineract.cn', name: 'mariadb', version: versions.frameworkmariadb],
                    [group: 'org.apache.fineract.cn', name: 'lang', version: versions.frameworklang],
                    [group: 'io.jsonwebtoken', name: 'jjwt', version: '0.6.0'],
                    [group: 'org.cassandraunit', name: 'cassandra-unit', version: '3.0.0.1'],
                    [group: 'ch.vorburger.mariaDB4j', name: 'mariaDB4j', version: '2.1.3'],
                    [group: 'javax.validation', name: 'validation-api', version: versions.validation] <=== add

            )
            testCompile(
                    [group: 'org.springframework.boot', name: 'spring-boot-starter-test', version: versions.springboot] <=== add
            )
        }

    ```
    
# evaluation 

Evaluate the source code for the following details:
1) Is it pure Microservices architecture?
   Some like, e.g. It uses Eureka as service registry and discovery, but it doesn't mention distributed monitoring and dependency tracing.
   https://cwiki.apache.org/confluence/display/FINERACT/Composing+a+Release+out+of+Microservices   
2) Is there an API Gateway like APIGee we can use?
   No ,there is no api life cycle management like APIGee
   https://cwiki.apache.org/confluence/display/FINERACT/REST+API+Live+Documentation+Using+Swagger
   [+] Rest API Documentation - https://issues.apache.org/jira/browse/FINCN-6
   [+] fineract-cn api - http://smartfinance.tech/fineract-cn-api-docs/ 
   
3) Are the APIs well documented and how many APIs are available?
   It supplies but simple, I'm not sure how many they are, I will report it later.
   https://cwiki.apache.org/confluence/display/FINERACT/Apache+Fineract+CN+API+Documentation
4) How is security handled in the system?
    It uses configuable two-Factor authentication.
    https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=67641984
    The stateless authentication is performed via JWT bearer tokens which need to be regularly refreshed.  The tokens are signed via a tenant-specific private key and long-lived tokens are transmitted as secure cookies, thus limiting the possibilities for interception
    https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
5) How is data protected? Any database level settings for security?
   - [+]Data Driven Authorisation - https://cwiki.apache.org/confluence/display/FINERACT/Business+Event+Processor 
   - [+]Flag, Lock, or Place Accounts on Hold - https://cwiki.apache.org/confluence/display/FINERACT/Flag%2C+Lock%2C+or+Place+Accounts+on+Hold
   - [+]Backwards incompatible change to the persistence migration plan - (https://cwiki.apache.org/confluence/display/FINERACT/Composing+a+Release+out+of+Microservices )
6) Does it integrate with external systems (like SWIFT etc.) or is it easy to build the integrations ourselves?
   It supplies the Share Account Management & Dividends Payment
   https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=66852875
   [+] email sms integration - https://cwiki.apache.org/confluence/display/FINERACT/Proposal
7) How well is the source code documented and do they following coding standards etc.?
   No, It's no or seldom documented wthin the source code.
8) How easy is it for a team in Bamboo to take up this source code and maintain it/ add new functionality/ etc.?
   I'm not sure how easy because there are some features or stratgies are in-progress and some are outstanding.
   https://cwiki.apache.org/confluence/display/FINERACT/In-Progress+Features
   https://cwiki.apache.org/confluence/display/FINERACT/Outstanding+Features
9) How does the system scale? Is it purely on cloud? Can it run in AWS with auto scaling?
   Presently Fineract CN is in the process being deployed on a Virtual Machine. they have the plan to containized it now.
   https://cwiki.apache.org/confluence/display/FINERACT/Design+architecture+of+Containerized+FineractCN
10) Any performance bottlenecks you can evaluate in the source code or architecture?
   Not sure without performane test
11) Deploy the mobile application and see if it works on both android + iOS.
    Android is supported but iOS is not mentioned
    https://cwiki.apache.org/confluence/display/FINERACT/Fineract+CN+Mobile+User+Guide
    https://github.com/apache/fineract-cn-mobile
    
  # work progress

    1 .the progress of building finance-cn runtime  
   
       1.1 bulid the enviroment (Partially completed)
        
           according to https://cwiki.apache.org/confluence/display/FINERACT/How+To+Build+Apache+Fineract+CN
          
           Step 1: What You Will Need
            Install Google Chrome On Ubuntu 16.06 LTS
               We use centos7 instead
            Ensure that you have Oracle Java SDK 8. You can use this tutorial to do that.
               done
            Install git using This Article
               done
            Install MySQL 5.7 Using This Guide 
               done
            Install maven using mkyong & Ensure that artifacts are in $USER_HOME/.m2/repository
               done
            Use sdkman to install Gradle 4.5
               done
            Install cassandra 3.11 using this guide
               done
            Ensure you have Node 6.10.0+ and NPM 3+ installed.
               later
            Install  Nginx using this guide
               later
            Install Node packages using npm i 
               later
           
       1.2. the progress of compiling fineract-cn components

            According to https://cwiki.apache.org/confluence/display/FINERACT/Fineract+CN+Project+Structure

            Integration Tests
               later
            UI
               later
            Services
               identity done
               others   later
            Librarie
               done   
     2. the progress of reading source code
            later 
            
    issues:
       1. We need a high-configuration vm according to https://cwiki.apache.org/confluence/display/FINERACT/Requesting+An+Ubuntu+VM+For+Apache+Fineract+CN
          The following are the required minimum specifications needed;
            CPU Cores : 8 ( Core i7 )
            RAM : 32GB
            Disk : 50GB SSD
            OS : Ubuntu 16.04 LTS 
          but we have 1 core 2G memory now, I will contract with Henry to upgrade it later.
          
       2. It's old one that the spending so much time of downloading and compiling of the each fineract-cn-xxx component
       3. I have to fix some build.gradle bugs to complete the compiling 
       4. That server with 10.1.0.150 in Guozhou , I operate it from Beijing, the network is instable sometimes.        
       
    suggestions:
       If someone help me to build rumtime , I may have more time to read source code for analysis of data protected 


Evaluate the source code for the following details:
2) Is there an API Gateway like APIGee we can use?
   No ,there is no api life cycle management like APIGee
   https://cwiki.apache.org/confluence/display/FINERACT/REST+API+Live+Documentation+Using+Swagger
   [+]But, fineract[https://github.com/apache/fineract] api is by Apigee
      https://demo.openmf.org/api-docs/apiLive.htm
   
3) Are the APIs well documented and how many APIs are available?
   It supplies but simple, I'm not sure how many they are, I will report it later.
   https://cwiki.apache.org/confluence/display/FINERACT/Apache+Fineract+CN+API+Documentation
   
   [+]
   [fineract-cn-api-docs](http://smartfinance.tech/fineract-cn-api-docs/ )
  
   - [customer management](http://smartfinance.tech/fineract-cn-api-docs/customer/ )
   - [financial accounting](http://smartfinance.tech/fineract-cn-api-docs/accounting/ )
   - [teller management](http://smartfinance.tech/fineract-cn-api-docs/teller/ )
   - [group management](http://smartfinance.tech/fineract-cn-api-docs/group/ ) 
   - [identity management](http://smartfinance.tech/fineract-cn-api-docs/identity/ )
   - [deposit account management](http://smartfinance.tech/fineract-cn-api-docs/deposit/ )
   - [office management](http://smartfinance.tech/fineract-cn-api-docs/office/ )
   - [paroll management](http://smartfinance.tech/fineract-cn-api-docs/payroll/ )
     - Payroll Configurations
      - Prepare A Payroll Configuration
      - Find A Payroll Configuration
     - Distribute Payments
     - Fetch Distribution History
     - Fetch Payments
      About APIs well documented
                  My past answer is :  It supplies but simple, I'm not sure how many they are until I stats it.
                  My current answer is :Yes, It supplies the details with website http://smartfinance.tech/fineract-cn-api-docs
     About how many APIs are available
                  Up to now, There are 149 apis , the attachment is detail.
   
4) How is security handled in the system?
    It uses configuable two-Factor authentication.
    https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=67641984
    The stateless authentication is performed via JWT bearer tokens which need to be regularly refreshed.  The tokens are signed via a tenant-specific private key and long-lived tokens are transmitted as secure cookies, thus limiting the possibilities for interception
    https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
    
5) How is data protected? Any database level settings for security?
   - [+] Data Driven Authorisation
         [Business Event Processor](https://cwiki.apache.org/confluence/display/FINERACT/Business+Event+Processor )
     [+] Workflow using Datatable Verification
         [Workflow using Datatable Verification](https://cwiki.apache.org/confluence/display/FINERACT/Workflow+using+Datatable+Verification )
     [+] CQRS - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331   
     [+] multi-tenancy - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
     [+] stateless authentication - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
     [+] containerization - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
     [+] data tier - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
     [+] KYC document - https://cwiki.apache.org/confluence/display/FINERACT/Digital+Credit+App
                      - https://cwiki.apache.org/confluence/display/FINERACT/TIERED+KYC+V1+-+Mobile+Wallet+2.0+on+Mifos-X
         5.1 For data protected: (from coarse to fine)
                   Data Isolation - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
                       Data is placed in separate databases for each tenant         
                   Data Tier Design Consideration - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
                                     rdbms :  It is used to store relational data to create user based views, internal validation, reporting, or analytics
                                       nosql:  It is used to handle the fast processing of state changes and financial transactions.
                       message queue:  It is used to provide signals to parties which are interested in the change of data to build use case related sets of data
                   Data Access Authentication and Authorization:
                      JWT is used to stateless authentication  - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
                     The data saved for the tenant in identity includes: - https://cwiki.apache.org/confluence/display/FINERACT/Identity+Data+model
                         public and private key used to sign tokens
                         fixed salt used for server-side password hashing
                         password for the admin. The admin is saved user in isis. Her permissions could be changed.
                         how long a user's password is valid between password changes.
                        how long the user's grace period is to change a password after it has expired.
                  Request Update and Query Isolation - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
                       Command and Query Responsibility Segregation (CQRS) segregates operations that read data from operations that update data by using separate interfaces.
                  Data Driven Authorization - https://cwiki.apache.org/confluence/display/FINERACT/Business+Event+Processor
                       Data Driven Authorization enforces the user to have specific role before being able to perform an action. For e.g., Loan Approval of amount more than 10000 should be done by user with role "Manager".
                  Private Data Protected  -  https://cwiki.apache.org/confluence/display/FINERACT/Digital+Credit+App
                       I just find the KYC documents topic, but it doesn't talk about the solution because it is draft up to now 
         
         5.2 For database level settings for security
                It only  supplies user/password to authenticate with jdbc connection, When I find new content, I will report it to you in time.
 
        
6) Does it integrate with external systems (like SWIFT etc.) or is it easy to build the integrations ourselves?
   It supplies the Share Account Management & Dividends Payment
   https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=66852875
   [+] Mobile Money Integration Design Document Drafted by Yannick and Daniel - https://goo.gl/JGEXtQ
   [+] Outbound SMS - https://cwiki.apache.org/confluence/display/FINERACT/Outbound+SMS
   [+] Ad-Hoc Reporting - https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73632010
   [+] excel template-based bulkdata import - https://cwiki.apache.org/confluence/display/FINERACT/Bulkdata+Import 
   
7) How well is the source code documented and do they following coding standards etc.?
   No, It's no or seldom documented wthin the source code.
8) How easy is it for a team in Bamboo to take up this source code and maintain it/ add new functionality/ etc.?
   I'm not sure how easy because there are some features or stratgies are in-progress and some are outstanding.
   https://cwiki.apache.org/confluence/display/FINERACT/In-Progress+Features
   https://cwiki.apache.org/confluence/display/FINERACT/Outstanding+Features
9) How does the system scale? Is it purely on cloud? Can it run in AWS with auto scaling?
   Presently Fineract CN is in the process being deployed on a Virtual Machine. they have the plan to containized it now.
   https://cwiki.apache.org/confluence/display/FINERACT/Design+architecture+of+Containerized+FineractCN
10) Any performance bottlenecks you can evaluate in the source code or architecture?
   Not sure without performane test
11) Deploy the mobile application and see if it works on both android + iOS.
    Android is supported but iOS is not mentioned
    https://cwiki.apache.org/confluence/display/FINERACT/Fineract+CN+Mobile+User+Guide
    https://github.com/apache/fineract-cn-mobile 
    [+]https://cwiki.apache.org/confluence/display/FINERACT/Mobile+Field+Operations    