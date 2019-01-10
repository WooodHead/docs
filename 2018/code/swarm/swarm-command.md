# Swarm Command Overview

```bash
#! /bin/bash

# initialize a new swarm
docker swarm init \
--advertise-addr 10.0.0.1:2377 \ # other nodes should use to connect to this manager, but it gives you control over which IP gets used on nodes with multiple IPs,or a load balancer IP
--listen-addr 10.0.0.1:2377  # specify which IP and port listens on for swarm traffic.

# list the nodes in the swarm
docker node ls

# extract tokens required to add a new workers 
docker swarm join-token worker

# add a worker
docker swarm join --token SWMTKN-1-..... 10.0.0.1:2377 --advertise-addr 10.0.0.4:2377 --listen-addr 10.0.0.4:2377

# extract token required to add a new manager
docke swarm join-token manager

# add a manager
docker swarm join --token SWMTKN-1-.... 10.0.0.1:2377 --advertise-add 10.0.0.4:2377 --listen-addr 10.0.0.4:2377

# Restarting an older manager or restoring an old backup has the potential to comppromise the cluster. Old managers re-joining a swarm automatically decrpt and gain access to the Raft log time-serires database - this can pose security concerns. Restoring old backups can wipe the current swarm configuration. To prevent situations like these, Docker allows you to lock a swarm with the Autolock feature. This forces managers that have been restarted to present the cluster unlock key before being permitted back into the cluster. It's possbile to apply a lock direcly to a new swarm you are creating by passing  the --autolock flag to the docker swarm init command. However, you may lock existirng swarm with the docker swarm update
docker swarm update --autolock=true

# unlocak the swarm for the restarted manager with unlock key
docker swarm unlock

# create docker service
docker service create --name web-fe \
-p 8080:8080 \
--replicas 5 \
nigelpoulton/pluralsight-docker-ci

# list of all services running on a swarm
docker service ls

# shows node in the swarm it's executing on show desired state and actual state
docker service ps <service-name | service-id>

# detailed information about a service
docker service inspect --pretty <service-name | service-id>
```