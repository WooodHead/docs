# Spark concepts

  - Resilient Distributed DataSets
    弹性: 当计算过程中内存不足时可刷写到磁盘等外存上，可与外存做灵活的数据交换
    容错: 血统机制,在结构更新和丢失后可随时根据血统进行数据模型的重建
    分布式： 可以分布在多台机器上进行并行计算
    数据集：一组只读的、可分区的分布式数据集合，集合内包含了多个分区。分区依照特定规则将具有相同属性的数据记录放在一起，每个分区相当于一个数据集片段
   
# spark innstallation

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
  
# spark integration

## spark streaming / kafka integration 

   - [Spark Streaming + Kafka Integration Guide](http://spark.apache.org/docs/latest/streaming-kafka-integration.html)
   - [Sparking Stream from Kafka to calculate real time top url click stream from an http weblog using Spark Streaming](https://github.com/vhoang55/kafka-spark-streaming-weblog)
   - [Apache Kafka - Integration With Spark](https://www.tutorialspoint.com/apache_kafka/apache_kafka_integration_spark.htm)

# Reference
  - [Spark入门 | RDD原理与基本操作](https://mp.weixin.qq.com/s?__biz=MzU0MzQ5MDA0Mw==&mid=2247484107&idx=1&sn=44b2e63a1a276f01dc28adaf8933332a&chksm=fb0be85fcc7c61493ae431a090049ff7af1a61eb6eeefd9076c4ad216122e7320c1df1aa89df&scene=21#wechat_redirect)
  - [practical real-time data processing and analytics-distributed computing and event processing using apacke spark, storm and kafka-packt publishing]