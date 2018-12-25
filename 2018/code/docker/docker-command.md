#! /bin/bash

```/bash
   # docker run busybox:latest echo "Hello World!" 
   docker run <image>:<tag>

   # build docker image
   docker build -t kubia .

   # show local images
   docker images

   # run a image
   docker run --name kubia-container -p 8080:8080 -d kubia

   # checking running docker container
   docker ps

   # inspect running docker container
   docker inspect <containero-name>

   # start docker container
   docker start <container-name>

   # stop docker container
   docker stop <containero-name>

   # go to container inside
   docker exec -it <container-name> bash

   # remove container
   docker rm <container-name>

```