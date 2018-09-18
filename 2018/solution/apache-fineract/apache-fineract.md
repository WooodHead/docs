# finance cn

  - [finance cn](https://cwiki.apache.org/confluence/display/FINERACT/Fineract+CN )
# download

  - [1.1.0](https://dist.apache.org/repos/dist/release/fineract/1.1.0/ )
  
# installation

  - [fineract installation on ubuntu](https://cwiki.apache.org/confluence/display/FINERACT/How+To+Build+Apache+Fineract+CN)
  - [fineract installation on windows](https://cwiki.apache.org/confluence/display/FINERACT/Fineract-platform+Installation+on+Windows )
  
  
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
    
# project dependencies

  [fineract-cn-identity](https://github.com/apache/fineract-cn-identity )
   | --> [fineract-cn-command](https://github.com/apache/fineract-cn-command )
          | --> [fineract-cn-anubis](https://github.com/apache/fineract-cn-anubis *)
          | --> [fineract-cn-cassandra](https://github.com/apache/fineract-cn-cassandra )
                 |--> [cassandra 3.0.1 127.0.0.1:9042,127.0.0.2:9042,127.0.0.3:9042](https://github.com/apache/fineract-cn-cassandra/blob/develop/src/main/java/org/apache/fineract/cn/cassandra/util/CassandraConnectorConstants.java )
   | --> [fineract-cn-crypto](https://github.com/apache/fineract-cn-crypto *)
   | --> [fineract-cn-async] (https://github.com/apache/fineract-cn-async *)
          | --> [fineract-cn-api](https://github.com/apache/fineract-cn-api *)
                 |-->[fineract-cn-lang](https://github.com/apache/fineract-cn-lang *)
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
       first run 
        gradle build
       then 
       Window
       mvn install:install-file -Dfile=C:\Users\tony\git\github\fineract-cn-lang\build\libs\lang-0.1.0-BUILD-SNAPSHOT.jar -DgroupId=org.apache.fineract.cn -DartifactId=lang -Dversion=0.1.0-BUILD-SNAPSHOT -Dpackaging=jar
       Linux
       mvn install:install-file -Dfile=/home/tony/github/fineract-cn/fineract-cn-identity/fineract-cn-lang/build/libs/lang-0.1.0-BUILD-SNAPSHOT.jar -DgroupId=org.apache.fineract.cn -DartifactId=lang -Dversion=0.1.0-BUILD-SNAPSHOT -Dpackaging=jar
       
     ```
  - fineract-cn-cassandra
     ```
        请使用 -Xlint:unchecked 重新编译
     ```
