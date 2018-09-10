# hadoop overview

# hadoop installation

    ```
    sudo tar -zxvf hadoop-2.7.5.tar.gz -C /opt
    
    sudo vi /opt/hadoop-2.7.5/etc/hadoop/hadoop-env.sh
    export JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::")
    
    echo "export PATH=/opt/hadoop-2.7.5/bin:$PATH" | sudo tee -a /etc/profile
    source /etc/profile
    
    mkdir ~/source
    cp /opt/hadoop-2.7.5/etc/hadoop/*.xml ~/source
    
    hadoop jar /opt/hadoop-2.7.5/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.3.jar grep ~/source ~/output 'principal[.]*'
    ```

  - [hadoop installatoin](https://www.vultr.com/docs/how-to-install-hadoop-in-stand-alone-mode-on-centos-7)