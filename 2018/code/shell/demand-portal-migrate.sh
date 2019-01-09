#!/bin/bash
DATE=`date +%Y-%m-%d`
CORE_SERVICE=`kubectl get po|grep uat-core | awk '{printf $1}'`
echo $CORE_SERVICE
UPDATE_PACKAGE="$DATE.tar.gz"
echo $UPDATE_PACKAGE
tar czvf $UPDATE_PACKAGE $DATE
echo  "Are you sure copy " $UPDATE_PACKAGE " into " $CORE_SERVICE":/uploadDir/upload/migrate"
kubectl cp $UPDATE_PACKAGE  $CORE_SERVICE:/uploadDir/upload/migrate/
