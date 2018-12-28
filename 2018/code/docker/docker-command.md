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
   docker container run -it ubuntu:lasted /bin/bash
   docker container run -d --name web2 --publish 8081:8080 test:latest

   container un tells the Docker daemon to start a new container
   -it flags tell Docker to make the container interactive and to attach our current shell to the container\'s terminal

    # list all running containers
   docker container ls
   docker container ls -a
   -a flag : tells Docker to list all containers, even those in the stopped state.

    # attaching to running container
   docker container exec -it [container name|container id] bash

   # checking running docker container
   docker ps

   # inspect running docker container
   docker inspect [container-name|container-id]

   # start docker container
   docker start container-name|container-id]

   # stop docker container
   docker stop container-name|container-id]

   # go to container inside
   docker exec -it container-name|container-id] bash

```