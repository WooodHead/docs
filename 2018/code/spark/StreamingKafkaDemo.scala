package com.bamboo.demo.catalog.spark
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Minutes, Seconds, StreamingContext}

object StreamingKafkaDemo {
  
  def main(args: Array[String]) {

    var master = "spark://spark114:7077"
    var appName = "demoCatalog"
    val conf = new SparkConf().setAppName(appName).setMaster(master)
    val ssc = new StreamingContext(conf, Seconds(1))
    
    val kafkaParams = Map[String, Object](
        "bootstrap.servers" -> "kafka100:9092",
        "key.deserializer" -> classOf[StringDeserializer],
        "value.deserializer" -> classOf[StringDeserializer],
        "group.id" -> "demo",
        "auto.offset.reset" -> "latest",
        "enable.auto.commit" -> (false: java.lang.Boolean)
    )
    /*
    val kafkaParams = Map[String, String](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "kafka100:9092",
      ConsumerConfig.GROUP_ID_CONFIG -> "demo",
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG ->
        "org.apache.kafka.common.serialization.StringDeserializer",
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG ->
        "org.apache.kafka.common.serialization.StringDeserializer",
      ConsumerConfig.AUTO_OFFSET_RESET_CONFIG -> "latest",
      ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG -> "false",
      "spark.kafka.poll.time" -> "1000"
    )
    */
    val topicsSet = Array("demo")
    val consumerStrategy = ConsumerStrategies.Subscribe[String, String](
            topicsSet, kafkaParams)
    val stream = KafkaUtils.createDirectStream[String, String](
            ssc, PreferConsistent, consumerStrategy)
    val lines = stream.map(_.value())
    lines.print()
    //val lines = stream.map(record => (record.key,record.value))
    //lines.print("==================>"+record.value)
    //stream.map(record => (record.value)).print()
    
    /*
    stream.foreachRDD(rdd => {
        rdd.foreach(record => print("===================>"+record.value));
    })
    */
        
    ssc.start()
    ssc.awaitTermination()
  }
}