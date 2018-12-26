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

find / -name 'ide.conf'
```

## Security

* add group

  sudo usermod -aG <group> <user>

* change owner

  sudo chown <user> <dest>