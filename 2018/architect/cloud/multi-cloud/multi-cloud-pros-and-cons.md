# [What You Need to Think About Before Going Multi-Cloud](https://www.thorntech.com/2017/05/pros-cons-going-multi-cloud/)

```
According to the 2016 IDC CloudView survey, 56% of companies who use AWS are also using cloud services from another provider, and an additional 23% of respondents have plans to do so very soon.

Why are more and more companies moving to multi-cloud environments?
First of all, let’s define what it means to have your workload in multiple clouds.
A multi-cloud environment is one where a company uses public cloud services from multiple cloud service providers to power their applications.
This might mean that you use AWS Aurora for your databases and Cognito for user management while using Google Compute Engine and Load Balancing, all for a single application.
Or you might use IBM SoftLayer to deliver a software platform to your US users and Microsoft Azure for your customers in Asia.
Or maybe your mobile app runs primarily on Digital Ocean but is completely replicated and backed up on AWS.
You can use different clouds for different apps. You can have your development and test environments on one cloud, and your production environment on another. Or you can use two different clouds for data backup.
If you’re considering deploying your application on multiple public clouds, here are the pros and cons that you should consider before making a decision.

Pros

Best of breed services
Not all cloud providers will have the best tools for everything you need to accomplish. To ensure that you have the very best services that will maximize the performance of your application, using multiple cloud providers might be the best way to go.
For instance, let’s say your company provides a video hosting platform. When a client uploads a video, you might use AWS Lambda to fire events to encode and tag these videos, but you may also integrate Google Cloud Video Intelligence to better annotate these videos and make them more searchable and discoverable.
Or you may be building an app that needs to seamlessly integrate with Microsoft products, so Azure may be the best cloud option. But you also need to leverage artificial intelligence from IBM Watson, so using Softlayer is necessary as well.
Each cloud provider will have its strengths and weaknesses. Depending on the features that you need to incorporate into your application, you can cherry-pick the best services from each provider to build your app.

Improved disaster recovery
No cloud provider is perfect.
In February, Amazon’s S3 service was down for hours because of human error, causing huge sites like Trello, Quora, and IFTTT to go offline.
Microsoft Azure had instances of outages in the past, and Google Cloud Platform had its problems as well.
While outages don’t occur often, they can cause major disruptions when they do.
A multi-cloud approach can help you mitigate major IT disasters by not putting all of your eggs into one basket.
Cloud providers do a good job of keeping their availability zones separate, but dependencies can still exist.
By using two different cloud providers, your infrastructure can be more resilient, since there are no dependencies at all between the services.
Going multi-cloud allows you have to a separate, independent replica of your application on another cloud provider’s infrastructure that you can deploy in the case that one vendor goes down.

Less vendor dependency and lock-in
By using multiple cloud providers, you can minimize your dependency on a single provider.
You never know when your cloud provider might jack up prices with little notice. By using multiple clouds, you can keep your vendors in check by having another provider in your back pocket.
Additionally, your cloud provider may not meet the service levels, whether it be uptime or customer service, that you require.
Or worst yet, a cloud provider can go out of business.
Depending on one service provider for anything is a risky proposition. Many companies are realizing that this is especially important for their IT infrastructure and are moving to multi-cloud architectures to avoid this.

Lower latency due to proximity to customers
It’s good to be close to your customers.
When hosting your applications, you can select cloud regions and zones that are in close proximity to your customers to minimize latency and improve the user experience.
The less distance your customers’ data has to travel, the faster your application will respond to your users’ actions. Atomia performed an excellent comparison of the geographic coverage of AWS, Azure, and Google Cloud.
If many of your customers reside in Taiwan and Australia, it may make sense to host your application on Google for your Taiwan users and Azure in Australia.
Or if your company focuses on government clients, you might choose to use Azure’s government-focused services on the East Coast and AWS GovCloud on the West Coast.
Using a combination of multiple cloud providers to achieve faster speed may be worth it to improve your applications’ user experience.


Potential negotiation power if your spend is very high
If your cloud computing spend is very high, you may have increased negotiating power if you pit two or more cloud vendors against each other for your IT business.
You may be able to negotiate your pricing if you spend over a million dollars per year on cloud infrastructure, and working with multiple vendors can give you some leverage in haggling for lower prices.
Some providers may even try to woo you with lower prices if you commit to using their services exclusively.
The power of competition is strong, and you never know what you can squeeze out of cloud providers if your usage is high.


Cons

Increased burden on development teams
The first and primary drawback of implementing a multi-cloud environment is the increased burden that is placed on your development team.
First, if your developers aren’t restricted to a single cloud provider, they will now have a plethora of options to choose from to build their applications.
While having more options can certainly be a good thing, it will take more time to research and select which components of which cloud vendor to use. This ultimately increases the amount of work for your development team and slows down the process.
Next, your developers will have to learn how to integrate the application with the infrastructure of multiple cloud providers.
Each cloud provider will have different APIs and standards, and your engineers will have to navigate these to ensure that the application will work across the multiple clouds with no hiccups.
And depending on how you’re using multiple clouds, your team may have to rewrite application components or build multiple versions of your app.
These aren’t easy tasks, and using multiple clouds can make the development process more onerous for your team.

More management for the DevOps team
Once the application goes live, the DevOps team will have a more complex job in managing and maintaining the performance of the app.
Just like developers, DevOps engineers will also have to understand different APIs and standards to manage their cloud environment across multiple vendors.
There are cloud management platforms such as RightScale and Cliqr (now part of Cisco) that assist in managing multi-cloud environments. Configuration management tools like Chef and Puppet also help automate orchestration across multiple clouds. And there’s also open-source, cross-cloud API Apache LibCloud that enables users to interact with a variety of cloud providers.
Regardless of what cloud management tools are being used, managing multiple cloud environments can get tricky, which makes DevOps engineers’ jobs more difficult.


Increased security risk
Securing your application becomes more challenging when you involve multiple cloud providers.
When working with a single cloud provider, you can leverage their tools and expertise to manage the security of your app’s data, access permissions, compliance requirements, and more.
But the job of securing your app becomes more difficult when you have to duplicate these efforts across multiple cloud infrastructures.
Moving to the cloud gives you less control over your data. Moving to a multi-cloud environment further decreases this control.
Your application becomes more complex and has a larger attack surface when deployed on multiple clouds, which increases the likelihood of a security breach.
Each cloud provider might have different and inconsistent security policies, so you’ll have to manage those separately.
Using third-party tools like Alert Logic and may help minimize some of your security risk, but securing a multi-cloud environment can be more difficult than with a single cloud provider.

Harder to find talent who knows how to work with multiple clouds
Cloud developers are in high demand, and it’s already difficult to recruit for cloud engineers and architects who have expertise of a single cloud provider.
Finding developers who have vast knowledge of multiple clouds? Even tougher.
DevOps engineers and security experts who can work across multiple cloud providers are just as difficult to find.
As good as an idea it might be to go with multiple clouds, you’ll still need to find the right people to develop on multiple cloud platforms, and manage and secure multiple infrastructures. And these people are tough to find and recruit.

Tough to estimate costs
When working with multiple clouds, it may be more difficult to estimate workloads and calculate the costs involved.
As data moves across the components of your application, you’ll be charged a cost each time this data flows into and out of each cloud provider’s infrastructure.
In order to accurately estimate costs, you’ll need a very thorough handle on the workload that will be dedicated to each cloud provider, how data passes in and out of each provider’s components, and how all this might change over time.
Then you’ll have to navigate through each cloud provider’s pricing structure for each service that will be used in order to come up with an overall cost approximation.
This could be a fun math problem, but it will take more time and hassle than if you only used a single cloud vendor.

Slows your company’s rate of innovation
One of the key benefits of the cloud is that your team can experiment and innovate faster, since they don’t have to spend a lot of time deploying servers, setting up databases, and managing this infrastructure.
But if you have to deal with multiple cloud providers, there will be more work involved in getting applications up and running, which may delay the deployment of applications and thus the rate at which your company can experiment and innovate.
This is certainly a trade-off that you’ll have to consider, especially in today’s agile, fast-moving world.

Conclusion
There’s no doubt that companies like yours can benefit from using multiple cloud providers.
You can minimize dependence on a single provider, select and implement the best services, make your app faster and more resilient, lower your dependence on a single vendor, and potentially lower costs.
But you may find that building and managing multi-cloud applications may be a greater burden to your development, DevOps, and security teams, and it may be more difficult for you to fully staff these teams. Your rate of innovation may slow down. And estimating your costs across multiple clouds may be tough.
The decision to move to a multi-cloud environment really depends on your company’s philosophy and what factors you want to optimize.
Have you considered moving to a multi-cloud environment? What are some of the pros and cons you’ve thought about? We’d love to hear your thoughts in the comments.
```