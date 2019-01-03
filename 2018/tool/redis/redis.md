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

Kubernetes version
Client Version: version.Info{Major:"1", Mirror:"7", GitVersion:"v1.7.7",GitCommit:"$Format:%H$",GitTreeState:"not a git tree","BuildDate":"2017-11-03T09:30:19Z", GovVersion:"go1.8.5",Compiler:"gc",Platform:"linux/amd64"}
Server Version: version.Info(Major:"1", Mirror:"9+", GitVersion:"v1.9.11-dhc",GitCommit:"1bfeeb5f212146a22dc787b73e109-e5bccef13d,GitTreeState",GitTreeState"dirty",BuildDate:"2018-10-02T05:55:34Z",GoVersion:"go1.9.3",Complier:"gc",Platform:"linux/amd64")

Redis Version:

Issue Enviroment
UAT-Redis : rdbfilename = dump.rdb mountPath: /data(nfs) RunAsRoot: 1000
PROD-Redis : rdbfilename=dump.db  mountPath:/data/prod(nfs) RunAsRoot: 1000

ls -la /data/prod  root:root(uid:gid)

Solution:
首先使用runAsUser:999 制作一个nfspod然后进入pod中创建了/prod/redis目录
使用Redis的Pod中runAsUser:999 设置workingDir=/nfs/prod/redis mountPath=/nfs进行挂载

Key:
要使用runAsUser:999在nfs上创建存储的目录
使用999用户创建pod进行挂载，并制定workingDir
使用{RunAsUser：999} 创建PostgreSQL, Redis等具有postgre(uid):postgre(gid) , reids(uid):redis(gid)非root权限用户
使用{RunAsUser：1000}创建root（uid）：root（gid）

* [Configure a Security Context for a Pod or Container](https://kubernetes.io/docs/tasks/configure-pod-container/security-context/#set-the-security-context-for-a-pod)
* [Permissions on mounted /data volume not correct](https://github.com/docker-library/redis/issues/7)
* [docker redis](https://github.com/litaio/docker-redis/blob/master/Dockerfile)
* [cofig redis using configmap](https://kubernetes.io/docs/tutorials/configuration/configure-redis-using-configmap/)
* [redis config](http://download.redis.io/redis-stable/redis.conf)
* [redis security context run as non-root](https://kubernetes.io/docs/concepts/policy/pod-security-policy/)

## Reference

* [redis gui](https://redislabs.com/blog/so-youre-looking-for-the-redis-gui/)
* [为什么我们做分布式使用 Redis？](https://www.toutiao.com/a6625058550274081287/?iid=51593575316&app=news_article&is_hit_share_recommend=0)