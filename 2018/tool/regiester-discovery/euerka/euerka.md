# Eureka Overview

## Issue

* Caas的Eureka总是注册了已经失效的服务 - bamboo-demand-portal

Kubernetes : 

appadmin@SCDCA0000848:~> kubectl --server=https://53.126.101.106:6443 version
Client Version: version.Info{Major:"1", Minor:"7", GitVersion:"v1.7.7", GitCommit:"$Format:%H$", GitTreeState:"not a git tree", BuildDate:"2017-11-03T09:30:19Z", GoVersion:"go1.8.5", Compiler:"gc", Platform:"linux/amd64"}
Server Version: version.Info{Major:"1", Minor:"9+", GitVersion:"v1.9.11-dhc", GitCommit:"1bfeeb6f212135a22dc787b73e1980e5bccef13d", GitTreeState:"dirty", BuildDate:"2018-10-02T05:55:34Z", GoVersion:"go1.9.3", Compiler:"gc", Platform:"linux/amd64"}
 
Euerka

springBootVersion=1.5.8.RELEASE
springCloudVersion=Edgware.SR2
springIOVersion=1.0.0.RELEASE

[hresholdUpdater] c.n.e.r.PeerAwareInstanceRegistryImpl    : Current renewal threshold is : 13

eureka.server.enableSelfPreservation=false

## Reference

* [Understanding eureka client server communication](https://github.com/Netflix/eureka/wiki/Understanding-eureka-client-server-communication#about-instance-statuses)
* [Understanding Spring Cloud Eureka Server self preservation and renew threshold](https://stackoverflow.com/questions/33921557/understanding-spring-cloud-eureka-server-self-preservation-and-renew-threshold)
* [Spring Cloud Netflix Eureka - The Hidden Manual](https://blog.asarkar.org/technical/netflix-eureka/)
* [Spring Cloud with Spring Config and Eureka in high availability using docker swarm](http://pscode.rs/spring-cloud-with-spring-config-and-eureka-in-high-availability-using-docker-swarm/)
* [spring eureka 服务实例实现快速下线快速感知快速刷新配置解析](https://blog.csdn.net/zhxdick/article/details/78560993)
* [Eureka: client does not unregister on application shutdown](https://github.com/spring-cloud/spring-cloud-netflix/issues/2101)
