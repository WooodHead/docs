# Redis Command

```bash
#!/bin/bash

redis-cli

# get redis cofig
config get *

# set redis config
config set save "600 1 300 100 60 10000"
```