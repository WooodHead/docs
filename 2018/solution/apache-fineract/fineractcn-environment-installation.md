The server is ready; 
IP: 39.106.214.49 172.17.147.94 
Root’s password: GGrt43567w



adduser fineract-cn
password fineract-cn@bamboo
usermod -aG sudo fineract-cn 

# install jdk

    ```
    You can completely remove the OpenJDK and fresh Install Oracle Java JDK by the following steps:

    Remove OpenJDK completely by this command:

    sudo apt-get purge openjdk-\*
    Download the Oracle Java JDK here.

    Note: download appropriate file, for example if your system is x64 Ubuntu (i.e, Debian) the download file is named like this: jdk-8u51-linux-x64.tar.gz

    To find which version is your OS, check here

    Create a folder named java in /usr/local/by this command:

    sudo mkdir -p /usr/local/java
    Copy the Downloaded file in the directory /usr/local/java. To do this, cd into directory where downloaded file is located and use this command for copying that file to /usr/local/java/:

    sudo cp -r jdk-8u51-linux-x64.tar.gz /usr/local/java/
    CD into /usr/local/java/ directory and extract that copied file by using this command:

    sudo tar xvzf jdk-8u51-linux-x64.tar.gz
    After extraction you must see a folder named jdk1.8.0_51.

    Update PATH file by opening  /etc/profile file by the command sudo nano /etc/profile and paste the following at the end of the file:

    JAVA_HOME=/usr/local/java/jdk1.8.0_51
    PATH=$PATH:$HOME/bin:$JAVA_HOME/bin
    export JAVA_HOME
    export PATH
    Save and exit.

    Tell the system that the new Oracle Java version is available by the following commands:

    sudo update-alternatives --install "/usr/bin/java" "java" "/usr/local/java/jdk1.8.0_181/bin/java" 1
    sudo update-alternatives --install "/usr/bin/javac" "javac" "/usr/local/java/jdk1.8.0_181/bin/javac" 1
    sudo update-alternatives --install "/usr/bin/javaws" "javaws" "/usr/local/java/jdk1.8.0_181/bin/javaws" 1
    Make Oracle Java JDK as default by this following commands:

    sudo update-alternatives --set java /usr/local/java/jdk1.8.0_181/bin/java
    sudo update-alternatives --set javac /usr/local/java/jdk1.8.0_181/bin/javac
    sudo update-alternatives --set javaws /usr/local/java/jdk1.8.0_181/bin/javaws
    Reload sytem wide PATH /etc/profile by this command:

    source /etc/profile
    Reboot your system.

    Check Java JDK version by java -version command . If installation is succesful, it will display like the following:

    java version "1.8.0_51"
    Java(TM) SE Runtime Environment (build 1.8.0_51-xxx)
    Java HotSpot(TM) Server VM (build 25.51-xxx, mixed mode)
    ```

# install mysql

    ```
      How to install MySQL 5.7 Server on Ubuntu 16.04
    Octocat **Promotion** - Efficiently manage your coding bookmarks, aka #codingmarks, on www.codingmarks.org and share your hidden gems with the world. They are published weekly on Github. You can help us build THE programming-resources location - 

    This is not the first time I need to install and configure a MySql Community Server on a fresh system with Ubuntu (16.04) running on it. So instead next time to have to google for the individual steps again, I decided to write a post. Find out also how to tweak the Server configuration.

    Install MySQL Server
    This guide is based on the official MySQL documentation - A Quick Guide to Using the MySQL APT Repository, where my own data is used instead.

    Add the MySQL APT Repository
    Go to the download page for the MySQL APT repository at http://dev.mysql.com/downloads/repo/apt/ and select the package for my Linux distribution. As said mine is Ubuntu 16.04, which is covered by the mysql-apt-config_0.8.1-1_all.deb package at the time of this writing:

    shell> wget http://dev.mysql.com/get/mysql-apt-config_0.8.1-1_all.deb
    COPY
    Next install the release package with the following command:

    shell> sudo dpkg -i mysql-apt-config_0.8.1-1_all.deb

    Selecting previously unselected package mysql-apt-config.
    (Reading database ... 27837 files and directories currently installed.)
    Preparing to unpack mysql-apt-config_0.8.1-1_all.deb ...
    Unpacking mysql-apt-config (0.8.1-1) ...
    Setting up mysql-apt-config (0.8.1-1) ...
    locale: Cannot set LC_CTYPE to default locale: No such file or directory
    locale: Cannot set LC_ALL to default locale: No such file or directory
    /usr/bin/locale: Cannot set LC_CTYPE to default locale: No such file or directory
    /usr/bin/locale: Cannot set LC_ALL to default locale: No such file or directory
    OK
    COPY
    During installation I chose the MySQL 5.7 Server version

    The next mandatory step is to update the package information from the MySQL APT repository

    shell> sudo apt-get update

    Hit:1 http://mirrors.linode.com/ubuntu xenial InRelease
    Get:2 http://mirrors.linode.com/ubuntu xenial-updates InRelease [102 kB]
    Get:3 http://mirrors.linode.com/ubuntu xenial-backports InRelease [102 kB]
    Get:4 http://repo.mysql.com/apt/ubuntu xenial InRelease [14.2 kB]
    Hit:5 http://ppa.launchpad.net/webupd8team/java/ubuntu xenial InRelease
    Get:6 http://security.ubuntu.com/ubuntu xenial-security InRelease [102 kB]
    Get:7 http://repo.mysql.com/apt/ubuntu xenial/mysql-5.7 Sources [886 B]
    Get:8 http://repo.mysql.com/apt/ubuntu xenial/mysql-apt-config amd64 Packages [567 B]
    Get:9 http://repo.mysql.com/apt/ubuntu xenial/mysql-apt-config i386 Packages [567 B]
    Get:10 http://repo.mysql.com/apt/ubuntu xenial/mysql-5.7 amd64 Packages [2709 B]
    Get:11 http://repo.mysql.com/apt/ubuntu xenial/mysql-5.7 i386 Packages [2712 B]
    Get:12 http://repo.mysql.com/apt/ubuntu xenial/mysql-tools amd64 Packages [2608 B]
    Get:13 http://repo.mysql.com/apt/ubuntu xenial/mysql-tools i386 Packages [1928 B]
    Fetched 333 kB in 0s (603 kB/s)
    Reading package lists... Done
    COPY
    Installing MySQL with APT
    Now to install MySQL execute the following command:

    shell> sudo apt-get install mysql-server
    COPY
    You will be asked for the root password during the installation. Make a note of it if you want to spare the time needed to reset it later1

    The server is started automatically after installation. You can check the version of the server by issuing the following command:

    shell> mysql --version

    mysql  Ver 14.14 Distrib 5.7.17, for Linux (x86_64) using  EditLine wrapper
    COPY
    Starting and stopping the MySQL Server
    You can check the status:

    shell> sudo service mysql status
    COPY
    stop it:

    shell> sudo service mysql stop
    COPY
    and start it again:

    shell> sudo service mysql start
    COPY
    Because I am lazy and I will probably repeat these commands several times, at least in the beginning, I defined some aliases for them - snippet from my .bash_aliases file:

    # MySql
    alias mysql-start="sudo service mysql start"
    alias mysql-stop="sudo service mysql stop"
    alias mysql-restart="sudo service mysql restart"
    alias mysql-status="sudo service mysql status"
    alias mysql-connect-root="mysql -uroot -p"
    alias mysql-vim-mysql.conf.d.my.cnf="sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf"
    
    COPY
    See my post A developer’s guide to using aliases to learn how I’ve become best buddies with the Bash alias. O, and I’ve also created a video with it.


    Tune MySQL configuration
    Most of the default configuration values are fine, but you can tweak it if you don’t have enough memory 2 (like my server running on a 2GB RAM machine) or want to improve performance 3.

    I have personally written about optimizing MySQL Server Settings, but this remains a science for itself to me. Anyway before you are ready to override a default value in my.cnf, have a look in the official documentation about Server System Variables and try to reason what each really means…

    Now which configuration file should I use, because there are bunch of them under the /etc/mysql directory:

    /etc/mysql/
    |-- conf.d
    |   -- mysql.cnf
    |-- my.cnf -> /etc/alternatives/my.cnf
    |-- my.cnf.fallback
    |-- mysql.cnf
    |-- mysql.cnf.2017-01-13-original
    |-- mysql.conf.d
        -- mysqld.cnf
    COPY
    Well, because these are server settings, I want to override I need to put them below the [mysld] tag, which is to be found in mysqld.conf. So edit this file:

    shell> sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
    COPY
    which looks like the following:

    #
    # The MySQL  Server configuration file.
    #
    # For explanations see
    # http://dev.mysql.com/doc/mysql/en/server-system-variables.html

    [mysqld]
    pid-file        = /var/run/mysqld/mysqld.pid
    socket          = /var/run/mysqld/mysqld.sock
    datadir         = /var/lib/mysql
    log-error       = /var/log/mysql/error.log
    # By default we only accept connections from localhost
    bind-address    = 127.0.0.1
    # Disabling symbolic-links is recommended to prevent assorted security risks
    symbolic-links=0

    # my overrides
    max_allowed_packet = 1M
    max_connections = 75
    table_open_cache = 32M
    key_buffer_size = 32M
    COPY
    Remember these are values for a small 2GB RAM server. It is supposed to run one MySQL Database among a bunch of other servers… Also very important to notice is that you can now change the configuration values at runtime, but they won’t be persisted when the server is restarted.

    References
    http://dev.mysql.com/doc/refman/5.7/en/resetting-permissions.html ↩

    https://www.linode.com/docs/websites/hosting-a-website ↩

    http://www.speedemy.com/17-key-mysql-config-file-settings-mysql-5-7-proof/ 
    ```

