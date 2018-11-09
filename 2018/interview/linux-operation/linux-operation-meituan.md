# 【岗位定义】系统运维工程师

## 【职位描述】

```
1．制定和优化运维解决方案，包括但不限于柔性容灾、智能调度、弹性扩容与防攻击。

2．主导业务架构的可运维性设计，参与业务系统的设计与实施。

3．推动及开发高效的自动化运维、管理工具，提升运维工作效率。

4．全方位的性能优化，将用户速度体验提升到极致。

5．精确的容量测算和规划，优化运营成本。

6．探索、研究新的运维技术方向。
```

## 【任职资格】

```
1.3年以上运维经验，对立体监控、自动部署、容量管理、自动容灾有较深入的理解和实践经验；

2.对Linux操作系统原理有深入的理解，熟悉 TCP/IP以及常用RPC协议；

3.熟练掌握C/PHP/Python/SHELL等1至2种语言，并有相关开发经验；

4.良好的沟通、组织协调、项目管理能力和强烈的责任心；

5.对行业技术敏感度高且细致，善于思考，乐于发现，对解决具有挑战性问题充满激情。

美团对Linux运维工程师招聘岗位的面试题:
```

## Q & A

* 1、LINUX系统软件安装和卸载的常见方法

```
答： A.rpm包卸载：rpm -e XXX.rpm (如果想忽略依赖，可加上–nodeps)

B.yum remove xxx.rpm 这种方法非常不建议使用，卸载过程会将待卸载的软件包所依赖的软件包一并卸载掉，很容易造成系统缺少某些包而崩溃等问题

C.源码包卸载：cd命令进入编译后的软件目录，即安装时的目录，执行make uninstall命令即可；或者直接删除安装目录
```

* 2、Windows和LINUX常用的远程连接工具有那些

```
答： 命令远程连接工具：Xshell、SecureCRT、Putty、SSH Secure Shell Client等

图形远程连接工具：xmanager（需安装配置服务并打开177端口）、VNC-Viewer（linux需安装vncserver）、windows自带的远程桌面（linux需安装xrdp和vnc）
```

* 3、如何修改LINUX的IP地址、网关和主机名

```
答：

A、修改IP地址、网关：编辑/etc/sysconfig/network-scripts/ifcfg-eth0，修改里面IPADDR和GATEWAY内容，没有这两行，则添加即可，添加时确保BOOTPROTO=static，静态地址，如IPADDR=192.168.1.100 GATEWAY=192.168.1.1

B、修改主机名称：编辑/etc/sysconfig/network，修改里面的HOSTNAME内容，如设置主机名称为mysql，则：HOSTNAME=mysql即可；
```

* 4、编写脚本实现以下功能；

```
每天早上5点开始做备份

要备份的是/var/mylog里所有文件和目录可以压缩进行备份

备份可以保存到别一台器上192、168、1、2 FTP帐号 aaa 密码 bbb

要示每天的备份文件要带有当天的日期标记

答：

[root@haojiu ~]#cat /root/mylogbak.sh
#!/bin/bash
#scripts for dirbakup and upload to ftp server.
#author by haojiu
#create by
bakdir=mylog
date=`date +%F`
cd /var
tar zcf ${bakdir}_${date}.tar.gz ${bakdir}
sleep 1
ftp -n <<- EOF
open 192.168.142.129 #远程ftp服务器IP
user aaa bbb
put mylog_*.tar.gz
bye
EOF
rm -rf mylog_*.tar.gz #这步之前可以做一个判断，判断文件上传成功再执行rm，留给各位发挥吧。
添加crontab:

crontab -l

00 05 * * * /bin/bash /root/mylogbak.sh #每天早上5点开始执行备份脚本
```

* 5、IPTABLES相关的命令

```
（这里大家补充，具体问题还要具体分析）
``

* 6、mysql相关的题：新安装MYSQL后怎样提升MYSQL的安全级别

```
答：

A.修改mysql默认端口

B.linux下可以通过iptables来限制访问mysql端口的IP地址

C.对所有用户设置较复杂密码并严格指定对应账号的访问IP（可在mysql库中user表中指定用户的访问可访问IP地址）

D.root特权账号的处理（建议给root账号设置强密码，并指定只允许本地登录）

E.开启二进制查询日志和慢查询日志

F.mysql安装目录及数据存储目录权限控制：给mysql安装目录读取权限，给mysql日志和数据所在目录读取和写入权限

G.删除无用mysql账号和删除无用的数据库（安装好的mysql默认会有个test库，可将其删除）

MYSQL的主从原理，怎么配置文件

答： 整体上来说，复制有3个步骤：

