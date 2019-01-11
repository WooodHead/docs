# Safeway Overview

* docker perferred
* using PaaS provided by Daimler ITI
* usiing SANSEC repository to manage secret key
* using devops portal provided by Dailer ITI
* encrypted transmission within AWS RDS and S3 according to "confidential" project level
* AWS MFA authentication will be used by Dailmer Demand
* encrypted thoery will be used in custom's private date except videos.
* PostgreSQL may be accessed by pgadmin through Internet if AWS VPC Security Group is permitted
* Using Redis
* 在KMS上分配一个主密钥，使用主密钥创建数据密钥，使用数据迷药明文在本地做加密和解密 
  SecKMSaccessKeyId : 用户名
  SecKMSSaccessKey: 数据密钥
  SecKMSMasterKeyId: 主密钥ID
  生成数据迷药需要SecKMSaccessKeyId
* SANSEC secret information should be config with K8S SECRET which with RBAC feature and firewall pretection, so using API to storage them into K8S
* SANSEC has rotate ability to protect the key-expose
* It's recommended using '/app' as mount_path as the same as the path which app existed.

