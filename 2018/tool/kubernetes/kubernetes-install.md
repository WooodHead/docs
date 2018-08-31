# kubernetes install


## Installing a VM Backed K8s Cluster

   - The first step is to update the base image
   
     ``` template
		sudo yum update -y
		hostnamectl set-hostname k8s-template
		systemctl restart systemd-hostnamed && exec bash
		sestatus
		setenforce 0
		sudo nano /etc/sysconfig/selinux  //“SELINUX=enforcing” to “SELINUX=disabled” 
        sudo swapoff -a	
		sudo nano  /etc/fstab
		sudo nano /etc/hosts
	 ```
   
   
   
   
   
   
   
# Reference

  - [Installing a VM Backed K8s Cluster](http://vrelevant.net/installing-a-vm-backed-k8s-cluster-with-kubeadm/)
  - [CentOS7下yum安装Kubernetes](https://blog.csdn.net/lic95/article/details/55015284)