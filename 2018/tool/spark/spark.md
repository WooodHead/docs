# 
  - Resilient Distributed DataSets
    弹性: 当计算过程中内存不足时可刷写到磁盘等外存上，可与外存做灵活的数据交换
    容错: 血统机制,在结构更新和丢失后可随时根据血统进行数据模型的重建
    分布式： 可以分布在多台机器上进行并行计算
    数据集：一组只读的、可分区的分布式数据集合，集合内包含了多个分区。分区依照特定规则将具有相同属性的数据记录放在一起，每个分区相当于一个数据集片段

# Reference
  - [Spark入门 | RDD原理与基本操作](https://mp.weixin.qq.com/s?__biz=MzU0MzQ5MDA0Mw==&mid=2247484107&idx=1&sn=44b2e63a1a276f01dc28adaf8933332a&chksm=fb0be85fcc7c61493ae431a090049ff7af1a61eb6eeefd9076c4ad216122e7320c1df1aa89df&scene=21#wechat_redirect)