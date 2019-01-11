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
* S3's Access Key ID and Secret Access Key configruation best practice?
* SANSEC secret configuration information will be stored configfile which mounted by devops 

```stubconfig.xml
<init-param>
	<description>
		Define the fully qualified path name of your Keystore NTB: D:\\keystore\\keystore.jks
	</description>
	<param-name>KeyStoreLocation</param-name>
	<param-value>SafewaySDK.jks</param-value>
</init-param>
```

* Any secret information should be added into code repository
* Every environement(uat,prod) should be using itself subdomain name separately
* Path will be used as application distinction in the url
* tubanxiong.deteconauto.com will be used as domain name for 途伴熊, then xxx.tubanxiong.deteconauto.com as every environment subdomain (prod: tubanxiong.deteconauto.com, uat: uat.tubanxiong.deteconauto.com)
* smoothly switch tubanxiong.deteconauto.com to tubanxiong.cn plan. tubanxiong.deteconauto.com TTL provided by DNS vendor.
* ping command willnot be permitted by aws
* using AWS IAM to switch role
* AWS WAF is only used in prod enviornment
* performance difference (response time) between uat and prod
* HA testing (failover ec2,rds,redis,waf)
  test url:
    https://tubanxiong.deteconauto.com/wx/#share.html
https://uat.tubanxiong.deteconauto.com/safeway-admin/#/login 
  test result : http 504
  reason: AWS Security Group "BGP potocol data not allowed "
* VPN password may be reset by devops
* Derrick is Product owner
* Harbor is Daimler hub repository
* using "rolling update" to upgrade
* http check should be used with http
* docker container demployment robust testing (balanced distribution among nodes) 
* CaaS 

【风险评估通知】【重要且紧急】
Hi 各位
由于我们将于平台下次迭代全面兼容德国的CAAS解决方案，我们将遵循戴姆勒德国的标准，将容器负载均衡方案改为 Traefik 以获得更好的兼容性并为未来的SERVICEMESH做好准备，TRAEFIK也能进一步完善平台的功能（轻量级，更好的性能，更完善的负载均衡策略等）。
目前测试 K8s 的 Ingress Controller 实现方案 Traefik，会将非标准 HTTP Header 转换为标准 HTTP Header（https://github.com/containous/traefik/issues/466），具体转换规则为：用 - (中横线) 分割的单词，首字母大写，其余小写，符号不处理，只转换 Key，不转换 Value，例如
X-tEST-hEADER: true => X-Test-Header: true
可能对现有使用非标准 HTTP Header 的系统产生影响。因此，需要从应用级别确认：
1）是否存在使用非标准HTTP HEADER；
2）如果有，是否存在上述提到的问题，即“用 - (中横线) 分割的单词，首字母大写，其余小写，符号不处理，只转换 Key，不转换 Value，例如
X-tEST-hEADER: true => X-Test-Header: true”
如果存在这种问题，请尝试以下解决方案：
1. 忽略大小写，如收到请求后，转换 X-Test-Header: true 为 x-test-header: true or X-TEST-HEADER: TRUE
2. 使用 Value 部分，如 Custom-Header: X-tEST-hEADER=true

* [message-header specification](https://www.iana.org/assignments/message-headers/message-headers.xhtml)
* Daimer ISA(Information Security Architect) will make any assetment about message push
* some of safeway api will be opened for pushing message from 3rd-parties and it should be audited
so authenticated api should be used
* safeway uses the websocketß