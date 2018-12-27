# Docker Overview

* [Docker Command](docker-command.md)

## Docker Concepts

* Why do we have containers?
* What do they do for us?
* Where can we use them?
* kernel namespaces
* control groups
* union filesystems
* Solomon Kykes
* Moby used to refer to the open-source Docker project on github “ https://github.com/moby/moby”
* dotCloud PaaS 2013 --> Docker Inc , Ben Golub
* Dockercon
* Docker Certified Associate
* somebody who loads and unloads cargo from ships
* Each Community Edition will be supported for 4 months
* Each Enterprise Edition will be supported for 12 months
* Docker version numbers follow the YY.MM-xx from Q1,2017, Dokcer 1.13 the last version.
* Batteries included but removable
* co-opetition( a balance of co-operation and competition)
* frenemy(a mix of a friend and an enemy)
* Open Container Initiative - ecosystem
* OCI is a governace council responsible for standardizing the most fundamental componets of container infrastructure such as image format(image-spec) and container runtime(runtime-spec),the first version was released in July 2017
* Rocket
* [HyperKit](https://blog.docker.com/2016/05/docker-unikernels-open-source/)
* Docker EE includes Docker Trusted Registry and Universal Control Plane
* storage driver
* devicemapper
* follows the tried-and-tested Unix philosophy
* "daemonless containers" it makes it possible to perform maintenance and upgrades on the Docker daemon without impacting running containers
* images are considered build-time constructs
* containers are considered run-time constructs

## Upgrading Docker

* upgrading process
 
1. Stop the Docker daemon
2. Remove the old version
3. Install the new version
4. configure the new version to automatically start when the system boots
5. Ensure containers have restarted

* ubuntu upgrading docker

1. apt-get update
2. apt-get remove docker docker-engine docker-ce docker.io -y
3. wget -qO- https://get.docker.com/ | sh
4. systemctl enable docker
5. systectl is-enabled docker
6. docker container ls

## Storage drivers

* aufs(the original and oldest)
* overlay2(probably the best choice for the future)
* devicemapper
* btrfs
* zfs
* windowsfilter(windows only which implements layering and Copy-on-Write on top of NTFS)

A storage driver is a per node decision. This means a single Docker host can only run a single storage driver

```json

  /etc/.docker/daemon.json
  {
      "storage-driver": "overlay2"
  }
```

If someone change the storage driver on an already-running Docker host, existing images and containers will not be available after Docker is restarted. This is because each storage driver has its own subdirectory on the host whsere it stores image laysers(usually /var/lib/docker/<storage-driver>)

## Devicemapper

* Block devices.
  You need to have block devices available in order to configure direct-lvm mode. Thess should be high performance external LUNs. If your Docker environment is on-promises, external LUNs can be on FC,iSCSI, or other block-protocol storage cloud, these can be any form of high performance block storage(usually SSD-based) supported by your cloud provider.

* LVM config.
  The devicemapper storage driver leverages LVM, the Linux Logical Volume Manager. This means you will need
  to configure the required physical devices(pdev), volume group(vg), logical volumes(lv), and thinpool(tp). You should use dedicated physical volumes and form them into a new volume group. You should not share the volume group with non-Docker workloads; one for data and the otehr for metadata. Create an LVM profile spefifying the auto-extend threshold and auto-extend values,and configure monitoring so that auto-extend operations can happen.

* Docker config
  The current Docker config file(/etc/docker/daemon.json) and then update it as follows. The name of the dm.thinpooldev might be different in your environment and you should adjust as appropriate.

```json
  {
    "storage-driver": "devicemapper",
    "storage-opts":[
      "dm.thinpooldev=/dev/mapper/docker-thinpool",
      "dm.use_deferred_removal=true",
      "dm.use_deferred_deletion=true"
    ]
}
```

## Local Docker socket

```bash
#!/bin/bash

  ls -la /var/run/docker.sock
```

## priviledges

  if to use 'sudo docker version' command to get right response, you will need to add use account to the local docker group.

## Docker Engine

* [Docker Engine Monolithic High Level View - v0.9](img/docker-engine-monolithic-high-level.png)
* [Docker Engine Modular High Level View  v1.0-](img/docker-engine-modular-high-level.png)
* [Docker Engine Architecture High Level](img/docker-engine-architecture-high-level.png)

The tool called runc is the reference implementation of the OCI container-runtime-spec.
from Docker 1.11(early 2016),in fact, It is a small,lightweight CLI wrapper for libcontainer(originally replaaced LXC in the early Docker architecture)

A new tool called containerd(pronounced container-dee) is to manage container lifecycle operation - start | stop | pause | rm ... since 1.11 release. containerd sits between the daemaon and runc at the OCI layer. Kubernetes can also use
containered via cri-containerd. It was developed by Docker, Inc and donated to Cloud Native Computing Foundation(CNCF). It released version 1.0
in December 2017.

Docker client converts the commands into the approprivate API payload and POSTs them to the correct API endpoint. the API implemented in the daemaon. The daemon communicates with containerd via a CRUD-style API over gRPC. till now, daemon includes : image management, image builds, the REST API, authentication, security, core networking and orchestration.

The shim is integral to the implementation of daemonless containers(about decoupling running containers from the daemon for things like daemon upgrades). the containerd uses runc to create new containers. In fact, it forks a new instance of runc for every container it creates. However, once each container is created, its parent runc process exits. This means we can run hundreds of containers without having to run hundreds of runc instances. Once container's parent runc process exits, the associated containerd-shim process becomes teh container's parent. Some of the responsibilities the shim performs as a container's parent include:

* keeping any STDIN and STDOUT streams opens so that when the daemon is restarted, the container doesn't terminate due to pipes being closed etc.
* Reports the container's exit status back to the daemon.

dockerd(the Docker daemon)
docker-containerd(containerd)
docker-containerd-shim(shim)
docker-runc(runc)

## Image Registries

Docker image are stored in image registries. The most common registry is Docer Hub(httlps://hub.docker.com) Other registires exists, including 3rd party registries and secure on-promises registires.

Most of the popular operating system and applications have their own official repositories on Docker Hub. They're easy to spot because they live at the top level of the Docker Hun namespace. the following list contains a few of the official repositories, and shows their URLs that exist at the top-level of the Docker Hub namespace:

* nginx: https://hub.docker.com/_/nginx/
* busybox: https://hub.docker.com/_busybox/
* redis: https://hub.docker.com/_/redis/
* mongo: https://hub.docker.com/_/mongo/

## Images and Layers

 [Docker Image Layer](img/docker-image-layer.png)
 docker image inspect alpine:latest

## Image Digests

Docker 1.10 introduced a new content addressable storage model. As port of this new model, all images neow get a cryptographic content hash. /for the purposes of this discussion, we'll refer to this hash as the digest. Becasue the digest is a hash of the content of the image, it is not possible to change the contents of the iamge without the digest also changing. This means digests are immutable. Each layer also gets something called a distribution hash. This is a hash of the compressed version of the layer.

## Note

* It is best practice to use non-root users when working with Docker,then log out and log back to take effect.

```bash
#!/bin/bash
  sudo usermod -aG docker <user>
  cat /etc/group | grep docker
  docker:x:999:<user>
```

* libcontainer

till Docker 0.9, Dokcer depends on LXC which is Linux-specific. after that, Docker. Inc. developed theire own tool called libcontainer as a replacement for LXC. The goal of libcontainer was to be a platform-agnostic tool

* dangling image

  docker image ls --fliter dangling=true

A dangling image is an image that is no longer tagged, and appears in listings as <none>:<none>.
A common way they occur is when building a new image and tagging it with an existing tag. When this happens. Docker will build the new image. notice that an existing image has a matching tag, remove the tag from the existing image, give the tag to the new image. For example, you build a new image based on alpinle:3.4 and tag ti as dodge:challenger. The you update the Docker to replace a alpine:3.4 with alpine:3.5 and run the exact same docker image build command. The build will cerate a new image tagged as dodge:challenger and remove the tags from the older image. The older image will become a dangling image.

Docker currently support the following filters:

1. dangling: Accepts true or false, and returns only dangling iamge(true), or non-dangling image(false)
2. before: Requries an image name or ID as argument, and returns all images created before it
3. since : Same as before, but returns images created after the specified image
4. lable: Filters images based on the presence of a label or label and value. The docke iamge ls command does not display labels in its output.

docker image ls --filter=reference="*:latest"

 

## Reference

* [building docker environment](https://john-hunt.com/2016/06/03/docker-os-x-homebrew-quick-start/)
* [Docker Deep Dive - Nigel Poulton]
* [Play with Docker](https://play-with-docker.com)
* [Open Container](https://github.com/opencontainers)
* [Containerd](https://github.com/containerd)
* [Image Registry](https://hub.docker.com)