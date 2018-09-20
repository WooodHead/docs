# Spark concepts

  - Resilient Distributed DataSets
    弹性: 当计算过程中内存不足时可刷写到磁盘等外存上，可与外存做灵活的数据交换
    容错: 血统机制,在结构更新和丢失后可随时根据血统进行数据模型的重建
    分布式： 可以分布在多台机器上进行并行计算
    数据集：一组只读的、可分区的分布式数据集合，集合内包含了多个分区。分区依照特定规则将具有相同属性的数据记录放在一起，每个分区相当于一个数据集片段
    
  - [checkpoint](http://spark.apache.org/docs/latest/streaming-programming-guide.html#checkpointing)
   
# spark installation

   ```
    sudo tar -zxvf spark-2.3.1-bin-hadoop2.7.tgz -C /opt
    
    echo 'export SPARK_HOME=/opt/spark-2.3.1-bin-hadoop2.7' | sudo tee -a /etc/profile
    echo 'export PATH=$SPARK_HOME/bin:$PATH' | sudo tee -a /etc/profile
    source /etc/profile
    
    vim $SPARK_HOME/conf/spark-env.sh 
    export  SPARK_MASTER_HOST=spark114
    export  SPARK_LOCAL_IP=spark114
    
    ./sbin/start-all.sh

    ```

  - [spark scala compatible](https://spark.apache.org/docs/latest/)   
  
# execute spark script

  ```
    spark-submit --class "com.bamboo.demo.catalog.spark.StreamingKafkaDemo" --jars '/home/centos/.ivy2/cache/org.apache.spark/spark-core_2.11/jars/spark-core_2.11-2.3.1.jar' --master spark://spark114:7077 /home/centos/datas/spark/catalog/target/scala-2.11/spark-kafka-project_2.11-1.0.jar
    
    spark-submit --class "com.bamboo.scala.demo.catalog.spark.DemoReadCSVFile" --jars '/home/centos/.ivy2/cache/org.apache.spark/spark-core_2.11/jars/spark-core_2.11-2.3.1.jar' --master spark://spark114:7077 /home/centos/datas/spark/csvfile/target/scala-2.11/com-bamboo-scala-demo-catalog-spark_2.11-0.1.jar

    spark-shell --packages com.databricks:spark-csv_2.11:1.5.0
  ```
  
# spark integration

## spark csv

   - [spark csv](https://github.com/databricks/spark-csv)
   - [Read CSV file in Spark Scala](http://bigdataprogrammers.com/read-csv-file-spark-scala/)
   - [Analysing CSV data in Spark : Introduction to Spark Data Source API](http://blog.madhukaraphatak.com/analysing-csv-data-in-spark/)
   - [filter null value ](https://medium.com/@mrpowers/dealing-with-null-in-spark-cfdbb12f231e )

## spark streaming / kafka integration 

   /root/app/spark-2.1.0-bin-hadoop2.6/bin/spark-submit  --class hdfs.KafkaToHbase --master spark://192.168.1.233:7077 --jars spark.jar,metrics-core-2.2.0.jar,spark-streaming-kafka-0-8_2.11-2.1.0.jar,spark-streaming_2.11-2.1.0.jar,kafka_2.11-1.1.0.jar 1000

   - [Spark Streaming + Kafka Integration Guide](http://spark.apache.org/docs/latest/streaming-kafka-integration.html)
   - [Sparking Stream from Kafka to calculate real time top url click stream from an http weblog using Spark Streaming](https://github.com/vhoang55/kafka-spark-streaming-weblog)
   - [Apache Kafka - Integration With Spark](https://www.tutorialspoint.com/apache_kafka/apache_kafka_integration_spark.htm)
   - [spark-streaming-example-from-slack](https://www.supergloo.com/fieldnotes/spark-streaming-example-from-slack/)
   - [spark streaming examples](https://github.com/mapr/spark/tree/2.0.1-mapr-1611/examples/src/main/scala/org/apache/spark/examples/streaming)
   - [精讲Spark Streaming集成读取kafka0.10及以上版本](https://blog.csdn.net/daerzei/article/details/80085121)

# Reference
  - [Spark入门 | RDD原理与基本操作](https://mp.weixin.qq.com/s?__biz=MzU0MzQ5MDA0Mw==&mid=2247484107&idx=1&sn=44b2e63a1a276f01dc28adaf8933332a&chksm=fb0be85fcc7c61493ae431a090049ff7af1a61eb6eeefd9076c4ad216122e7320c1df1aa89df&scene=21#wechat_redirect)
  - practical real-time data processing and analytics-distributed computing and event processing using apacke spark, storm and kafka-packt publishing
  