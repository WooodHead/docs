# Redis Overview

## Redis Usage Scenarios

* Hash

我在做单点登录的时候，就是用这种数据结构存储用户信息，以 CookieId 作为 Key，设置 30 分钟为缓存过期时间，能很好的模拟出类似 Session 的效果。

* List

可以做简单的消息队列的功能。
可以利用 lrange 命令，做基于 Redis 的分页功能

* Sorted Set

按 Score 进行排列可以做排行榜应用
Sorted Set 可以用来做延时任务取 TOP N 操作

## [Redis maxmemory-policy](https://redis.io/topics/lru-cache)

* noeviction

return errors when the memory limit was reached and the client is trying to execute commands that could result in more memory to be used (most write commands, but DEL and a few more exceptions).

* allkeys-lru

evict keys by trying to remove the less recently used (LRU) keys first, in order to make space for the new data added.

* volatile-lru

evict keys by trying to remove the less recently used (LRU) keys first, but only among keys that have an expire set, in order to make space for the new data added.

* allkeys-random

evict keys randomly in order to make space for the new data added.

* volatile-random

evict keys randomly in order to make space for the new data added, but only evict keys with an expire set.

* volatile-ttl

evict keys with an expire set, and try to evict keys with a shorter time to live (TTL) first, in order to make space for the new data added.

The policies volatile-lru, volatile-random and volatile-ttl behave like noeviction if there are no keys to evict matching the prerequisites.
To pick the right eviction policy is important depending on the access pattern of your application, however you can reconfigure the policy at runtime while the application is running, and monitor the number of cache misses and hits using the Redis INFO output in order to tune your setup.
In general as a rule of thumb:
Use the allkeys-lru policy when you expect a power-law distribution in the popularity of your requests, that is, you expect that a subset of elements will be accessed far more often than the rest. This is a good pick if you are unsure.
Use the allkeys-random if you have a cyclic access where all the keys are scanned continuously, or when you expect the distribution to be uniform (all elements likely accessed with the same probability).
Use the volatile-ttl if you want to be able to provide hints to Redis about what are good candidate for expiration by using different TTL values when you create your cache objects.
The volatile-lru and volatile-random policies are mainly useful when you want to use a single instance for both caching and to have a set of persistent keys. However it is usually a better idea to run two Redis instances to solve such a problem.
It is also worth to note that setting an expire to a key costs memory, so using a policy like allkeys-lru is more memory efficient since there is no need to set an expire for the key to be evicted under memory pressure.

## Redis Issue

### 因nfs权限问题，reids写入持久化写入失败


* [docker redis](https://github.com/litaio/docker-redis/blob/master/Dockerfile)
* [cofig redis using configmap](https://kubernetes.io/docs/tutorials/configuration/configure-redis-using-configmap/)
* [redis config](http://download.redis.io/redis-stable/redis.conf)


## Reference

* [redis gui](https://redislabs.com/blog/so-youre-looking-for-the-redis-gui/)
* [为什么我们做分布式使用 Redis？](https://www.toutiao.com/a6625058550274081287/?iid=51593575316&app=news_article&is_hit_share_recommend=0)