#!/bin/bash
# Example Script to copy the HBase files across a cluster
# Rsync's HBase files across all slaves. Must run on master. Assumes
# all files are located in /usr/local
if [ "$#" != "2" ]; then
  echo "usage: $(basename $0) <dir-name> <ln-name>"
  echo "  example: $(basename $0) hbase-0.1 hbase"
  exit 1
fi
SRC_PATH="/usr/local/$1/conf/regionservers"
for srv in $(cat $SRC_PATH); do
  echo "Sending command to $srv...";
  rsync -vaz --exclude='logs/*' /usr/local/$1 $srv:/usr/local/
  ssh $srv "rm -fR /usr/local/$2 ; ln -s /usr/local/$1 /usr/local/$2"
done
echo "done."