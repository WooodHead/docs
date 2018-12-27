#! /bin/bash

```/bash
   # docker run busybox:latest echo "Hello World!" 
   docker run <image>:<tag>

   # build docker image
   docker image build -t kubia:latest .

   # show local images
   docker images

   # run a image
   docker run --name kubia-container -p 8080:8080 -d kubia
   
   docker container run -d \
   --name web1 \
   --publish 8080:8080 \
   test:lastest

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

   # remove container
   docker rm container-name|container-id]

   # tag container
   docker tag kubila  <docker Hub ownId>/<image>

   # push image
   docker push <tag>

   # list image
   docker image ls

   # list all running containers
   docker container ls
   docker container ls -a
   -a flag : tells Docker to list all containers, even those in the stopped state.

   # launch a container from it
   docker container run -it ubuntu:lasted /bin/bash 
   container un tells the Docker daemon to start a new container
   -it flags tell Docker to make the container interactive and to attach our current shell to the container's terminal

   # attaching to running container
   docker container exec -it [container name|container id] bash

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