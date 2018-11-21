# Senior Java Developer Interview  - Meituan

## First 

* concurrent包下面用过哪些？
* countdownlatch功能实现
* synchronized和lock区别，重入锁
* thread和runnable的区别
* AtomicInteger实现原理(CAS自旋)
* java并发sleep与wait、notify与notifyAll的区别
* 如何实现高效的同步链表
* java都有哪些加锁方式（synchronized、ReentrantLock、共享锁、读写锁等）
* 设计模式（工厂模式、单例模式（几种情况）、适配器模式、装饰者模式）
* maven依赖树，maven的依赖传递，循环依赖

## Second

* synchronized和reentrantLock的区别，synchronized用在代码快、方法、静态方法时锁的都是什么?
* 介绍spring的IOC和AOP，分别如何实现(classloader、动态代理)
* JVM的内存布局以及垃圾回收原理及过程讲一下，讲一下CMS垃圾收集器垃圾回收的流程，以及CMS的缺点
* redis如何处理分布式服务器并发造成的不一致
* OSGi的机制
* spring中bean加载机制，bean生成的具体步骤，ioc注入的方式
* spring何时创建applicationContext
* listener是监听哪个事件？
* 介绍ConcurrentHashMap原理，用的是哪种锁，segment有没可能增大?
* 解释mysql索引、b树，为啥不用平衡二叉树、红黑树
* Zookeeper如何同步配置

## Third

* Java线程池ThreadPoolEcecutor参数，基本参数，使用场景
* MySQL的ACID讲一下，延伸到隔离级别
* dubbo的实现原理，说说RPC的要点
* GC停顿原因，如何降低停顿？
* JVM如何调优、参数怎么调？
* 如何用工具分析jvm状态（visualVM看堆中对象的分配，对象间的引用、是否有内存泄漏，jstack看线程状态、是否死锁等等）
* 描述一致性hash算法（Redis）
* 分布式雪崩场景如何避免?
* 再谈谈Kafka的设计原理

## Reference

* [美团猫眼团队面试题](https://www.toutiao.com/a6625946178183758340/?iid=51593575316&app=news_article×tamp%3D1542762236&group_id=6625946178183758340)
