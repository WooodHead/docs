# Senior Java Enginner  - Alipay

## First

* JVM中的老年代在什么情况下会触发GC？
* CMS的垃圾回收步骤，G1和CMS的区别？
* CMS哪个阶段是并发的，哪个阶段是串行的？
* 谈谈Java线程池，线程池中几个参数含义
* 谈谈你了解的J.U.C包的JDK源码（CAS、AQS、ConcurrentHashMap、ThreadLocal、CyclicBarrier、CountDownLatch、Atom、阻塞队列等等）
* JVM性能调优的方法和步骤，JVM的关键性核心参数配置
* Java线程锁有哪些，优劣势
* HashMap的实现原理，JDK1.8做了哪些修改？
* 画一个完整的多线程状态图
* 都知道什么排序，希尔排序，归并排序，快排都如何实现，还有复杂度问题
* 讲一讲红黑树，以及红黑树插入一个结点的时间复杂度
* mysql如何在RR隔离级别下避免幻读问题
* mysql范式和反范式的区别以及彼此的优缺点
* java 线程池的实现原理，threadpoolexecutor关键参数解释
* hashmap的原理，容量为什么是2的幂次
* 为什么要同时重写hashcode和equals
* ConcurrentHashMap如何实现线程安全？
* 介绍Java多线程的5大状态，以及状态图流转过程
* 介绍下Synchronized、Volatile、CAS、AQS，以及各自的使用场景
* B+树和红黑树时间复杂度
* 如果频繁老年代回收怎么分析解决
* JVM内存模型，新生代和老年的回收机制
* mysql limit分页如何保证可靠性
* HaspMap底层原理？HaspTable和ConcurrentHashMap他们之间的相同点和不同点？
* 由上题提到锁的问题
* MySQL的表锁&行锁&乐观锁&悲观锁,各自的使用场景
* Java线程锁有哪些，各自的优劣势
* 事务四大特性
* 事务的二段提交机制？
* 聚簇索引&非聚簇索引
* G1回收器讲下回收过程
* Tcp三次握手，四次挥手大概讲一下？
* 类加载过程
* 双亲委派机制及使用原因
* JVM GC算法有哪些，目前的JDK版本采用什么回收算法
* Http&Https的区别
* Https的加密方式
* 线程池的核心参数和基本原理
* 线程池的调优策略
* JVM垃圾回收算法和垃圾回收器有哪些，最新的JDK采用什么算法。
* 新生代和老年代的回收机制。
* 讲一下ArrayList和linkedlist的区别，ArrayList与HashMap的扩容方式。
* Concurrenthashmap1.8后的改动。
* Java中的多线程，以及线程池的增长策略和拒绝策略了解么。
* Tomcat的类加载器了解么
* Spring的ioc和aop，Springmvc的基本架构，请求流程。
* HTTP协议与Tcp有什么区别，http1.0和2.0的区别。
* Java的网络编程，讲讲NIO的实现方式，与BIO的区别，以及介绍常用的NIO框架。
* 索引什么时候会失效变成全表扫描
* 介绍下分布式的paxos和raft算法

## Second

* mysql 索引类别有哪些，什么是覆盖索引
* mysql如何获取慢SQL，以及慢查询的解决方式
* mysql 主从同步如何配置，工作原理
* 乐观锁和悲观锁、行锁与表锁、共享锁与排他锁（inndob如何手动加共享锁与排他锁）
* 死锁判定原理和具体场景
* 谈谈事务的ACID
* 数据库崩溃时事务的恢复机制
* 分布式全局唯一ID的生成方式有哪几种？以及每种之间的优劣势比较？
* 分布式Session有哪几种？一般使用哪一种，为什么？
* 谈谈Redis一致性Hash算法的理解
* java nio，bio，aio，操作系统底层nio实现原理
* Spring IOC，autowired如何实现
* Spring事务传播机制
* 线程死锁排查
* MySQL引擎及区别，项目用的哪个，为什么
* RPC为什么用http做通信？
* RPC两端如何进行负载均衡？
* mycat分库分表、读写分离的实现
* 分布式数据如何保证数据一致性
* 高并发请求处理，流量削峰措施有哪些
* java 什么时候发生死锁
* 如何避免死锁
* B+ 树的原理
* 分布式一致性协议，二段、三段、TCC，优缺点
* 分布式架构与微服务的关系
* DNS解析过程
* 线程池实现过没？
* Spring IOC、AOP
* SpringBoot、SpringCloud的一些应用
* ACID CAP BASE理论，以及RPC过程
* 消息队列的使用场景，谈谈Kafka。
* 你说了解分布式服务，那么你怎么理解分布式服务。
* Dubbo和Spring Clound的区别，以及使用场景。
* 讲一下docker的实现原理，以及与JVM的区别。
* MongoDB、Redis和Memcached的应用场景，各自优势
* MongoDB有事务吗
* Redis说一下sorted set底层原理
* 讲讲Netty为什么并发高，相关的核心组件有哪些

## Third

* Redis集群方案应该怎么做？都有哪些方案？
* 如何实现集群中的session共享存储？
* memcached与redis的区别？
* 有使用过哪些阿里的开源中间件？相关的中间件有做个性能比较吗？
* 服务器雪崩的场景，一般是由什么引起的？如何来设计应对
* 谈谈springboot,springcloud、dubbo的设计原理和应用场景
* Docker与JVM的区别？
* 高并发的解决方案有哪些，重点谈谈方案的优先级步骤？
* 谈谈你参与过的最有挑战的技术项目
* Redis持久化RDB和AOF 的区别
* MQ底层实现原理
* 详细介绍下分布式 一致性Hash算法
* nginx负载均衡的算法
* Nginx 的 upstream目前支持 哪4 种方式的分配
* 分布式集群部署后，从应用端哪些需要怎么调整
* Dubbo默认使用什么注册中心，还有别的选择吗？
* mongoDB、redis和memcached的应用场景，各自优势
* 谈谈你性能优化的实践案例，优化思路？
* 两千万用户并发抢购，你怎么来设计？
* 项目中用的中间件的理解（Dubbo、MQ、Redis、kafka、zookeep）
* 参与过类似秒杀的项目？你认为这样的项目挑战在哪里，怎么解决
* 项目中遇到的最大问题和解决策略
* 生活中遇到的最大的挫折
* 生活中遇到的最大的令你最有成就感的事情
* 完整的画一个分布式集群部署图，从负载均衡到后端数据库集群。
* 分布式锁的方案，Redis和Zookeeper那个好，如果是集群部署，高并发情况下哪个性能更好。
* 分布式系统的全局id如何实现。
* 数据库万级变成亿级，你如何来解决。
* 常见的服务器雪崩是由什么引起的，如何来防范。
* 异地容灾怎么实现
* 常用的高并发技术解决方案有哪些，以及对应的解决步骤

## Reference

* [支付宝高级研发](https://www.toutiao.com/a6623722674445091342/?iid=50049209260&app=news_article)
* [支付宝Java开发](https://www.toutiao.com/a6621136524396200455/?iid=50049209260&app=news_article)
* [蚂蚁三面面经](https://www.toutiao.com/a6620768706744025603/?iid=50049209260&app=news_article)
* [蚂蚁中间件团队](https://www.toutiao.com/a6620392150087516680/?iid=46426147463&app=news_article)