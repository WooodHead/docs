#! /bin/bash

#  目标目录 demand-portal-2018-12-12
# 获取Home
HOME_DIR="/home/appadmin"
#  获取目标的根目录
DP_BK_ROOT="demand-portal/bk"
#  获取日期
CURRENT_DATE=`date +"%Y-%m-%d"`
#  创建目标目录
DP_BK_DATE="$HOME_DIR/$DP_BK_ROOT/demand-portal-$CURRENT_DATE"
#  需要备份的目录
DP_SRC_ROOT="$HOME_DIR/demand-portal/uat"

# copy netpol.yaml
cp "$DP_SRC_ROOT/*.yaml" "$DP_BK_DATE/"

#  备份函数

bk_deploy_module() {

  for module in $@
  do 
    mkdir -p "$DP_BK_DATE/$module"
    # *.yaml
    #cp "$DP_SRC_ROOT/$module/*.yaml" "$DP_BK_DATE/$module/"
    # *.sh
    #cp "$DP_SRC_ROOT/$module/*.sh" "$DP_BK_DATE/$module/"
    # *.properties
    #cp "$DP_SRC_ROOT/$module/gradle.properties" "$DP_BK_DATE/$module/"
    # Dockerfile
    #cp "$DP_SRC_ROOT/$module/Dockerfile" "$DP_BK_DATE/$module/"
    cp $DP_SRC_ROOT/$module/* $DP_BK_DATE/$module/
  done
}

bk_deploy_module Acitiviti-Service Common ingress postgres Service-Register User-Service Core-Service APIBean Frontend-Deployment redis

bk_build_module(){
  
  for module in $@
  do 
    mkdir -p "$DP_BK_DATE/$module"
    # build.gradle
    cp "$DP_SRC_ROOT/$module/build.gradle" "$DP_BK_DATE/$module/"
    # gradle.properties
    cp "$DP_SRC_ROOT/$module/gradle.properties" "$DP_BK_DATE/$module/"
    # settings.gradle
    cp "$DP_SRC_ROOT/$module/settings.gradle" "$DP_BK_DATE/$module/"
  done
}

bk_build_module DP-Backend-API-Bean DP-Backend-Common DP-Backend-Service-Register DP-Backend-Activity-Service  DP-Backend-API-Gateway DP-Backend-Core-Service DP-Backend-User-Service 
