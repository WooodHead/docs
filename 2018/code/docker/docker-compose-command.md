# docker-compose command

```bash
#!/bin/bash

# build all required images
docker-compose up &
docker-compose -f <compose.yml> up -d
-f flag : default name is docker-compose.yml or docker-compose.yaml,otherwise using -f to sepecify
-d flag : to bring the app up in the background
```