# Linux Command Overview

## Network

* check network

```bash
#!/bin/bash

curl -s localhost:80 >/dev/null && echo Connected. || echo Fail.
```

## File , Folder

* find

```bash
#!/bin/bash

# find a file
find / -name 'ide.conf'

# copy all files in the directory to a directroy without coping directory structure s
find test -type f -exec cp '{}' ./test-temp/ \;

# Finding number of files in a folder
find . -type f | wc -l

# list files owned by a user or group 
find / -group <groupname>
find / -group <groupnumber>
find / -user <username>

# copy directories and files by recusively
cp -r <src_dir> <des_dir>

```

## Storage

```bash
#!/bin/bash

# find max size file
du -a /var | sort -n -r | head -n 10

# show storage
df -lh
```

## Security

```bash
#!/bin/bash
# list all existing user
sudo passwd -Sa
cat /etc/passwd

# list all groups on the system
cat /etc/group

# add group
sudo usermod -aG <group> <user>

# change owner
sudo chown <user> <dest>

# show owning user
stat -c %U <dir>

# show owning group
stat -c %G <dir>

# show access right
stat -c %A <dir>
```

* [users and groups](https://wiki.archlinux.org/index.php/users_and_groups)