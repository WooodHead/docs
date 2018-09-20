# cassandra overview

# cassandra installation

  ```
    Add the Apache repository of Cassandra to /etc/yum.repos.d/cassandra.repo
    
    # cat  /etc/yum.repos.d/cassandra.repo
    [cassandra] 
    name=Apache Cassandra 
    baseurl=https://www.apache.org/dist/cassandra/redhat/311x/ 
    gpgcheck=1 
    repo_gpgcheck=1 
    gpgkey=https://www.apache.org/dist/cassandra/KEYS
    
    sudo yum install cassandra
    
    Start Cassandra 
        service cassandra start
    Make Cassandra start automatically after reboot:
        chkconfig cassandra on
        
    create keyspace
        CREATE KEYSPACE seshat WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};
        
    list keyspaces
    
        DESCRIBE keyspaces;
  ```

  - [cassandra installation](https://www.linode.com/docs/databases/cassandra/deploy-scalable-cassandra-on-ubuntu-18.04-and-centos-7/)
  - [cassandra installation](http://cassandra.apache.org/download/ )