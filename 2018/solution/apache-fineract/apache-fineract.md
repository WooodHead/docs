# finance cn

  - [finance cn](https://cwiki.apache.org/confluence/display/FINERACT/Fineract+CN )
  
# rumtine configuration 

  - [runtime configuration](https://cwiki.apache.org/confluence/display/FINERACT/Requesting+An+Ubuntu+VM+For+Apache+Fineract+CN )
 
# runtime enviroment

  - [runtime environment](https://cwiki.apache.org/confluence/display/FINERACT/How+To+Build+Apache+Fineract+CN )
  
# Build Instructions
  
  - [Build Instructions](https://cwiki.apache.org/confluence/display/FINERACT/Build+Instructions )
  
# Documentation

  - [Getting Started Docs](https://cwiki.apache.org/confluence/display/FINERACT/How+To+Build+Apache+Fineract+CN )

# API
  
  - [openmf api](https://demo.openmf.org/api-docs/apiLive.htm ) 
  
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

  [fineract-cn-identity](https://github.com/apache/fineract-cn-identity )
   | --> [fineract-cn-command](https://github.com/apache/fineract-cn-command *)
          | --> [fineract-cn-anubis](https://github.com/apache/fineract-cn-anubis *)
                 | --> [fineract-cn-test](https://github.com/apache/fineract-cn-test )
                        | --> [fineract-cn-mariadb](https://github.com/apache/fineract-cn-mariadb )
          | --> [fineract-cn-cassandra](https://github.com/apache/fineract-cn-cassandra *)
                 |--> [cassandra 3.0.1 127.0.0.1:9042,127.0.0.2:9042,127.0.0.3:9042](https://github.com/apache/fineract-cn-cassandra/blob/develop/src/main/java/org/apache/fineract/cn/cassandra/util/CassandraConnectorConstants.java )
   | --> [fineract-cn-crypto](https://github.com/apache/fineract-cn-crypto *)
   | --> [fineract-cn-async] (https://github.com/apache/fineract-cn-async *)
          | --> [fineract-cn-api](https://github.com/apache/fineract-cn-api *)
                 |-->[fineract-cn-lang](https://github.com/apache/fineract-cn-lang *)
  [fineract-cn-provisioner](https://github.com/apache/fineract-cn-provisioner )
    | --> [fineract-cn-permitted-feign-client](https://github.com/apache/fineract-cn-permitted-feign-client ) 
  [fineract-cn-customer](https://github.com/apache/fineract-cn-customer )
  [fineract-cn-deposit-account-management/](https://github.com/apache/fineract-cn-deposit-account-management )
  [fineract-cn-group](https://github.com/apache/fineract-cn-group )
  [fineract-cn-accounting](https://github.com/apache/fineract-cn-accounting )
  [fineract-cn-office](https://github.com/apache/fineract-cn-office )
  [fineract-cn-payroll](https://github.com/apache/fineract-cn-payroll )
  [fineract-cn-portfolio](https://github.com/apache/fineract-cn-portfolio )
  [fineract-cn-teller](https://github.com/apache/fineract-cn-teller )
  
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
3) Are the APIs well documented and how many APIs are available?
   It supplies but simple, I'm not sure how many they are, I will report it later.
   https://cwiki.apache.org/confluence/display/FINERACT/Apache+Fineract+CN+API+Documentation
4) How is security handled in the system?
    It uses configuable two-Factor authentication.
    https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=67641984
    The stateless authentication is performed via JWT bearer tokens which need to be regularly refreshed.  The tokens are signed via a tenant-specific private key and long-lived tokens are transmitted as secure cookies, thus limiting the possibilities for interception
    https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=73634331
5) How is data protected? Any database level settings for security?
   Not sure until check the code.
6) Does it integrate with external systems (like SWIFT etc.) or is it easy to build the integrations ourselves?
   It supplies the Share Account Management & Dividends Payment
   https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=66852875
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