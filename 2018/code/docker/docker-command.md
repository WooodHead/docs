#! /bin/bash


## Basic

```bash
#!/bin/bash

   # view system info
   docker system info

   # docker version
   docker --version

   # docker compose version
   docker-compose version

   # docker machine version
   docker-machine version s

   # notary version
   notray version

   # view service
   docker service ls

   # docker network
   docker network ls

   # detail network
   docker network inspect <network-name>

   # docker volume
   docker volume ls

   # find where the volume is exposed on the Docker host
   docker volume inspect <container-volume> | grep Mount

```

## Images

```bash
#!/bin/bash

   # build docker image
   docker image build -t kubia:latest .
   docker image build --no-cache=true kubia:latest
   -t flag: tags the image
   -f flag: use a Dockerfile with an arbitary name and in an arbitary directory
   --no-cache flag: build process to ignore the entire caceh by passing

   # view the instruction that were used to build the image 
   docker image history [container-name|container-id]

   # show local images
   docker images

   # tag container
   docker image tag kubila  <docker Hub ownId>/<image>:<tag>

   # pull image
   docker image pull <-a>  <repository>:<tag>
   -a flag : pull all of the images in a repository
   docker image pull ubuntu:latest
   docker image pull mongo:3.3.11
   docker image pull alpine:latest
   docker image pull microsoft/powershell:nanoserver
   docker image pull microsoft/dotnet:latest
   docker image pull gci.io/kubernetes:latest
   docker image pull <image>:<tag> go version
   go version: OS/CPU architecture of the host system liunx/amd64 or window/amd64

   # push image
   docker image push <image>:<tag>

   # list image
   docker image ls
   docker image ls --filter=reference="*:latest"
   docker image ls --format "{{.Respository}}":"{{.Tag}}":"{{.Size}}"
   docker image ls --digests <image>

   # remove images
   docker image rm -a [container-name|container-id]
   docker image rm $(docker image ls -q) -f

   -a flag: docker will also remove all unused images(those not in use by any containers)
   Deleting an image will remove the image and all of its laysers from your Docker host. This means it will no longer show up in docker image ls commands, and all directories on the Docker host containing the layer data will be deleted. However, if an image layer is shared by more than one image, that layer will not be deleted until all images that reference it have been deleted.
   -q returns a list containing just the image IDs

   Error response from daemon:conflict : unable to remove repository reference "<image-name>" (must force) - container <container-id> is using its referenceed image

   The Cause is that attempting to delete an iamge without stopping and destorying all containers using

   # search image
   docker search <image> --limit=10
   docker search <name> --filter "is-official=true"
   docker search alpine --fliter "is-automated=true"

   # view image layers
   docker image inspect <image>:<tag>

```

## container

