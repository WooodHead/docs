# Linux Command Overview

## Network

```bash
#!/bin/bash

curl -s localhost:80 >/dev/null && echo Connected. || echo Fail.
```

## File , Folder

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

# find open files with pid
lsof -a -p <pid>

# find docker install path
ps -elf|grep docker
lsof -a -p <pid>
sudo find / -name <filename>   -- docker.sock

# list files top 10
ls -la | head -n <number>
ls -la | head -n 10

# file multiply files by filenames
find . \( -name '150157196*' -o -name '15023306*' \)
find . \( -name '1545880018157.vsd' -o -name '1545617257706.pdf' -o -name '1545880675288.xlsx' \)
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

# get username by uid
awk -v val=1000 -F ":" '$3==val{print $1}' /etc/passwd
```

## Hack

```bash
#!/bin/bash

# clear history
~/.bash_history
* [clear history](https://unix.stackexchange.com/questions/203290/how-do-i-clear-the-terminal-history)
```

* [users and groups](https://wiki.archlinux.org/index.php/users_and_groups)
