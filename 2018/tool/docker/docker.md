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
* OCI is a governace council responsible for standardizing the most fundamental componets of container infrastructure such as image format(image-spec) and container runtime(runtime-spec)
* Rocket
* [HyperKit](https://blog.docker.com/2016/05/docker-unikernels-open-source/)
* Docker EE includes Docker Trusted Registry and Universal Control Plane

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
* windowsfilter(windows only)

A storage driver is a per node decision. This means a single Docker host can only run a single storage driver

```json

  /etc/.docker/daemon.json
  {
      "storage-driver": "overlay2"
  }
```

If someone change the storage driver on an already-running Docker host, existing images and containers will not be available after Docker is restarted. This is because each storage driver has its own subdirectory on the host whsere it stores image laysers(usually /var/lib/docker/<storage-driver>)


## Note

* It is best practice to use non-root users when working with Docker,then log out and log back to take effect.

   sudo usermod -aG docker <user>
   
   cat /etc/group | grep docker
   docker:x:999:<user>

## Reference

* [building docker environment](https://john-hunt.com/2016/06/03/docker-os-x-homebrew-quick-start/)

* [Docker Deep Dive - Nigel Poulton]