# install git 
  
    ```
    sudo apt-get update
    sudo apt-get install git
    ```
    
# install maven 

   ```
    1. Search Maven package
    In a terminal, run apt-cache search maven, to get all the available Maven package.

    $ apt-cache search maven
    ....
    libxmlbeans-maven-plugin-java-doc - Documentation for Maven XMLBeans Plugin
    maven - Java software project management and comprehension tool
    maven-debian-helper - Helper tools for building Debian packages with Maven
    maven2 - Java software project management and comprehension tool
    Copy
    The maven package always comes with latest Apache Maven.

    2. Install it
    Run command sudo apt-get install maven, to install the latest Apache Maven.

    $ sudo apt-get install maven
    Copy
    It takes few minutes to download, patient.

    3. Verification
    Run command mvn -version to verify your installation.

    $ mvn -version
    Apache Maven 3.0.4
    Maven home: /usr/share/maven
    Java version: 1.7.0_09, vendor: Oracle Corporation
    Java home: /usr/lib/jvm/java-7-openjdk-amd64/jre
    Default locale: en_US, platform encoding: UTF-8
    OS name: "linux", version: "3.5.0-17-generic", arch: "amd64", family: "unix"
    Copy
    The Apache Maven is installed successfully.

    Where is Maven installed?
    The command apt-get install the Maven in /usr/share/maven.
    $ls -ls /usr/share/maven
    total 16
    4 drwxr-xr-x 2 root root 4096 Dec  7 01:28 bin
    4 drwxr-xr-x 2 root root 4096 Dec  7 01:28 boot
    0 lrwxrwxrwx 1 root root   10 May 28  2012 conf -> /etc/maven
    4 drwxr-xr-x 2 root root 4096 Dec  7 01:28 lib
    4 drwxr-xr-x 2 root root 4096 Dec  7 01:28 man
    Copy
    The Maven configuration files are stored in /etc/maven

    $ls -ls /etc/maven
    total 16
     4 -rw-r--r-- 1 root root   184 Jan 21  2012 m2.conf
    12 -rw-r--r-- 1 root root 10224 Jan 21  2012 settings.xml
   ```
   
 # install gradle
 
   ```
    $ mkdir /opt/gradle
    $ unzip -d /opt/gradle gradle-4.10.2-bin.zip
    $ ls /opt/gradle/gradle-4.10.2
    
    sudo vim /etc/profile
    GRADLE_HOME=/opt/gradle/gradle-4.10.2
    PATH=$PATH:$GRADLE_HOME/bin
    export GRADLE_HOME
    export PATH
   ```
   
