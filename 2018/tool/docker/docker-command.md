# Docker Command

```bash
#!/bin/bash

docker build -t kubia .
docker run <image>
docker run <image>:<tag>
docker run --name kubia-container -p 8080:8080 -d kubia
docker images
docker ps
docker inspect kubia-container
docker exec -it kubia-container bash
docker stop kubia-container
docker rm kubia-container
docker tag kubia luksa/kubia
docker images | head
docker push luksa/kubia
docker run -p 8080:8080 -d luksa/kubia
docker logs <container id>
```