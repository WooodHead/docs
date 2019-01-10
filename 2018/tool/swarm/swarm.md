# Swarm Overview

* An enterprise-grade secure cluster of Docker hosts.
* An engine for orchestrating microservices apps
* ![high level architecture](img/swarm-architecture-high-level.png)

## Cluster of Docker

It groups one ore more Docker nodes and lets you manage them as a cluster. Out-of-the-box you get an en encrypted distributed cluster store,encrypted networks,mutual TLS, secure cluster join tokens, and a PKI that makes managing and rotating ceriticateds a breeze!

These can be physical servers ,VMs, Raspberry Pi's, or cloud instances. The only requirements is that all nodes cam communicate over reliable networks.

* The configuration and state of the swarm is held in a distributed etcd database located on all manager. It's kept in memory and is extremely up-to-date.
* To use TLS to encrypt communication,authenticate nodes, and authorized roles.
* CA settings
* join tokens
* Automatic key rotation
* 2377/tcp: for secure client-to-swarm communication
* 7946/tcp and 7946/udp: for control plane gossip
* 4789/udp: for VXLAN-based overlay networks

## Orchestration

It exposes a rich API that allows you to deploy and manage complicated microservices apps with ease. You can define your apps in declarative manitest files, and deploy them with native Docker commands. You can even perform rolling updates, rollbacks and scaling operation.

* the atomic unit of scheduling on a swarm is the service
* a container is wrapped in a service we call it a task or a replica, and service construct adds things like scaling, rolling updates, and simple rollbacks.

## Building a Swarm

### The process of building a swarm(initialzing a swarm)

* Initialize the first manager node
* Join addtional manager nodes
* Join worker nodes

## Swarm manager high availability (HA) 

* Swarm managers have native support for high availability(HA). This means one or more cal fail, and the sruvivors will keep the swarm running. 
* There are multiple managers, only one of them is ever considered active. It calls this active manager the 'leader', and the leader's the only one that will ever issue live commands against the swarm.
* ![learder diagram](img/swarm-ha-leader.png)
* swarm uses an implementation of the [Raft consensus algorithms](https://raft.github.io) to power manager HA

## Actual State vs Desired State

## Replicated vs Global services

The default replication mode of a service is replicated. This will deploy a desired number of replicas and distributed them as evenly as possible across the cluster.
The other mode is global, which runs a single replica on every node in the swarm.
To deploy a global service you need to pass the --mode global flag to the docke service create command

## Scaling a service

Feature of services is the ability to easily scale them up and down.
Bebind the scenses,swarm runs a scheduling algorithm that defaults to balancing replicas as evenly as possible across the nodes in the swarm.
But this balance whether takes into account about CPU load depends their implementations

## Rolling updates

* docker service update --update-parallelism --update-delay 

```bash
#! /bin/bash
docker service update --image <dockerID>/<image-name>:<update-tag> --update-parallelism 2 \ # the new image was pushed to 2 replicas at a time 
--update-delay 20s # with a 20 seconds cool-off period in between each
<service-name>
```

* Some of the requests will be services by replicas running the old version and some will be serviced by replicas running the new version s. After enough time, all requests will be serviced by replicas running the updated version of the service.

* docker service inspect --pretty <service-name>

## Swarm log

Docker swam support many log driver

* journalId(only works on Linux hosts running systemd)
* syslog
* splunk
* gelf

By default, Docker nodes configure services to use the json-file

