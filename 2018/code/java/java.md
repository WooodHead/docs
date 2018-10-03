# java overview

  - [java-pattern](java-pattern/java-pattern.md)

# java installatoin

  ```
  sudo rpm -Uvh jdk-8u181-linux-x64.rpm
  alternatives --config java
  alternatives --install /usr/bin/java java /usr/java/latest/bin/java 2

  oracle setup JAVA_HOME
  oralce jdk installation dir /usr/java
  
  echo 'export JAVA_HOME=/usr/java/jdk1.8.0_181-amd64' | sudo tee -a /etc/profile
  echo 'export JRE_HOME=/usr/java/jdk1.8.0_181-amd64/jre' | sudo tee -a /etc/profile
  source /etc/profile
  
  
  java -XX:+PrintFlagsFinal -version | grep MaxHeapSize
  ```

# Java issue

  - [how to know pid when runing java process](https://stackoverflow.com/questions/35842/how-can-a-java-program-get-its-own-process-id)
  
# jsch

  - [使用jsch-spring-boot在本地访问远程云服务](https://blog.csdn.net/limingjian/article/details/73694656)
