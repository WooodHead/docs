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

# [find get all files modified after <date>](https://stackoverflow.com/questions/848293/shell-script-get-all-files-modified-after-date)

# [Find and sort files by date modified](hhttps://unix.stackexchange.com/questions/29899/how-can-i-use-find-and-sort-the-results-by-mtime)
find . your-options -printf "%T+\t%p\n" | sort -rn | head -n 10

```

## Data and time

```bash
#!/bin/bash

# [stat](https://superuser.com/questions/387042/how-to-check-all-timestamps-of-a-file)
# atime is for Last data access timestamp. let's access the file's data by reading it (less or vim), printing it out (cat) or copy it to another file
# mtime is for Last data modification timestamp. Now let's change the file status, by changing the permission (chmod) or renaming it (mv)
# ctime is for Last file status change timestamp. modify the contents of the file by editing the file
# show atime,mtime,ctime
stat <filename>

# [modified file atime mtime ctime](https://askubuntu.com/questions/62492/how-can-i-change-the-date-modified-created-of-a-file)
# change atime and mtime
touch -t [[CC]YY]MMDDhhmm[.SS]
# change mtime
touch -m [[CC]YY]MMDDhhmm[.SS]
# change atime
touch -a [[CC]YY]MMDDhhmm[.SS]
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
history -c
tput reset
echo -n "">~/.bash_history
```

* [users and groups](https://wiki.archlinux.org/index.php/users_and_groups)
