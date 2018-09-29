cd integration-tests/fineract-cn-demo-server/build/libs/
java -Ddemoserver.persistent=true -Dcustom.cassandra.contactPoints=127.0.0.1:9042 -Dcassandra.cluster.user=cassandra -Dcassandra.cluster.pwd=password -Dcustom.mariadb.host=localhost -Dcustom.mariadb.user=root -Dcustom.mariadb.password=mysql -jar demo-server-0.1.0-BUILD-SNAPSHOT.jar