A.master将改变记录到二进制日志(binary log)中（这些记录叫做二进制日志事件，binary log events）；

B.slave将master的binary log events拷贝到它的中继日志(relay log)；

C.slave重做中继日志中的事件，将改变反映它自己的数据。

Mysql复制的基本原理过程如下：

（1）Slave上面的IO线程连接上Master，并请求从指定日志文件的指定位置（或者从最开始的日志）之后的日志内容；

（2）Master接收到来自Slave的IO线程的请求后，通过负责复制的IO线程根据请求信息读取指定日志指定位置之后的日志信息，返回给Slave端的IO线程。返回信息中除了日志所包含的信息之外，还包括本次返回的信息在Master端binary log文件的名称以及在Binary log中的位置；

（3）Slave的IO线程收到信息后，将接收到的日志内容依次写入到Slave端的RelayLog文件（mysql-relay-lin.xxxxx）的最末端，并将读取到的Master端的bin-log的文件名和位置记录到master-info文件中，以便在下一次读取的时候能够清楚的告诉master“我需要从某个bin-log的哪个位置开始往后的日志内容，请发给我”

（4）Slave的SQL线程检测到Relay Log中新增加了内容后，会马上解析该Log文件中的内容成为在Master端真实执行时候的那些可执行的查询或操作语句，并在自身执行那些查询或操作语句，这样，实际上就是在master端和Slave端执行了同样的查询或操作语句，所以两端的数据是完全一样的。

补充：mysql主从复制的优点————

<1> 如果主服务器出现问题， 可以快速切换到从服务器提供的服务；

<2> 可以在从服务器上执行查询操作， 降低主服务器的访问压力；

<3> 可以在从服务器上执行备份， 以避免备份期间影响主服务器的服务。

为MYSQL添加一个用户

mysql> grant select,insert,update,delete on book.* to test2@localhost identified by “abc”; #增加test2用户，密码为abc。并只能在localhost这台主机上登录，并且只能访问book这个库中的表，具有查询，插入，更新，删除权限；

语法：mysql> GRANT <权限> ON <库>.<表> TO ‘用户’@’主机名’ identified by “密码”;
```

* 7、WINDOWNS相关的问题

```
你是否对WINDOWNS系统打过补丁，如果有100台你会怎么做

答： （题主是一个不专业的MCSE，记得在win2003中，有发布指派这个概念的，请各位网友补充）在域环境中，应该是将一台服务器作为域控补丁的update服务器，利用“发布与指派”的功能，将补丁批量更新到内网其他服务器；

WINDOWNS下怎么为MYSQL做定时完全备份

答： 批处理+计划任务+ftp上传至远程服务器

在没有硬件防火墙的情况下，怎样提高WINDOS系统安全

答： 用ISA防火墙？
```

* 8、显示/test目录下的所有目录

```
答：豪鹫这里提供4种方法：

ls -d */

find . -type d -maxdepth 1 （如果不加-maxdepth 参数，将会列出无穷多的子目录。）

ls -F | grep ‘/$’

ls -l | grep ‘^d’|awk ‘{print $9}’
```

* 9、将文件/etc/a 下中除了 b文件外的所有文件压缩打包放到/home/a下，名字为a.gz

```
答： tar –exclude /etc/a/b -zPcvf /home/a/a.gz /etc/a （不加P选项会提示：『tar: Removing leading `/’ from member names』）

验证：

[root@haojiu a]# tar tPvf /home/a/a.gz （忽略掉b文件）
drwxr-xr-x root/root 0 2015-08-21 10:15 /etc/a/
-rw-r–r– root/root 0 2015-08-21 10:15 /etc/a/d
-rw-r–r– root/root 0 2015-08-21 10:15 /etc/a/f
-rw-r–r– root/root 0 2015-08-21 10:15 /etc/a/c
-rw-r–r– root/root 0 2015-08-21 10:15 /etc/a/e
```

* 10、给一个脚本赋予执行权限的命令及选项

```
答：

chmod +x a.sh
```

* 11、umask 022代表什么意思

```
答： 新建文件夹或文件的权限是由所谓基本码减去称之为umask的屏蔽位得到的。

按照规定：文件夹的基本码是rwxrwxrwx(777)，文件的基本码是rw-rw-rw-(666)

因此新建文件夹是777-022=755(rwxr-xr-x),新建文件是666-022=644(rw-r–r–)。

综上，umask 022表示默认创建新文件权限为755 也就是 rxwr-xr-x(所有者全部权限，属组读写，其它人读写)
```

* 12、如何查看某进程所打开的所有文件

