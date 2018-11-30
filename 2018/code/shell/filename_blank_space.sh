#!/bin/bash

usage()
{
   echo "Usage: $0 Directory_Name"
   exit 1;
}

test -d "$1" || usage
dir="$1"

ls $dir | \
while read i; do
   mv "$dir/$i" "$dir/$(echo "$i" | sed 's/ /_/g')"
done
