# PostgreSql Commands

## Common Commands

```bash
#!/bin/bash
# version
psql --version

# check postgres user
cat /etc/passwd

# change postgres password
passwd postgres

# check authentication config
cat  /usr/local/var/postgres/pg_hba.conf

# list database
\l

# select database
\c <database>

# list tables
\dt

# describe table
\d+ <table_name>

```

## Initializing PostgreSQL

```bash
#!/bin/bash
# template1 is a database created by postgres itself,
psql -d template1
```

## Backup

```bash
#!/bin/bash

# Access postgresql pod
Kubectl exec –it uat-postgre-0 sh
# Dump database
cd /usr/lib/postgresql/11/bin
pg_dump -U postgres demand_core > /var/lib/postgresql/data/dbfiles/demand_core_20190104.sql
cd /var/lib/postgresql/data/dbfiles/
# Compress
tar czvf demand_core_20190104.tar.gz demand_core_20190104.sql
# Copy fie from pod to build server
kubectl cp uat-postgres-0:var/lib/postgresql/data/dbfiles/demand_core_20190104.tar.gz demand_core_20190104.tar.gz

```