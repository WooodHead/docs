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
# add group
  sudo usermod -aG <group> <user>

# change owner
  sudo chown <user> <dest>
```