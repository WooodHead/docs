# HBase: Limitations, Advantage & Problems
	
	HBase architecture always has "Single Point Of Failure" feature, and there is no exception handling mechanism associated with it.

## Problems with HBase

	In any production environment, HBase is running with a cluster of more than 5000 nodes, only Hmaster acts as the master to all the slaves Region servers. If Hmaster goes down, it can be only be recovered after a long time. Even though the client is able to connect region server. Having another master is possible but only one will be active. It will take a long time to activate the second Hmaster if the main Hmaster goes down. So, Hmaster is a performance bottleneck.
	In HBase, we cannot implement any cross data operations and joining operations, of course, we can implement the joining operations using MapReduce, which would take a lot of time to designing and development. Tables join operations are difficult to perform in HBase. In some use case, its impossible to create join operations that related to tables that are present in HBase
	HBase would require new design when we want to migrate data from RDBMS external sources to HBase servers. However, this process takes a lot of time.
	HBase is really tough for querying. We may have to integrate HBase with some SQL layers like Apache phoenix where we can write queries to trigger the data in the HBase. It's really good to have Apache Phoenix on top of HBase.
	Another drawback with HBase is that, we cannot have more than one indexing in the table, only row key column acts as a primary key. So, the performance would be slow when we wanted to search on more than one field or other than Row key. This problem we can overcome by writing MapReduce code, integrating with Apache SOLR and with Apache Phoenix.
	Slow improvements in the security for the different users to access the data from HBase.
	HBase doesn't support partial keys completely
	HBase allows only one default sort per table
	It's very difficult to store large size of binary files in HBase
	The storage of HBase will limit real-time queries and sorting
	Key lookup and Range lookup in terms of searching table contents using key values, it will limit queries that perform on real time
	Default indexing is not present in HBase. Programmers have to define several lines of code or script to perform indexing functionality in HBase
	Expensive in terms of Hardware requirements and memory blocks allocations.
	More servers should be installed for distributed cluster environments (like each server for NameNode, DataNodes, ZooKeeper, and Region Servers)
	Performance wise it require high memory machines
	Costing and maintenance wise it is also higher
	
## Advantage of HBase:

	Can store large data sets on top of HDFS file storage and will aggregate and analyze billions of rows present in the HBase tables
	In HBase, the database can be shared
	Operations such as data reading and processing will take small amount of time as compared to traditional relational models
	Random read and write operations
	For online analytical operations, HBase is used extensively.
	For example: In banking applications such as real-time data updates in ATM machines, HBase can be used.
	Limitations with HBase:

	We cannot expect completely to use HBase as a replacement for traditional models. Some of the traditional models features cannot support by HBase
	HBase cannot perform functions like SQL. It doesn't support SQL structure, so it does not contain any query optimizer
	HBase is CPU and Memory intensive with large sequential input or output access while as Map Reduce jobs are primarily input or output bound with fixed memory. HBase integrated with Map-reduce jobs will result in unpredictable latencies
	HBase integrated with pig and Hive jobs results in some time memory issues on cluster
	In a shared cluster environment, the set up requires fewer task slots per node to allocate for HBase CPU requirements
	
## Limitations with HBase:

	We cannot expect completely to use HBase as a replacement for traditional models. Some of the traditional models features cannot support by HBase
	HBase cannot perform functions like SQL. It doesn't support SQL structure, so it does not contain any query optimizer
	HBase is CPU and Memory intensive with large sequential input or output access while as Map Reduce jobs are primarily input or output bound with fixed memory. HBase integrated with Map-reduce jobs will result in unpredictable latencies
	HBase integrated with pig and Hive jobs results in some time memory issues on cluster
	In a shared cluster environment, the set up requires fewer task slots per node to allocate for HBase CPU requirements

# Reference

  - [ HBase: Limitations, Advantage & Problems](https://www.guru99.com/hbase-limitations-advantage-problems.html)