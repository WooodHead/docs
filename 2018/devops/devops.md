# DevOps Overview

## Centralized Configuration Management

In a typical web application, the disk is shared between nodes for two main purposes. One is to share some common configuration files between the nodes and, in most of the cases, mounting a shared disk drive to each node does this. If use of a shared drive is not possible, we can build some kind of a replication mechanism between those nodes, possibly using a shared repository. One node may commit its changes to a shared Git or subversion repository, and the other nodes will periodically pull updates. There
is another approach, which is quite common these days with the new advancements in DevOps engineering. We can use configuration management tools like Puppet12 or Chef13 to manage configurations centrally and automate the distribution between all the nodes

* Puppet
* Chef

## Git Code Management

* [BitBucket](https://bitbucket.org/)

## Docker Container Regiester
 
* [Quay](https://www.openshift.com/products/quay)
  
## Container Management

* [Kubernetes](https://kubernetes.io/)

## build automation

* Maven
* Gradle - Google , LinkedIn
* Nebula - Netflix
  
## Continuous Integration/ Continuous Development

Continuous integration enables software development teams to work collaboratively, without stepping on each other's toes. They can automate builds and source code integration to maintain source code integrity.

* Atlassian Bamboo
* AWS CodeBuild
* CircleCI
* CloudBees Jenkins
* Codeship
* GitLab CI
* IBM UrbanCode Build
* JetBrains TeamCity
* Microsoft VSTS
* Travis CI

* Jira
* Confluence
* BitBucket
* Git
* Artifactory
* Terraform
* Packer
* Rundeck
* Ansible
* AppDynamics

## Continuous Delivery

The continuous delivery tools bundle applications, infrastructure, middleware, and the supporting installation processes and dependencies into release packages that transition across the lifecycle

* Atlassian
* CA Technologies
* Chef Software
* Clarive
* CloudBees
* Electric Cloud
* Flexagon
* Hewlett Packard Enterprise
* IBN
* Micro Focus
* Microsoft
* Puppet
* Red Hat
* VMware
* XebiaLabs
* [Spinnaker - Netflix](https://www.spinnaker.io)

Spinnaker is an open source, multi-cloud continuous delivery platform for releasing software changes with high velocity and confidence.
  
## Reference

* [移动端持续集成的落地](https://mp.weixin.qq.com/s/1nlK6Nt3ewS7f4PkVU6IBA )
* Microservices for the Enterprise_Designing Developing, and Deploying
* [Dave Farley's Weblog](http://www.davefarley.net)