# install cassandra

  ```
    Downloading Cassandra
    Latest version
    Download the latest Apache Cassandra 3.11 release: 3.11.3 (pgp, md5 and sha1), released on 2018-08-01.

    Older supported releases
    The following older Cassandra releases are still supported:

    Apache Cassandra 3.0 is supported until 6 months after 4.0 release (date TBD). The latest release is 3.0.17 (pgp, md5 and sha1), released on 2018-08-01.
    Apache Cassandra 2.2 is supported until 4.0 release (date TBD). The latest release is 2.2.13 (pgp, md5 and sha1), released on 2018-08-01.
    Apache Cassandra 2.1 is supported until 4.0 release (date TBD) with critical fixes only. The latest release is 2.1.20 (pgp, md5 and sha1), released on 2018-02-16.
    Older (unsupported) versions of Cassandra are archived here.

    Installation from Debian packages
    For the <release series> specify the major version number, without dot, and with an appended x.
    The latest <release series> is 311x.
    For older releases, the <release series> can be one of 30x, 22x, or 21x.

    Add the Apache repository of Cassandra to /etc/apt/sources.list.d/cassandra.sources.list, for example for the latest 3.11 version:
    echo "deb http://www.apache.org/dist/cassandra/debian 311x main" | sudo tee -a /etc/apt/sources.list.d/cassandra.sources.list
    Add the Apache Cassandra repository keys:
    curl https://www.apache.org/dist/cassandra/KEYS | sudo apt-key add -
    Update the repositories:
    sudo apt-get update
    If you encounter this error:
    GPG error: http://www.apache.org 311x InRelease: The following signatures couldn't be verified because the public key is not available: NO_PUBKEY A278B781FE4B2BDA
    Then add the public key A278B781FE4B2BDA as follows:

    sudo apt-key adv --keyserver pool.sks-keyservers.net --recv-key A278B781FE4B2BDA
    and repeat sudo apt-get update. The actual key may be different, you get it from the error message itself. For a full list of Apache contributors public keys, you can refer to https://www.apache.org/dist/cassandra/KEYS.

    Install Cassandra:
    sudo apt-get install cassandra
    You can start Cassandra with sudo service cassandra start and stop it with sudo service cassandra stop. However, normally the service will start automatically. For this reason be sure to stop it if you need to make any configuration changes.
    Verify that Cassandra is running by invoking nodetool status from the command line.
    The default location of configuration files is /etc/cassandra.
    The default location of log and data directories is /var/log/cassandra/ and /var/lib/cassandra.
    Start-up options (heap size, etc) can be configured in /etc/default/cassandra.
    Installation from RPM packages
    For the <release series> specify the major version number, without dot, and with an appended x.
    The latest <release series> is 311x.
    For older releases, the <release series> can be one of 30x, 22x, or 21x.
    (Not all versions of Apache Cassandra are available, since building RPMs is a recent addition to the project.)

    Add the Apache repository of Cassandra to /etc/yum.repos.d/cassandra.repo, for example for the latest 3.11 version:
    [cassandra] name=Apache Cassandra baseurl=https://www.apache.org/dist/cassandra/redhat/311x/ gpgcheck=1 repo_gpgcheck=1 gpgkey=https://www.apache.org/dist/cassandra/KEYS
    Install Cassandra, accepting the gpg key import prompts:
    sudo yum install cassandra
    Start Cassandra (will not start automatically):

    service cassandra start
    Systemd based distributions may require to run systemctl daemon-reload once to make Cassandra available as a systemd service. This should happen automatically by running the command above.

    Make Cassandra start automatically after reboot:

    chkconfig cassandra on
    Please note that official RPMs for Apache Cassandra only have been available recently and are not tested thoroughly on all platforms yet. We appreciate your feedback and support and ask you to post details on any issues in the corresponding Jira ticket.

    Source
    Development is done in the Apache Git repository. To check out a copy:

    git clone http://git-wip-us.apache.org/repos/asf/cassandra.git
  ```
  
 # install nodejs & npm
   
   ```
    sudo apt-get update
    sudo apt-get install nodejs
    sudo apt-get install npm
   ```
   
 # install nginx
 
   ```
        Introduction
        Nginx is one of the most popular web servers in the world and is responsible for hosting some of the largest and highest-traffic sites on the internet. It is more resource-friendly than Apache in most cases and can be used as a web server or a reverse proxy.

        In this guide, we'll discuss how to get Nginx installed on your Ubuntu 16.04 server.

        Prerequisites
        Before you begin this guide, you should have a regular, non-root user with sudo privileges configured on your server. You can learn how to configure a regular user account by following our initial server setup guide for Ubuntu 16.04.

        When you have an account available, log in as your non-root user to begin.

        Step 1: Install Nginx
        Nginx is available in Ubuntu's default repositories, so the installation is rather straight forward.

        Since this is our first interaction with the apt packaging system in this session, we will update our local package index so that we have access to the most recent package listings. Afterwards, we can install nginx:

        sudo apt-get update
        sudo apt-get install nginx
        After accepting the procedure, apt-get will install Nginx and any required dependencies to your server.

        Step 2: Adjust the Firewall
        Before we can test Nginx, we need to reconfigure our firewall software to allow access to the service. Nginx registers itself as a service with ufw, our firewall, upon installation. This makes it rather easy to allow Nginx access.

        We can list the applications configurations that ufw knows how to work with by typing:

        sudo ufw app list
        You should get a listing of the application profiles:

        Output
        Available applications:
          Nginx Full
          Nginx HTTP
          Nginx HTTPS
          OpenSSH
        As you can see, there are three profiles available for Nginx:

        Nginx Full: This profile opens both port 80 (normal, unencrypted web traffic) and port 443 (TLS/SSL encrypted traffic)
        Nginx HTTP: This profile opens only port 80 (normal, unencrypted web traffic)
        Nginx HTTPS: This profile opens only port 443 (TLS/SSL encrypted traffic)
        It is recommended that you enable the most restrictive profile that will still allow the traffic you've configured. Since we haven't configured SSL for our server yet, in this guide, we will only need to allow traffic on port 80.

        You can enable this by typing:

        sudo ufw allow 'Nginx HTTP'
        You can verify the change by typing:

        sudo ufw status
        You should see HTTP traffic allowed in the displayed output:

        Output
        Status: active

        To                         Action      From
        --                         ------      ----
        OpenSSH                    ALLOW       Anywhere                  
        Nginx HTTP                 ALLOW       Anywhere                  
        OpenSSH (v6)               ALLOW       Anywhere (v6)             
        Nginx HTTP (v6)            ALLOW       Anywhere (v6)
        Step 3: Check your Web Server
        At the end of the installation process, Ubuntu 16.04 starts Nginx. The web server should already be up and running.

        We can check with the systemd init system to make sure the service is running by typing:

        systemctl status nginx
        Output
        ● nginx.service - A high performance web server and a reverse proxy server
           Loaded: loaded (/lib/systemd/system/nginx.service; enabled; vendor preset: enabled)
           Active: active (running) since Mon 2016-04-18 16:14:00 EDT; 4min 2s ago
         Main PID: 12857 (nginx)
           CGroup: /system.slice/nginx.service
                   ├─12857 nginx: master process /usr/sbin/nginx -g daemon on; master_process on
                   └─12858 nginx: worker process
        As you can see above, the service appears to have started successfully. However, the best way to test this is to actually request a page from Nginx.

        You can access the default Nginx landing page to confirm that the software is running properly. You can access this through your server's domain name or IP address.

        If you do not have a domain name set up for your server, you can learn how to set up a domain with DigitalOcean here.

        If you do not want to set up a domain name for your server, you can use your server's public IP address. If you do not know your server's IP address, you can get it a few different ways from the command line.

        Try typing this at your server's command prompt:

        ip addr show eth0 | grep inet | awk '{ print $2; }' | sed 's/\/.*$//'
        You will get back a few lines. You can try each in your web browser to see if they work.

        An alternative is typing this, which should give you your public IP address as seen from another location on the internet:

        sudo apt-get install curl
        curl -4 icanhazip.com
        When you have your server's IP address or domain, enter it into your browser's address bar:

        http://server_domain_or_IP
   ```
   
   ```
        introduction
        UFW, or Uncomplicated Firewall, is an interface to iptables that is geared towards simplifying the process of configuring a firewall. While iptables is a solid and flexible tool, it can be difficult for beginners to learn how to use it to properly configure a firewall. If you're looking to get started securing your network, and you're not sure which tool to use, UFW may be the right choice for you.

        This tutorial will show you how to set up a firewall with UFW on Ubuntu 16.04.

        Prerequisites
        To follow this tutorial, you will need:

        One Ubuntu 16.04 server with a sudo non-root user, which you can set up by following Steps 1-3 in the Initial Server Setup with Ubuntu 16.04 tutorial.
        UFW is installed by default on Ubuntu. If it has been uninstalled for some reason, you can install it with sudo apt-get install ufw.

        Step 1 — Using IPv6 with UFW (Optional)
        This tutorial is written with IPv4 in mind, but will work for IPv6 as well as long as you enable it. If your Ubuntu server has IPv6 enabled, ensure that UFW is configured to support IPv6 so that it will manage firewall rules for IPv6 in addition to IPv4. To do this, open the UFW configuration with nano or your favorite editor.

        sudo nano /etc/default/ufw
        Then make sure the value of IPV6 is yes. It should look like this:

        /etc/default/ufw excerpt
        ...
        IPV6=yes
        ...
        Save and close the file. Now, when UFW is enabled, it will be configured to write both IPv4 and IPv6 firewall rules. However, before enabling UFW, we will want to ensure that your firewall is configured to allow you to connect via SSH. Let's start with setting the default policies.

        Step 2 — Setting Up Default Policies
        If you're just getting started with your firewall, the first rules to define are your default policies. These rules control how to handle traffic that does not explicitly match any other rules. By default, UFW is set to deny all incoming connections and allow all outgoing connections. This means anyone trying to reach your cloud server would not be able to connect, while any application within the server would be able to reach the outside world.

        Let's set your UFW rules back to the defaults so we can be sure that you'll be able to follow along with this tutorial. To set the defaults used by UFW, use these commands:

        sudo ufw default deny incoming
        sudo ufw default allow outgoing
        These commands set the defaults to deny incoming and allow outgoing connections. These firewall defaults alone might suffice for a personal computer, but servers typically need to respond to incoming requests from outside users. We'll look into that next.

        Step 3 — Allowing SSH Connections
        If we enabled our UFW firewall now, it would deny all incoming connections. This means that we will need to create rules that explicitly allow legitimate incoming connections — SSH or HTTP connections, for example — if we want our server to respond to those types of requests. If you're using a cloud server, you will probably want to allow incoming SSH connections so you can connect to and manage your server.

        To configure your server to allow incoming SSH connections, you can use this command:

        sudo ufw allow ssh
        This will create firewall rules that will allow all connections on port 22, which is the port that the SSH daemon listens on by default. UFW knows what SSH and a number of other service names mean because they're listed as services in the /etc/services file.

        However, we can actually write the equivalent rule by specifying the port instead of the service name. For example, this command works the same as the one above:

        sudo ufw allow 22
        If you configured your SSH daemon to use a different port, you will have to specify the appropriate port. For example, if your SSH server is listening on port 2222, you can use this command to allow connections on that port:

        sudo ufw allow 2222
        Now that your firewall is configured to allow incoming SSH connections, we can enable it.

        Step 4 — Enabling UFW
        To enable UFW, use this command:

        sudo ufw enable
        You will receive a warning that says the command may disrupt existing SSH connections. We already set up a firewall rule that allows SSH connections, so it should be fine to continue. Respond to the prompt with y.

        The firewall is now active. Feel free to run the sudo ufw status verbose command to see the rules that are set. The rest of this tutorial covers how to use UFW in more detail, like allowing or denying different kinds of connections.

        Step 5 — Allowing Other Connections
        At this point, you should allow all of the other connections that your server needs to respond to. The connections that you should allow depends your specific needs. Luckily, you already know how to write rules that allow connections based on a service name or port; we already did this for SSH on port 22. You can also do this for:

        HTTP on port 80, which is what unencrypted web servers use, using sudo ufw allow http or sudo ufw allow 80
        HTTPS on port 443, which is what encrypted web servers use, using sudo ufw allow https or sudo ufw allow 443
        FTP on port 21, which is used for unencrypted file transfers (which you probably shouldn't use anyway), using sudo ufw allow ftp or sudo ufw allow 21/tcp
        There are several others ways to allow other connections, aside from specifying a port or known service.

        Specific Port Ranges
        You can specify port ranges with UFW. Some applications use multiple ports, instead of a single port.

        For example, to allow X11 connections, which use ports 6000-6007, use these commands:

        sudo ufw allow 6000:6007/tcp
        sudo ufw allow 6000:6007/udp
        When specifying port ranges with UFW, you must specify the protocol (tcp or udp) that the rules should apply to. We haven't mentioned this before because not specifying the protocol simply allows both protocols, which is OK in most cases.

        Specific IP Addresses
        When working with UFW, you can also specify IP addresses. For example, if you want to allow connections from a specific IP address, such as a work or home IP address of 15.15.15.51, you need to specify from, then the IP address:

        sudo ufw allow from 15.15.15.51
        You can also specify a specific port that the IP address is allowed to connect to by adding to any port followed by the port number. For example, If you want to allow 15.15.15.51 to connect to port 22 (SSH), use this command:

        sudo ufw allow from 15.15.15.51 to any port 22
        Subnets
        If you want to allow a subnet of IP addresses, you can do so using CIDR notation to specify a netmask. For example, if you want to allow all of the IP addresses ranging from 15.15.15.1 to 15.15.15.254 you could use this command:

        sudo ufw allow from 15.15.15.0/24
        Likewise, you may also specify the destination port that the subnet 15.15.15.0/24 is allowed to connect to. Again, we'll use port 22 (SSH) as an example:

        sudo ufw allow from 15.15.15.0/24 to any port 22
        Connections to a Specific Network Interface
        If you want to create a firewall rule that only applies to a specific network interface, you can do so by specifying "allow in on" followed by the name of the network interface.

        You may want to look up your network interfaces before continuing. To do so, use this command:

        ip addr
        Output Excerpt:
        ...
        2: eth0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc pfifo_fast state
        ...
        3: eth1: <BROADCAST,MULTICAST> mtu 1500 qdisc noop state DOWN group default 
        ...
        The highlighted output indicates the network interface names. They are typically named something like eth0 or eth1.

        So, if your server has a public network interface called eth0, you could allow HTTP traffic (port 80) to it with this command:

        sudo ufw allow in on eth0 to any port 80
        Doing so would allow your server to receive HTTP requests from the public Internet.

        Or, if you want your MySQL database server (port 3306) to listen for connections on the private network interface eth1, for example, you could use this command:

        sudo ufw allow in on eth1 to any port 3306
        This would allow other servers on your private network to connect to your MySQL database.

        Step 6 — Denying Connections
        If you haven't changed the default policy for incoming connections, UFW is configured to deny all incoming connections. Generally, this simplifies the process of creating a secure firewall policy by requiring you to create rules that explicitly allow specific ports and IP addresses through.

        However, sometimes you will want to deny specific connections based on the source IP address or subnet, perhaps because you know that your server is being attacked from there. Also, if you want change your default incoming policy to allow (which isn't recommended in the interest of security), you would need to create deny rules for any services or IP addresses that you don't want to allow connections for.

        To write deny rules, you can use the commands described above, replacing allow with deny.

        For example, to deny HTTP connections, you could use this command:

        sudo ufw deny http
        Or if you want to deny all connections from 15.15.15.51 you could use this command:

        sudo ufw deny from 15.15.15.51
        Now let's take a look at how to delete rules.

        Step 7 — Deleting Rules
        Knowing how to delete firewall rules is just as important as knowing how to create them. There are two different ways specify which rules to delete: by rule number or by the actual rule (similar to how the rules were specified when they were created). We'll start with the delete by rule number method because it is easier, compared to writing the actual rules to delete, if you're new to UFW.

        By Rule Number
        If you're using the rule number to delete firewall rules, the first thing you'll want to do is get a list of your firewall rules. The UFW status command has an option to display numbers next to each rule, as demonstrated here:

        sudo ufw status numbered
        Numbered Output:
        Status: active

             To                         Action      From
             --                         ------      ----
        [ 1] 22                         ALLOW IN    15.15.15.0/24
        [ 2] 80                         ALLOW IN    Anywhere
        If we decide that we want to delete rule 2, the one that allows port 80 (HTTP) connections, we can specify it in a UFW delete command like this:

        sudo ufw delete 2
        This would show a confirmation prompt then delete rule 2, which allows HTTP connections. Note that if you have IPv6 enabled, you would want to delete the corresponding IPv6 rule as well.

        By Actual Rule
        The alternative to rule numbers is to specify the actual rule to delete. For example, if you want to remove the allow http rule, you could write it like this:

        sudo ufw delete allow http
        You could also specify the rule by allow 80, instead of by service name:

        sudo ufw delete allow 80
        This method will delete both IPv4 and IPv6 rules, if they exist.

        Step 8 — Checking UFW Status and Rules
        At any time, you can check the status of UFW with this command:

        sudo ufw status verbose
        If UFW is disabled, which it is by default, you'll see something like this:

        Output
        Status: inactive
        If UFW is active, which it should be if you followed Step 3, the output will say that it's active and it will list any rules that are set. For example, if the firewall is set to allow SSH (port 22) connections from anywhere, the output might look something like this:

        Output
        Status: active
        Logging: on (low)
        Default: deny (incoming), allow (outgoing), disabled (routed)
        New profiles: skip

        To                         Action      From
        --                         ------      ----
        22/tcp                     ALLOW IN    Anywhere
        Use the status command if you want to check how UFW has configured the firewall.

        Step 9 — Disabling or Resetting UFW (optional)
        If you decide you don't want to use UFW, you can disable it with this command:

        sudo ufw disable
        Any rules that you created with UFW will no longer be active. You can always run sudo ufw enable if you need to activate it later.

        If you already have UFW rules configured but you decide that you want to start over, you can use the reset command:

        sudo ufw reset
        This will disable UFW and delete any rules that were previously defined. Keep in mind that the default policies won't change to their original settings, if you modified them at any point. This should give you a fresh start with UFW.

        Conclusion
        Your firewall should now be configured to allow (at least) SSH connections. Be sure to allow any other incoming connections that your server, while limiting any unnecessary connections, so your server will be functional and secure.

        To learn about more common UFW configurations, check out the UFW Essentials: Common Firewall Rules and Commands tutorial.
   ```

   ```
   npm i --registry=https://registry.npm.taobao.org
   
   
    740 error code ELIFECYCLE
    741 error errno 1
    742 error fims@0.1.0 postinstall: `webdriver-manager update`
    742 error Exit status 1
    743 error Failed at the fims@0.1.0 postinstall script.
    743 error This is probably not a problem with npm. There is likely additional logging output above.
    744 verbose exit [ 1, true ]
    
    vim package.json
    "postinstall": "webdriver-manager update", => "postinstall": "webdriver-manager",

    
    ERROR in 10.41d1ee052ac45f6cad9f.chunk.js from UglifyJs
    TypeError: Cannot set property 'fixed' of undefined
        at TreeWalker.eval [as visit] (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:5584:25)
        at TreeWalker._visit (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1339:24)
        at AST_This._walk (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:480:24)
        at AST_Dot.eval (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1061:29)
        at TreeWalker._visit (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1343:21)
        at AST_Dot._walk (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1060:24)
        at AST_Dot.walk (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:483:21)
        at TreeWalker.eval [as visit] (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:5722:31)
        at TreeWalker._visit (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1339:24)
        at AST_ForIn._walk (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:653:24)
        at walk_body (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:530:17)
        at AST_Function.eval (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:771:13)
        at eval (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1340:21)
        at TreeWalker.eval [as visit] (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:5665:21)
        at TreeWalker._visit (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1339:24)
        at AST_Function._walk (eval at <anonymous> (/home/fineract-cn/github/integration-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:765:24)
    npm ERR! code ELIFECYCLE
    npm ERR! errno 1
    npm ERR! fims@0.1.0 build: `ng build --prod`
    npm ERR! Exit status 1
    npm ERR!
    npm ERR! Failed at the fims@0.1.0 build script.
    npm ERR! This is probably not a problem with npm. There is likely additional logging output above.

    npm ERR! A complete log of this run can be found in:
    npm ERR!     /home/fineract-cn/.npm/_logs/2018-09-29T09_28_04_514Z-debug.log

    npm WARN deprecated spdx@0.5.2: see spdx-expression-parse, spdx-satisfies, &c.
    npm WARN @angular-devkit/schematics@0.0.52 requires a peer of @angular-devkit/core@0.0.29 but none is installed. You must                                install peer dependencies yourself.
    npm WARN @angular/core@4.4.5 requires a peer of rxjs@^5.0.1 but none is installed. You must install peer dependencies you                               rself.
    npm WARN @angular/http@4.4.5 requires a peer of rxjs@^5.0.1 but none is installed. You must install peer dependencies you                               rself.
    npm WARN @angular/router@4.4.5 requires a peer of rxjs@^5.0.1 but none is installed. You must install peer dependencies y                               ourself.
    npm WARN @ngrx/core@1.2.0 requires a peer of rxjs@^5.0.0-beta.12 but none is installed. You must install peer dependencie                               s yourself.
    npm WARN @ngrx/effects@2.0.5 requires a peer of rxjs@^5.4.0 but none is installed. You must install peer dependencies you                               rself.
    npm WARN @ngrx/store@2.2.2 requires a peer of rxjs@^5.0.0-beta.12 but none is installed. You must install peer dependenci                               es yourself.
    npm WARN @ngrx/store-devtools@3.2.4 requires a peer of rxjs@^5.0.0-beta.12 but none is installed. You must install peer d                               ependencies yourself.
    npm WARN @schematics/angular@0.0.49 requires a peer of @angular-devkit/schematics@0.0.34 but none is installed. You must                                install peer dependencies yourself.
    npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.4 (node_modules/fsevents):
    npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.4: wanted {"os":"darwin","arch":"any"                               } (current: {"os":"linux","arch":"x64"})

   ```  
   
   ```
    sudo apt-get purge nodejs npm
    v=6
    curl -sL https://deb.nodesource.com/setup_$v.x | sudo -E bash -
    sudo apt-get install -y nodejs
    
    
    Try these steps:

    npm install -g npm@latest to update npm because it is sometimes buggy.
    rm -rf node_modules to remove the existing modules.
    npm install to re-install the project dependencies.
   ```
   
   ```
    npm WARN @angular-devkit/schematics@0.0.52 requires a peer of @angular-devkit/core@0.0.29 but none is installed. You must install peer dependencies yourself.
    npm WARN @angular/core@4.4.5 requires a peer of rxjs@^5.0.1 but none is installed. You must install peer dependencies yourself.
    npm WARN @angular/http@4.4.5 requires a peer of rxjs@^5.0.1 but none is installed. You must install peer dependencies yourself.
    npm WARN @angular/router@4.4.5 requires a peer of rxjs@^5.0.1 but none is installed. You must install peer dependencies yourself.
    npm WARN @ngrx/core@1.2.0 requires a peer of rxjs@^5.0.0-beta.12 but none is installed. You must install peer dependencies yourself.
    npm WARN @ngrx/effects@2.0.5 requires a peer of rxjs@^5.4.0 but none is installed. You must install peer dependencies yourself.
    npm WARN @ngrx/store@2.2.2 requires a peer of rxjs@^5.0.0-beta.12 but none is installed. You must install peer dependencies yourself.
    npm WARN @ngrx/store-devtools@3.2.4 requires a peer of rxjs@^5.0.0-beta.12 but none is installed. You must install peer dependencies yourself.
    npm WARN @schematics/angular@0.0.49 requires a peer of @angular-devkit/schematics@0.0.34 but none is installed. You must install peer dependencies yourself.
    npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.4 (node_modules/fsevents):
    npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.4: wanted {"os":"darwin","arch":"any"} (current: {"os":"linux","arch":"x64"})

    edit package.json
    
    "dependencies": {
    "@angular-devkit/schematics": "0.0.34", <== add
    "@angular-devkit/core": "0.0.29",       <== add 
    "@angular/animations": "4.4.5",
    "@angular/cdk": "2.0.0-beta.12",
    "@angular/common": "4.4.5",
    "@angular/compiler": "4.4.5",
    "@angular/core": "4.4.5",
    "@angular/forms": "4.4.5",
    "@angular/http": "4.4.5",
    "@angular/material": "2.0.0-beta.12",
    "@angular/platform-browser": "4.4.5",
    "@angular/platform-browser-dynamic": "4.4.5",
    "@angular/platform-server": "4.4.5",
    "@angular/router": "4.4.5",
    "@covalent/core": "1.0.0-beta.8-1",
    "@ngrx/core": "1.2.0",
    "@ngrx/effects": "2.0.5",
    "@ngrx/store": "2.2.2",
    "@ngrx/store-devtools": "3.2.4",
    "@ngx-translate/core": "7.0.0",
    "@ngx-translate/http-loader": "0.1.0",
    "@reactivex/rxjs": "^5.0.3",
    "angular2-text-mask": "^8.0.2",
    "core-js": "2.4.1",
    "hammerjs": "2.0.8",
    "highlight.js": "9.10.0",
    "ngrx-store-localstorage": "0.1.8",
    "reselect": "2.5.4",
    "showdown": "1.6.4",
    "text-mask-addons": "^3.6.0",
    "zone.js": "0.8.17"
  },
  
    
    npm WARN @angular/core@4.4.5 requires a peer of rxjs@^5.0.1 but none was installed.
    npm WARN @angular/http@4.4.5 requires a peer of rxjs@^5.0.1 but none was installed.
    npm WARN @angular/router@4.4.5 requires a peer of rxjs@^5.0.1 but none was installed.
    npm WARN @ngrx/core@1.2.0 requires a peer of rxjs@^5.0.0-beta.12 but none was installed.
    npm WARN @ngrx/effects@2.0.5 requires a peer of rxjs@^5.4.0 but none was installed.
    npm WARN @ngrx/store@2.2.2 requires a peer of rxjs@^5.0.0-beta.12 but none was installed.
    npm WARN @ngrx/store-devtools@3.2.4 requires a peer of rxjs@^5.0.0-beta.12 but none was installed.


    
    npm uninstall -g angular-cli
    npm cache clear
    npm install -g @angular/cli
    
    rpm -qa | grep -i nodesource
    rpm -e some-repository-rpm-package
    
    sudo apt-get remove nodejs ^node-* nodejs-*
    sudo apt-get autoremove
    sudo apt-get clean
    sudo apt-get install curl python-software-properties
    curl -sL https://deb.nodesource.com/setup_10.x | sudo -E bash 
    sudo apt-get install nodejs
   ```
   
   ```
     ERROR: CALL_AND_RETRY_LAST Allocation failed - JavaScript heap out of memory
     
     npm run build --max_old_space_size=4096 --optimize_for_size --max_executable_size=4096 --stack_size=4096

   ```
   
   ```
     nodejs v8.10.0
     npm 3.5.2
   ```
   
   ```
    > fims@0.1.0 postinstall /home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app
    > webdriver-manager update

    [11:29:38] I/file_manager - creating folder /home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/protractor/node_modules/webdriver-manager/selenium
    [11:29:38] I/config_source - curl -o/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/protractor/node_modules/webdriver-manager/selenium/standalone-response.xml https://selenium-release.storage.googleapis.com/
    [11:29:38] I/config_source - curl -o/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/protractor/node_modules/webdriver-manager/selenium/chrome-response.xml https://chromedriver.storage.googleapis.com/
    [11:29:38] I/config_source - curl -o/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/protractor/node_modules/webdriver-manager/selenium/gecko-response.json https://api.github.com/repos/mozilla/geckodriver/releases
    events.js:183
          throw er; // Unhandled 'error' event
          ^
    Error: connect ETIMEDOUT 172.217.160.112:443
    at Object._errnoException (util.js:1022:11)
    at _exceptionWithHostPort (util.js:1044:20)
    at TCPConnectWrap.afterConnect [as oncomplete] (net.js:1198:14)

    sudo npm install -g webdriver-manager
   ```
   ```
     notsup Not compatible with your operating system or architecture: fsevents@1.2.4
     
     npm install --no-optional
   ```
   ```
    npm WARN @angular-devkit/schematics@0.0.52 requires a peer of @angular-devkit/core@0.0.29 but none was installed.
    npm WARN @angular/core@4.4.5 requires a peer of rxjs@^5.0.1 but none was installed.
    npm WARN @angular/http@4.4.5 requires a peer of rxjs@^5.0.1 but none was installed.
    npm WARN @angular/router@4.4.5 requires a peer of rxjs@^5.0.1 but none was installed.
    npm WARN @ngrx/core@1.2.0 requires a peer of rxjs@^5.0.0-beta.12 but none was installed.
    npm WARN @ngrx/effects@2.0.5 requires a peer of rxjs@^5.4.0 but none was installed.
    npm WARN @ngrx/store@2.2.2 requires a peer of rxjs@^5.0.0-beta.12 but none was installed.
    npm WARN @ngrx/store-devtools@3.2.4 requires a peer of rxjs@^5.0.0-beta.12 but none was installed.
    npm WARN @schematics/angular@0.0.49 requires a peer of @angular-devkit/schematics@0.0.34 but none was installed.

    "dependencies": {
    "@angular-devkit/schematics": "0.0.34", <== add
    "@angular-devkit/core": "0.0.29",  <== add 
    "@angular/animations": "4.4.5",
    "@angular/cdk": "2.0.0-beta.12",
    "@angular/common": "4.4.5",
    "@angular/compiler": "4.4.5",


    npm WARN @angular/core@4.4.5 requires a peer of rxjs@^5.0.1 but none was installed.
    npm WARN @angular/http@4.4.5 requires a peer of rxjs@^5.0.1 but none was installed.
    npm WARN @angular/router@4.4.5 requires a peer of rxjs@^5.0.1 but none was installed.
    npm WARN @ngrx/core@1.2.0 requires a peer of rxjs@^5.0.0-beta.12 but none was installed.
    npm WARN @ngrx/effects@2.0.5 requires a peer of rxjs@^5.4.0 but none was installed.
    npm WARN @ngrx/store@2.2.2 requires a peer of rxjs@^5.0.0-beta.12 but none was installed.
    npm WARN @ngrx/store-devtools@3.2.4 requires a peer of rxjs@^5.0.0-beta.12 but none was installed.

   
   ```
   
   ```
    Date: 2018-09-30T04:52:00.185Z
Hash: 0affb03c00d8767fcb3f
Time: 209049ms
chunk {0} 0.a62a5fb2bedf8b6d4218.chunk.js (common) 1.25 MB {18}  [rendered]
chunk {1} 1.8dc4b170dc29c0c7cf9f.chunk.js () 91 kB {18}  [rendered]
chunk {2} 2.54e8d81894c3e0f8b770.chunk.js () 21.8 kB {18}  [rendered]
chunk {3} 3.514185cb75783f532ac1.chunk.js () 160 kB {18}  [rendered]
chunk {4} 4.f5419c75a72333686ee5.chunk.js () 52.3 kB {18}  [rendered]
chunk {5} 5.a730782d3a43198eb24a.chunk.js () 70.1 kB {18}  [rendered]
chunk {6} 6.da0ea3f72faecf4087d0.chunk.js () 216 kB {18}  [rendered]
chunk {7} 7.229d7f1fd070efdeb2a4.chunk.js () 83.8 kB {18}  [rendered]
chunk {8} 8.ad26cbeff9b589bca7c1.chunk.js () 47 kB {18}  [rendered]
chunk {9} 9.af3b37da898cd4246048.chunk.js () 328 kB {18}  [rendered]
chunk {10} 10.bf4f22bf447fda294c62.chunk.js () 525 kB {18}  [rendered]
chunk {11} 11.617f5ec96c9d3116f4fa.chunk.js () 66.2 kB {18}  [rendered]
chunk {12} 12.1efff38d031deeeae6a2.chunk.js () 146 kB {18}  [rendered]
chunk {13} 13.ccbf328054703ff7a786.chunk.js () 59.5 kB {18}  [rendered]
chunk {14} 14.b3ca72853dbf5f3c87f7.chunk.js () 335 kB {18}  [rendered]
chunk {15} 15.4395bf6c537185467ab8.chunk.js () 329 kB {18}  [rendered]
chunk {16} 16.96d00dfd9598e0741863.chunk.js () 396 kB {18}  [rendered]
chunk {17} polyfills.b7fedfe1b384d13077de.bundle.js (polyfills) 97.3 kB {21} [initial] [rendered]
chunk {18} main.074bf37234dadf6d1219.bundle.js (main) 82.7 kB {20} [initial] [rendered]
chunk {19} styles.791ec5bdd3c3b536c656.bundle.css (styles) 277 kB {21} [initial] [rendered]
chunk {20} vendor.7258f30a02f1c5f6097a.bundle.js (vendor) 482 kB [initial] [rendered]
chunk {21} inline.a091fac56efd1f626c2d.bundle.js (inline) 1.88 kB [entry] [rendered]

ERROR in 10.bf4f22bf447fda294c62.chunk.js from UglifyJs
TypeError: Cannot set property 'fixed' of undefined
    at TreeWalker.eval [as visit] (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:5584:25)
    at TreeWalker._visit (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1339:24)
    at AST_This._walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:480:24)
    at AST_Dot.eval (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1061:29)
    at TreeWalker._visit (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1343:21)
    at AST_Dot._walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1060:24)
    at AST_Dot.walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:483:21)
    at TreeWalker.eval [as visit] (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:5722:31)
    at TreeWalker._visit (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1339:24)
    at AST_ForIn._walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:653:24)
    at walk_body (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:530:17)
    at AST_Function.eval (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:771:13)
    at eval (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1340:21)
    at TreeWalker.eval [as visit] (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:5665:21)
    at TreeWalker._visit (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1339:24)
    at AST_Function._walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:765:24)

    npm ERR! Linux 4.15.0-34-generic
    npm ERR! argv "/usr/bin/node" "/usr/bin/npm" "run" "build"
    npm ERR! node v8.10.0
    npm ERR! npm  v3.5.2
    npm ERR! code ELIFECYCLE
    npm ERR! fims@0.1.0 build: `ng build --prod`
    npm ERR! Exit status 1
    npm ERR!
    npm ERR! Failed at the fims@0.1.0 build script 'ng build --prod'.
    npm ERR! Make sure you have the latest version of node.js and npm installed.
    npm ERR! If you do, this is most likely a problem with the fims package,
    npm ERR! not with npm itself.
    npm ERR! Tell the author that this fails on your system:
    npm ERR!     ng build --prod
    npm ERR! You can get information on how to open an issue for this project with:
    npm ERR!     npm bugs fims
    npm ERR! Or if that isn't available, you can get their info via:
    npm ERR!     npm owner ls fims
    npm ERR! There is likely additional logging output above.

    npm ERR! Please include the following file with any support request:
    npm ERR!     /home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/npm-debug.log


   ```
   
   ```
       
       nodejs : v10.11.0
       npm : 6.4.1

       npm : 依赖: nodejs 但是它将不会被安装
       依赖: node-abbrev (>= 1.0.4) 但是它将不会被安装
       依赖: node-ansi (>= 0.3.0-2) 但是它将不会被安装
       依赖: node-ansi-color-table 但是它将不会被安装
       依赖: node-archy 但是它将不会被安装
       依赖: node-block-stream 但是它将不会被安装
       依赖: node-fstream (>= 0.1.22) 但是它将不会被安装
       依赖: node-fstream-ignore 但是它将不会被安装
       依赖: node-github-url-from-git 但是它将不会被安装
       依赖: node-glob (>= 3.1.21) 但是它将不会被安装
       依赖: node-graceful-fs (>= 2.0.0) 但是它将不会被安装
       依赖: node-inherits 但是它将不会被安装
       依赖: node-ini (>= 1.1.0) 但是它将不会被安装
       依赖: node-lockfile 但是它将不会被安装
       依赖: node-lru-cache (>= 2.3.0) 但是它将不会被安装
       依赖: node-minimatch (>= 0.2.11) 但是它将不会被安装
       依赖: node-mkdirp (>= 0.3.3) 但是它将不会被安装
       依赖: node-gyp (>= 0.10.9) 但是它将不会被安装
       依赖: node-nopt (>= 3.0.1) 但是它将不会被安装
       依赖: node-npmlog 但是它将不会被安装
       依赖: node-once 但是它将不会被安装
       依赖: node-osenv 但是它将不会被安装
       依赖: node-read 但是它将不会被安装
       依赖: node-read-package-json (>= 1.1.0) 但是它将不会被安装
       依赖: node-request (>= 2.25.0) 但是它将不会被安装
       依赖: node-retry 但是它将不会被安装
       依赖: node-rimraf (>= 2.2.2) 但是它将不会被安装
       依赖: node-semver (>= 2.1.0) 但是它将不会被安装
       依赖: node-sha 但是它将不会被安装
       依赖: node-slide 但是它将不会被安装
       依赖: node-tar (>= 0.1.18) 但是它将不会被安装
       依赖: node-underscore 但是它将不会被安装
       依赖: node-which 但是它将不会被安装
    E: 无法修正错误，因为您要求某些软件包保持现状，就是它们破坏了软件包间的依赖关系。

   ```
   
   ```
    npm WARN @angular/core@4.4.5 requires a peer of rxjs@^5.0.1 but none is installed. You must install peer dependencies yourself.
    npm WARN @angular/http@4.4.5 requires a peer of rxjs@^5.0.1 but none is installed. You must install peer dependencies yourself.
    npm WARN @angular/router@4.4.5 requires a peer of rxjs@^5.0.1 but none is installed. You must install peer dependencies yourself.
    npm WARN @ngrx/core@1.2.0 requires a peer of rxjs@^5.0.0-beta.12 but none is installed. You must install peer dependencies yourself.
    npm WARN @ngrx/effects@2.0.5 requires a peer of rxjs@^5.4.0 but none is installed. You must install peer dependencies yourself.
    npm WARN @ngrx/store@2.2.2 requires a peer of rxjs@^5.0.0-beta.12 but none is installed. You must install peer dependencies yourself.
    npm WARN @ngrx/store-devtools@3.2.4 requires a peer of rxjs@^5.0.0-beta.12 but none is installed. You must install peer dependencies yourself.
    npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.4 (node_modules/fsevents):
    npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.4: wanted {"os":"darwin","arch":"any"} (current: {"os":"linux","arch":"x64"})

    npm i -save @covalent/core
   ```
   
   ```
    ERROR in 10.bf4f22bf447fda294c62.chunk.js from UglifyJs
    TypeError: Cannot set property 'fixed' of undefined
    at TreeWalker.eval [as visit] (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:5584:25)
    at TreeWalker._visit (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1339:24)
    at AST_This._walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:480:24)
    at AST_Dot.eval (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1061:29)
    at TreeWalker._visit (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1343:21)
    at AST_Dot._walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1060:24)
    at AST_Dot.walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:483:21)
    at TreeWalker.eval [as visit] (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:5722:31)
    at TreeWalker._visit (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1339:24)
    at AST_ForIn._walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:653:24)
    at walk_body (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:530:17)
    at AST_Function.eval (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:771:13)
    at eval (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1340:21)
    at TreeWalker.eval [as visit] (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:5665:21)
    at TreeWalker._visit (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:1339:24)
    at AST_Function._walk (eval at <anonymous> (/home/ubuntu/github/integratoin-tests/fineract-cn-fims-web-app/node_modules/uglifyjs-webpack-plugin/node_modules/uglify-js/tools/node.js:27:1), <anonymous>:765:24)
    npm ERR! code ELIFECYCLE
    npm ERR! errno 1
    npm ERR! fims@0.1.0 build: `ng build --prod`
    npm ERR! Exit status 1
    npm ERR!
    npm ERR! Failed at the fims@0.1.0 build script.
    npm ERR! This is probably not a problem with npm. There is likely additional logging output above.

    npm ERR! A complete log of this run can be found in:
    npm ERR!     /home/ubuntu/.npm/_logs/2018-09-30T07_52_57_298Z-debug.log

   ```
   
   
   
   

   
# reference
  
  - [npm mirror](https://npm.taobao.org/ )
  - [fineract-cn-fims-web-app](https://github.com/apache/fineract-cn-fims-web-app )
  - [install npm 6 on ubuntu 16.04](https://askubuntu.com/questions/786272/why-does-installing-node-6-x-on-ubuntu-16-04-actually-install-node-4-2-6 )
  - [Failed to exec start script - EventEmitter.<anonymous> ](https://stackoverflow.com/questions/49446277/failed-to-exec-start-script-eventemitter-anonymous-usr-local-lib-node-modu )