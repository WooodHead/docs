# hadoop overview

# hadoop installation

    ```
    sudo tar -zxvf hadoop-2.7.5.tar.gz -C /opt
    
    sudo vi /opt/hadoop-2.7.5/etc/hadoop/hadoop-env.sh
    export JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::")
    
    echo 'export HADOOP_HOME=/opt/hadoop-2.7.5' | sudo tee -a /etc/profile
    echo 'export PATH=$HADOOP_HOME/bin:$PATH' | sudo tee -a /etc/profile
    source /etc/profile
    
    $HADOOP/etc/hadoop-env.sh
    export HADOOP_COMMON_LIB_NATIVE_DIR="${HADOOP_HOME}/hadoop/lib/"
    export HADOOP_OPTS="$HADOOP_OPTS -Djava.library.path=${HADOOP_HOME}/hadoop/lib/"
    
    mkdir -p ~/datas/hadoop
    cp /opt/hadoop-2.7.5/etc/hadoop/*.xml ~/datas/hadoop
    
    hadoop jar /opt/hadoop-2.7.5/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.5.jar grep ~/datas/hadoop ~/output 'principal[.]*'
    ```

  - [hadoop installatoin](https://www.vultr.com/docs/how-to-install-hadoop-in-stand-alone-mode-on-centos-7)