```
答：取出该进程的进程号，然后用lsof -p pid查看打开的所有文件。（这里以crond进程为例）

[root@haojiu a]# ps -ef |grep crond|grep -v grep |awk ‘{print $2}’ #取出进程号
2550
[root@zintao01 a]# lsof -p 2550 #查看该进程打开的所有文件
COMMAND PID USER FD TYPE DEVICE SIZE/OFF NODE NAME
crond 2550 root cwd DIR 8,2 4096 2 /
crond 2550 root rtd DIR 8,2 4096 2 /
crond 2550 root txt REG 8,2 64096 820728 /usr/sbin/crond
crond 2550 root mem REG 8,2 65928 524319 /lib64/libnss_files-2.12.so
crond 2550 root mem REG 8,2 99158576 788202 /usr/lib/locale/locale-archive
crond 2550 root mem REG 8,2 472064 554920 /lib64/libfreebl3.so
crond 2550 root mem REG 8,2 43392 554921 /lib64/libcrypt-2.12.so
crond 2550 root mem REG 8,2 1926800 554903 /lib64/libc-2.12.so
crond 2550 root mem REG 8,2 115536 554937 /lib64/libaudit.so.1.0.0
crond 2550 root mem REG 8,2 22536 554909 /lib64/libdl-2.12.so
crond 2550 root mem REG 8,2 58480 554938 /lib64/libpam.so.0.82.2
crond 2550 root mem REG 8,2 124624 554913 /lib64/libselinux.so.1
crond 2550 root mem REG 8,2 156928 554899 /lib64/ld-2.12.so
crond 2550 root 0u CHR 1,3 0t0 4160 /dev/null
crond 2550 root 1u CHR 1,3 0t0 4160 /dev/null
crond 2550 root 2u CHR 1,3 0t0 4160 /dev/null
crond 2550 root 3u REG 8,2 5 1084973 /var/run/crond.pid
crond 2550 root 4u unix 0xffff88003b3949c0 0t0 13870 socket
crond 2550 root 5r DIR 0,10 0 1 inotify
```

* 13、获取eth0网卡上80端口的数据包信息

```
答：

[root@haojiu ~]# tcpdump -i eth0 port 80
```

* 14、删除 /a/b下的所有文件及目录

```
答：

[root@haojiu ~]# rm -rf /a/b/*
```

* 15、常用的网络管理工具（5种以上）

```
答： Windows下有：ipcofnig(/all,/renew,/release),ping,tracert,nslookup……

Linux下有：ifconfig,ping,tracerroute,dig,nslookup……
```

* 16、ftp、https、smtp、pops、ssh的端口号

```
答： ftp（20和21）、https(443)、smtp(25)、pops(110)、ssh(22)
```

* 17、如何在windows server 2003/2008上开启支持内存3-4G

```
答： 这里提供网上的做法： 在我的电脑上单击鼠标右键，选择属性，点击“高级”标签，点击【启动和故障恢复】下的“设置”按钮，点击“编辑”按钮，将Boot.ini文件的最后一行后面添加一个开关 “/PAE”（不带引号），保存后重新启动机器即可。
```

* 18、请用iptables控制来自192.168.1.2主机的80端口请求

```
答： iptables -A INPUT -p tcp -s 192.168.1.2 –dport 80 -j ACCEPT (允许来自192.168.1.2这台主机访问80端口)
```

* 19、请用shell脚本创建一个组class、一组用户，用户名为stdX X从01-30，并归属class组

```
答： 脚本如下

[root@zintao01 ~]# cat adduser.sh
#!/bin/bash
#script for adduser.
#create by haojiu
#2015-x-x
groupadd class
user=std
for i in {01..30}
do
useradd -G class ${user}$i
done
```

* 20、在mysql客户端查询工具中，如何获取当前的所有连接进程信息

```
答：

mysql> show full processlist;
```

* 21、如何删除已满的数据库日志信息

```
答： 在my.cnf中的[mysqld]段下面加入：expire-logs-days=7（设置自动清除7天钱的logs），重启mysql；

或者登录进mysql，执行：purge binary logs to ‘mysql-bin.000003’; #删除bin-log(删除mysql-bin.000003之前的而没有包含mysql-bin.000003)

如果是mysql主从环境的，删除日志，语句格式如下：

PURGE {MASTER | BINARY} LOGS TO ‘log_name’
PURGE {MASTER | BINARY} LOGS BEFORE ‘date’
关于美团Linux运维工程师面试题就分享到这了，觉得有用的话帮忙转发下哦~
```

# Reference

* [Meituan Operation](https://www.toutiao.com/a6619637454271955463/?iid=50049209260&app=news_article)