```bash
#!/bin/bash

    # docker container run and docker service create commands to start one or more container from a single image
   docker container run -d \
   --name web1 \
   --publish 8080:8080 \
   test:lastest

   # launch a container from it
   docker container run <options> <image>:<tag> <app>
   docker container run -it ubuntu:lasted /bin/bash
   docker container run -d --name web2 --publish 8081:8080 test:latest
   -it flag : connect your terminal window to the container\'s shell
   -d flag: starting a container in the background does not attach it to your terminal. -d flag instead of -it to tell the container to run in the background.
   -p flag: maps ports on the Docker host to ports inside the container. This time we\'re mapping port 8081 on the Docker host to port 8080 inside the container. This means that traffic hitting the Docker host on port 8081 will be directo to port 8080 inside of the container.

   docker container run alpine:latest sleep 10
   The container will start, run for 10 seconds and exit

   container un tells the Docker daemon to start a new container
   -it flags tell Docker to make the container interactive and to attach our 
   current shell to the container\'s terminal

   docker container run --name <container-name> -it --restart always <imange>:<tag> sh
   --restart always : restart automatically with always policy

   # verfiy stlling running container
   docker container ps

    # list all running containers
   docker container ls
   docker container ls -a
   -a flag : tells Docker to list all containers, even those in the stopped state.
   the "docker container ls" command will show the container as running ans show the ports that are mapped.

    # attaching to running container
   docker container exec -it [container name|container id] bash. This is becasuse this command created a new Bash or PowerShell process and attached to that. This means that typing exit in this shell will not terminate the container, because the original ]Bash or PowerShell process will continue running.

   you can re-attach your terminal to it with docker container exec command

   # inspect running docker container
   docker inspect [container-name|container-id]
   It will show you detailed configuration and runtime information about a container.

   # start docker container
   docker container start [container-name|container-id]
   It will restart a stopped(Exited) container.

   # enter container
   docker container exec -it [container-name|containerid] bash
   Lets you run a new process inside of a running container. It\'s useful for attaching the shell of your Docker host to a terminal inside of a running container. This command will start a new Bash shell inside of a running container and connect to it

   # stop docker container
   docker container stop [container-name|container-id]
   stop command is far more polite. it gives the process inside of the container a heads-up that it\'s about to be stopped, giving it chance to get things in order before the end comes. the magic behind the sences here can be explained with Linux/POSIX signals. docker container stop sends a SIGTERM singal to the PID 1 process inside of the container. As we just said, this gives the process a chance to clean things up and gracefully sht itself down. If it doesn\'t exit with 10 seconds, it will receive a SIGKILL. This is effectively the bullet to the head. But hey, it got 10 seconds to sort itself out first!

   # pause container
   docker container pause [container-name|container-id]
   stopping or pausing the container does not destroy the container or any data stored in it.

   # rm  docker container 
   docker container rm  [container-name|container-id]
   docker container rm  [comtainer-name|container-id] -f
   -f flag : the container will be killed without warning.
   "docker container rm [container-name|container-id] -f" doesn\'t bother asking nicely with SIGTERM, it goes straight to the SIGKILL.
   docker container rm $(docker container ls -aq) -f
   The procedure will forcible destory all cainters without giving them a chance to clean up. This should never be performed on production system or systems running important containers.

  # main process
  docker container run --name percy -it alpine:latest /bin/bash
  docker container stop percy
  docker container ls [-a]
  docker container start percy
  docker container exec -it percy bash

```

## Networking

```bash
#! /bin/bash

   # docker network
   docker network ls

   # detail configuration information about network
   docker network inspect <network-name>
   docker network inspect <network-name> --format '{{json.Containers}}'

   # create a new single-host bridge network called 'localnet'
   # by default, it creates them with nat drier on windows, and the bridge drier on Linux.
   docker network create -d bridge <network-name> # -d flag: specify the type of network (network driver)
   docker service create --name test \
   --network <overlay-network-name> \
   --replica 2 \
   <image-name>:<tag> sleep infinity

   # delete all unused networks on a docker host
   docker network prune

   # delete specific network on a docker host
   docker network rm <network-name>

   # create a new container and attach it to the specified bridge network
   docker container run -d --name <container-name> \
   --network <network-name> \
   <image-name> sleep 1d

   # verify the port mapping 
   docker port <container-id>
   # 80/tcp ->0.0.0.0:5000 This shows that port 80 in the container is mapped to prot 5000 on all inerfaces on the Docker host

   # create macvlan 
   # This will create the "macvlan100" network and the eth0.100 sub-interface. MACVLAN uses standard Linux sub-interfaces, and you have to tag them with the ID of the VLAN they will connect to. In this example we're conntecting to VLAN 100, so we targ the sub-inferface with .100 (eth0.100). We also used the --ip-range flag to tell the MACVLAN network which sub-set of IP addresses it can assign to containers. It's vital that this range of address be reserved for Docker and not in use by other nodes for DHCP servers.
   docker network create -d macvlan \
   --subnet=10.0.0.0/24 \
   --ip-range=10.0.0.0/25 \
   --gateway=10.0.0.1 \
   -0 parent=eth0.100
   macvlan100

   # deploy the macvlan network
   # If you can't get this work, it might be because the host NIC is not in promiscuous mode.
   # Remember that public cloud platforms do not allow promiscuous mode.
   docker container run -d --name mactainer1 \
   --network macvlan100 \
   alpine sleep 1d

   # view log
   docker logs <container-name | service-name>

   # cnofig dns
   docker container run -d --name <container-name> \
   --dns=8.8.8.8 \ # Google DNS server
   --dns-serch=dockercrets.com \ #search domain
   alpine sh
```

* ![Docker Networking MACVLAN example](img/docker-network-macvlan-example.png)