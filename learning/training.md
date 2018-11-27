# OneAPI platform 

integration layer for all data interface via OneAPI CN /global or FS ESB CN . Direct connection /data exchange
not allowed.

In the phase of transforming form product-oriented to service-oriented softeare , standard APis are  to be provided as desribed in Principle 5. to streamline the overall system architecture and simplify the communication between apis , an integration layer(referred to as Opne API)
is being build 

## API  maturity model

* api design 

how apis is desined e.g. in an ad-hoc approach , or follows the HATESAS chema

* api evolvement / change management

how to manage api change e.g. consumer driven contract 

* api security

security testing mechanism of api

* monitoring

monitoring mechanism of api 

* developer experience

experience sharing/communication channels among developers

* levels of maturity

regressive 1/ basic 2/ standardized 3(default)/mature 4/optimizing 5

## securing api - security activities

securing api includes several security activities, which are essential for service-oriented architecture ,more

* Access control

whilelist
OAuth (recommended)
  APIGee Support  build-in OAuth providerO
  OAuth provider CIAM
  OAuth provider PING
APIkey (recommended)
  APIGee Support
* Information clusure

Cerfificate(recmmended)
CAMA
JWT with PSK

## security Level

## Oneapi architecture & supprot model

  client -- load balanced -- > apigee microgateway  --> apigee management service (analytics config }
                                                    --> authorize api-key) softlayer
                                                    --> introspection OAuth( OAuth PRovider PING/CIAM) EDC

## API management platform

 one api portal api's are documented, documentation is linked to api proxies and the documentation is published to the developer portals. in this portal you will manage your apis

* developers
  
  openapi(hub)
  paigee usage introdcution
    based on the current design of the portals , each api version configured in the provider portal is linked with on apigee api proxy
    meaning your could use different versions when your want to differentiate

* service provider setup steps

consult with oneapi team service name service definition
select a proper deploy ment topology
get new the server if no existing server can be used
request external/internal domain names
request apigee accouts
itt requests
configure api proxy and prodcut on apigee edgeui
publish api version and environement on provider portal
consumer subscribe service
test microgateway

* customer profile service (pre-develpment)

* microgateway setup

 setup api proxy in edgeui of apgee, and spefity the taret endpoint url
 based on the demo in provider portal, you can see there are three environment deployed in one version of api, and you can overwrite the target url for each environment in the edit so that document can show url correctly
 after syncing wit hapigee environments, you can login developer portal and see these environments and versions shown in api detail page.

## APIS Standard

  service canvas
  Naming convertion on URL and body
  URL is based on resource , it;s noun 
  Considering version in A:I

API affrodance
  on more prefix at root of url
  only provide https to access
  in developer portal
   put right base url 
   name field follow convertion service id+ service name such as 42 lead management service
   access health check api and right

API serlf-service
CI/CD
API Test

Daimerl Software Delivery Process & Practice Standard (SDPPS)

* KANBAN

   Jira KANBAN, requirement mgmt. statistic, analystic for project banner, more transparent

* Vision Control

  all teams must use version control which is located at : https://git.mercedes-benz.com

  OPS               V66  V50

  BU           V82  V66 V09

  QA           V92 V82 V77 V73

  Dev   V94 V93 V92 V91 V90

  single master branch recommended

  trunk based development
    in the trunk-based development model,all developers work on a single branch with open access to it. Often it's simply the master branch. They commit code to it and run it. It's super simple.
    In some cases, they create short-lived feature branches. Once code on their branch compiles and passed all tests , they merge it straight to master. It ensures that development is truly continuous and prevents developers from creating merge conflicts that are difficult to resolve.

  What
    Daimer sets up the code repository to manage the IP of "Daimer land own projects related source doe,docuemnt and other scripts
  Why
    Improving the transparency of project progress and code quality. Making code quailty 
  Scope

   https://git.mercedes-benz.com/china/its/cd/architecture/service-masterdata

* Code Quality and SEcurity

  code standard
  build standard
  deplyment standard
  security standard
  quality standard

  insights
    commits history

  https://see.mercedes-benz.com.cn/go/

  README.md
  catch null

* Builid and DEployment
   Script

   To enable continuous integration and delivery, tools and scripts shall be used to automate the build with high frequency such as daily or by each commit. Suppliers must delivery automated build and deployment scripts as the final deliverable.
   For deployment, the goal is build once and deploy everywehere. It means that each team only builds the source code once but deploys the binaries to any environments such as DEV, UAT or PRD etc. Different configuration fils (IPs,DB credentials etc) are used in different environments
  
* Dependence and Configuration Mgmt

  Software for each environment should be the same and each team must externalize all environment-specific configurations to achieve the goal of built once and deployed everywhere. A common ahti-pattern is to build muliple packages for verery environment and embedded related configuration into binary files.
  Configuration should be managed to fit different enivonments accourdingly.

  Best Practices
  Pipeline
    SourceCode pipeline
    Database migration scirpt pipeline
    Database migration and test pipeline
  Secure  Configuration information
    Environment Variable in pipeline

* Test Strategy
   Test Automation
     Automated GUI Tests
     Automated API Tests
     Aytomated Integration Tests
     Automated Component Tests
     Automated Unit Tests
   Test Strategy

   Testing should help developers to determine proper implementation, detect improper hehaviors introduced by code change, and make trouble shooting easier, thus in software development we should build a suitable test strategy to achieve better responsibility and flexibility.
   Unit tests are abstract but faster to run, while API/UI tests are more descriptive but are hard to maintain, the variable cost should be put into consideration to define testing strategy for your project.

* Pipeline as Foundation
   Continuous , Automation
* Architecture


   China-centric solutionSecurity
   Intellectual Property and licenses
   IT Security
   Tailored software
     based on services to be built by Daimler IT and venors
     when applicable ,common modules /APIs are to be re-used
  Ingegration layer
  Devops model
  Standardized frameworks 
    for both develpment,testing operations and UI/UX should be follwoed.
  Data lake 
    to be sourced by data resulting from all existing /new systems (unless legal restriction)
  Customer-facing apps 
    should consider WeChat mini app as the preferred platform and follow Daimler 

* Microservices maturity model

  Service Modeling
   how is service modelled (e.g. based on business domain)
  Data Management
   How service accesses database 
   Level of data redundancy
  Quality Management
   How is testing conducted
   What is the automation level of test cases executed
  Deployment & infrastructure
   What is the level of infrastructure management
   How is the deploy ment process
  Operation & Maintenance
   Level of operation
   Accessibility of application and system logs

   Level of Maturity

    Regressive 1->  Base 2 (recommended) -> Standardized 3 -> Mature  4 -> Optimizing 5


## Refernece

* CA layer 7 was mainly used to host APIs from RD and some of HQ services. In China,  APIGee is the only recommended plateform for OneAPI hosting.
If you need more technical information for CA Layer 7, you can refer to https://www.ca.com/us/company/acquisitions/layer-7-is-now-ca-technologies.html.