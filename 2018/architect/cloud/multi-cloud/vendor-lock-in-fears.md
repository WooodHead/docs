* [6 things you can do to avoid cloud vendor lock-in](https://www.thorntech.com/2017/09/avoidingcloudvendorlockin/)

```
Migrating to the cloud can bring a multitude of benefits to your company, such as increased agility, flexibility, and cost savings.
Despite all of these positives, many companies who are considering a move to the cloud have concerns. And one of the primary issues is vendor lock-in.
When the foundation of your company’s IT is in the hands of an outside vendor, these concerns are valid.
You might ask yourself these questions:
What if the cloud service provider’s (CSP) offerings don’t meet my needs?
What if the CSP makes a major product change that doesn’t work for my business?
What happens if the CSP goes out of business?
Most cloud migrations, if planned and executed correctly, go pretty smoothly. But if something goes wrong with your CSP after your migration, moving to another cloud vendor can incur substantial costs, technical problems, and more.
So what can you do to avoid cloud vendor lock-in, or at least minimize its negative effects?

Causes of cloud vendor lock-in fears
Fears of cloud vendor lock-in stem from a number of places.
First, it’s the loss of control over the data and infrastructure that power business’ applications. Not having complete control over aspects like security, uptime, and overall infrastructure management can be a scary thing.
Next, it’s the dependence on a single vendor for so many critical needs. Your servers, data, networking, user management, and much more are in the hands of one company, so the dependence on your provider is huge. And if something goes wrong, it can be very detrimental to your business.
Also, there may be fear that one cloud provider might not meet your current or future needs. Your CSP might fail to meet service level agreements or incur a data breach, and you’ll be forced to rethink your relationship.
Even worse, the risk of that vendor going out of business is something you’ll have to account for.
The difficulty and cost of switching to a new vendor looms large in every IT manager’s mind when deciding to move to the cloud and selecting a cloud service provider.

Types of vendor lock-in risks
The issue with vendor lock-in is the difficulty in moving to another cloud service provider if something goes awry. You hope that this never has to happen, but it’s a possibility.
There are four primary lock-in risks that you’ll take working with a single cloud provider. These include:
Data transfer risk
Application transfer risk
Infrastructure transfer risk
Human resource knowledge risk
 
Data transfer risk
It is not easy to move your data from one CSP to another.
A myriad of questions will arise during a data migration process, such as:
Who is responsible for extracting the data from the cloud databases and data warehouses?
In what format will the data be? Will that format work with the new cloud provider, or will significant changes need to be made to the data?
How can the data be transferred without loss of application functionality?
How long will it take and how much will it cost to move all of this data?
While some industry groups have tried to create standards for data interchange, sometimes it’s difficult for companies to implement them due to their unique business requirements

Application transfer risk
If you build an application on one CSP that leverages many of its offerings, the reconfiguration of this application to run natively on another provider can be an extremely expensive and difficult process.
For instance, let’s say you’ve developed a business intelligence platform on Microsoft Azure. You leverage basic cloud services like compute, storage, databases, and networking. But the app also includes Azure’s machine learning, data lake analytics, and bot services.
Can you imagine all the changes you’ll have to make to your application if you had to move this to another CSP?
One reason for this difficulty is a lack of standard interfaces and open APIs. Every CSP has their own proprietary specifications and standards, which make it very tough to move from one to another.
Another reason is that technology and customer needs change so rapidly.
You know first hand that your customers and partners continuously demand changes and improvements to your product. The faster that you add and edit features of your cloud-native application, the deeper entrenched you get with your CSP, and the tougher it will be to move to another cloud vendor.
 
Infrastructure transfer risk
Every major CSP does things a little bit differently.
Virtual machine formats and their associated pricing vary from vendor to vendor, making it difficult to ensure that you have the appropriate resource usage and cost savings if you switch providers.
Database offerings and formats may differ as well.
And one cloud provider may have more attractive offerings in certain infrastructure components, while lacking in other services that you may need.
These differences in the underlying infrastructure result in difficulties moving from one cloud service provider to another.

Human resource knowledge risk
If you’ve been working with a single CSP, your IT team has likely gained a lot of institutional knowledge about that provider’s tools and configurations.
If you have to move your applications to another CSP, it will take time for your engineers to ramp up their knowledge of the new cloud platform. They’ll have to learn about new infrastructure formats, implementation processes, and more.
Additionally, any newly required certifications will take a long time to earn.
The knowledge risk is a factor that isn’t often thought about, but is just as important as the risks highlighted above.

Steps to take to avoid vendor lock-in
The risks that you take with having all your data, applications, and infrastructure with one cloud provider seem ominous. But there are a few things that you can do to ensure that your vendor lock-in risk is minimized.
 
1) Do your due diligence
Before you select your CSP, you should thoroughly vet that they will give you everything that you need to run your applications reliably.
Your CSP selection process should look something like this:
Determine your goals of migrating to the cloud
Assess your current IT situation, including a thorough audit of your current infrastructure and cost and resources levels
Select the type of cloud environment needed – public, private, or hybrid?
Determine the specific cloud components necessary
Choose the right cloud provider for your situation
You should consider all of the CSPs’ offerings to see if they match your needs, look at the different pricing models to determine the cost savings you can realize, understand their service level agreements, consider their data transfer processes and costs, and get to know other companies similar to yours with whom they’ve worked.
A deep understanding of your potential CSP is critical in mitigating the risk of vendor lock-in.

2) Plan early for an exit
It’s kind of like a cloud pre-nuptial agreement.
It might be weird to plan for an exit before you even “get married” to your cloud provider, but it’s an important step to protect your company in case things go south.
While you plan your implementation strategy, include an exit plan and potential costs. And don’t plan out further than a couple of years; doing so may hamper your flexibility in migrating to another CSP if things go wrong.
 
3) Design your application to be loosely coupled
To minimize the risk of vendor lock-in, your applications should be built or migrated to be as flexible and loosely coupled as possible.
Cloud application components should be loosely linked with the application components that interact with them.
You can do this by incorporating REST APIs with popular industry standards like HTTP, JSON, and OAuth to abstract your applications from the underlying proprietary cloud infrastructure.
Also, any business logic should not only be separated from the application logic, but should be clearly defined and documented. This will avoid the need to decipher business rules in case a migration to a new CSP occurs.
Not only does this reduce the level of lock-in to a single vendor, but it also gives your application interoperability that’s required for fast migration of workloads and multi-cloud environments (more on this later).

4) Maximize portability of your data
Data is one of the biggest sticking points in cloud migrations, as different formats and models can cause portability issues.
The Open Data Element Framework was created to help standardize the documentation, categorization, and indexing of data, and the Cloud Data Management Interface helps define how to create, retrieve, update and delete data elements from the cloud.
Unfortunately these standards aren’t always well understood, accepted, nor applied.
To maximize the portability of your data, avoid proprietary formatting. Describe data models as clearly as possible, using applicable schema standards to create detailed computer- and human-readable documentation.
Additionally, you should ensure that your cloud provider provides a way for you to extract data easily and economically.
Data lock-in is probably the most difficult risk to mitigate, so taking these steps will go a long way in easing your data’s transition from one CSP to another.

5) Consider a multi-cloud strategy
More businesses are moving to a multi-cloud environment, where you can leverage multiple CSPs to power your applications.
For example, you might use Amazon EC2 for your compute power and Redshift for your data warehouse while using IBM Bluemix’s Watson as your artificial intelligence platform.
By going multi-cloud, you become less dependent on one CSP for all of your needs. Another benefit is that you can cherry-pick offerings from each cloud provider so you can implement best-of-breed services into your applications.
There are some cons to a multi-cloud approach, such as an increased burden on development teams, more security risk, and others. (See here for an in-depth list of the pros and cons of multi-cloud environments.)
But you may find that it’s a viable option to mitigate vendor lock-in.

6) Implement DevOps tools and processes
DevOps tools are increasingly being implemented to maximize code portability.
Container technology provided by companies like Docker and CoreOS help isolate software from its environment and abstract dependencies away from the cloud provider. And since most CSPs support standard container formats, it should be easy to transfer your application to a new cloud vendor if necessary.
Additionally, configuration management tools like Chef and Puppet help you automate the configuration of the infrastructure on which your apps run. This allows you to deploy your application to diverse IT environments, which can reduce the difficulty of moving to a new CSP.
These technologies reduce the lock-in risks that stem from proprietary configurations and can ease the transition from one CSP to another.

Conclusion
When your application logic and data is housed by a single cloud service provider, there are issues that can arise.
In order to mitigate cloud vendor lock-in, you should perform thorough due diligence on potential cloud providers, plan early for an exit, build a loosely-coupled application, set up your data for maximum portability, consider a multi-cloud strategy, and implement DevOps tools.
While cloud computing vendor lock-in is a legitimate concern, we believe that the benefits outweigh the risks, and you can extract much more value and build better applications by going deep with your CSP. We’ll write in our next blog post about how embracing vendor lock-in can be beneficial to your company.
Are you concerned with cloud vendor lock-in? If so, why? We’d love to hear from you in the comments.
We hoped you liked this post! If you did, please share it using the share buttons to the left. Then join our mailing list below, follow us on Twitter @thorntech, and join our Facebook page for future updates.
```

# Reference

* [Why you should embrace, not fear, cloud vendor lock-in](https://www.thorntech.com/2017/10/embrace-not-fear-cloud-vendor-lock-in/)