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

```

## Images

```bash
#!/bin/bash

   # build docker image
   docker image build -t kubia:latest .

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

   docker container run alpine:latest sleep 10
   The container will start, run for 10 seconds and exit

   container un tells the Docker daemon to start a new container
   -it flags tell Docker to make the container interactive and to attach our 
   current shell to the container\'s terminal

   # verfiy stlling running container
   docker container ps

    # list all running containers
   docker container ls
   docker container ls -a
   -a flag : tells Docker to list all containers, even those in the stopped state.

    # attaching to running container
   docker container exec -it [container name|container id] bash. This is becasuse this command created a new Bash or PowerShell process and attached to that. This means that typing exit in this shell will not terminate the container, because the original ]Bash or PowerShell process will continue running.

   you can re-attach your terminal to it with docker container exec command

   # inspect running docker container
   docker inspect [container-name|container-id]

   # start docker container
   docker container start [container-name|container-id]

   # enter container
   docker container exec -it [container-name|containerid] bash

   # stop docker container
   docker container stop [container-name|container-id]
   stop command is far more polite. it gives the process inside of the container a heads-up that it\'s about to be stopped, giving it chance to get things in order before the end comes. the magic behind the sences here can be explained with Linux/POSIX signals. docker container stop sends a SIGTERM singal to the PID 1 process inside of the container. As we just said, this gives the process a chance to clean things up and gracefully sht itself down. If it doesn\'t exit with 10 seconds, it will receive a SIGKILL. This is effectively the bullet to the head. But hey, it got 10 seconds to sort itself out first!

   # rm  docker container 
   docker container rm  [container-name|container-id]
   docker container rm  [comtainer-name|container-id] -f
   -f flag : the container will be killed without warning.
   "docker container rm [container-name|container-id] -f" doesn\'t bother asking nicely with SIGTERM, it goes straight to the SIGKILL.

  # main process
  docker container run --name percy -it alpine:latest /bin/bash
  docker container stop percy
  docker container ls [-a]
  docker container start percy
  docker container exec -it percy bash

```