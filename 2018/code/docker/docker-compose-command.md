# docker-compose command

```bash
#!/bin/bash

# depoly a compose app
docker-compose up &
docker-compose -f <compose.yml> up -d
-f flag : default name is docker-compose.yml or docker-compose.yaml,otherwise using -f to sepecify
-d flag : to bring the app up in the background
& flag : it\'s running in the foreground. This means we get a verbose output to the terminal

# bring compose down
docker-compose down
to stop and delete the app,It deletes containers and networks,but its images,volumes and source code remain

# show the current state of the app
docker-compose ps
It shows current state, the command each one is running ,and network ports

# list the processes running inside of each service
docker-compose top

# stop the app without deleting its resources
docker-compose stop
Stopping a compose app doest not remove the application definition from the system. It just stops the all of the containers in an app.

# delete the containers and networks the app is using
docker-compose rm
It will not delete volumes or images. Nor will it delete the application source code (.yml)

# restart the docker compose
docker-compose restart
the stopped compose app can be easily restarted with restart
If you have made changes to your compose app since stopping it,these changes will not apper in the restarted app. You will need to re-deploy the app to get the changes.
```