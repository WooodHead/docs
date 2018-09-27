#!/bin/bash
# Example Script to copy configurations across a cluster
# Rsync's HBase config files across all region servers. Must run on master.
# he second script uses rsync just like the first script, but adds the
# --delete option to make sure the region servers do not have any older files
# remaining but have an exact copy of what is on the originating server.
for srv in $(cat /usr/local/hbase/conf/regionservers); do
  echo "Sending command to $srv...";
  rsync -vaz --delete --exclude='logs/*' /usr/local/hadoop/ $srv:/usr/local/hadoop/   
  rsync -vaz --delete --exclude='logs/*' /usr/local/hbase/  $srv:/usr/local/hbase/
done
echo "done."
