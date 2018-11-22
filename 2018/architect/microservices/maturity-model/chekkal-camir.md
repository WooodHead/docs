# Microservices maturity model: From Monolith to Kubernetes

A microservice system is a distributed one whose components are lightweight (low memory consumption, low CPU overhead, low startup time, …) and that coordinate to achieve a common goal.

This post highlights some milestones in your journey toward a microservice based architecture.

## Level 0: Big ball of mud

A big chunk of entangled code implementing the whole functionality, without clean separation of concerns. A spaghetti code that no one can fully comprehend and wich defy all rules of logic. In sum a big ball of mud or what I like to call a Jabberwocky.

## Level 1: modular monolith

The first step toward a microservice based architecture is to split your software into modular components with well defined interface, working in senergy to provide the required behavior. For that you need to apply best practices of software design, mainly OOD (Object Oriented Design).

The DDD (Domain Driven Design) is also a viable approach that when used effectively can split the software into modular components where each module is strongly related to a part of the domain under analysis, under DDD those finest unit of design are what is called Bounded Context.

As discussed in his book Domain-Driven Design: Tackling Complexity in the Heart of Software, Eric Evans insists on the importance of refactoring (it is the hearthbeat of your software) for keeping your software in good shape, and differentiates between three types of refactorings:

Micro refactoring: like changing the names of methods, extracting method and the likes. See the book Refactoring Improving the Design of Existing Code by Martin Fowler
Refactoring to patterns: When you see the link between what a part of your software does and some well known design pattern, and you decide to apply the deign pattern. See the book Refactoring to Patterns by Joshua Kerievsky
Functional Refactoring: This refactoring is guided by a new insight into the functional model.
Level 2: isolation
Extracting a module into a separate service isolated from the whole system is the first step toward the scalability of your system, because now instead of scaling horizontaly your whole system you can scale only this service when under heavy load.

Isolating the service forces you to defines the means of communication with it, you can go either:

Synchronous: for example using REST along with Swagger for defining the contract.
Asynchronous: by means of a messaging system, be it broker based (like RabbitMQ, Apache kafka) or brokless (like ZeroMQ).
An other advantage of this isolation is that now a dedicated team can be solely responsible for the service. Also if the performances of your service doesn’t meet expectations, the team can rewrite it from scratch using a different technology stack as long as its interface is unchanged.

One thing to keep in mind is the startup time of your service, if your service startup time is not in the order of seconds then it is not a microservice.

A rule of thumb to keep in mind if you are using Domain Driven Design methodology: A service shouldn’t span more than one Bounded Context; a Bounded Context can be covered by many services.

## Level 3: Containerization

When you have many services managed by different teams, it will come a time when different services will depend on the same runtime with different versions (example: java runtime environment, nodejs environment, …), in that case those services can’t be deployed on the same physical machine or even a virtual one.

Going one virtual machine per service is a tempting option, but virtual machines come with the overhead of requiring their own operating system (guest OS), making their startup time in the order of minutes which makes them unfit to hold a microservice, because if crashed it will take too much time to reload the whole VM.

Containers to the rescue. Those are lightweigt wrappers (of your service or application) which use the host OS directly without requiring their own OS. This makes them easy to work with and they don’t incur a significant overhead.

Containers provide the required environment for the application to work isolated from all other applications running in other containers.

A contained application can run in every environment that has some specifique container deamon running.

Containers were already possible using the linux kernel features like cgroups and namespaces. But it was Docker which standardized the container format and made it available to dummies 😁.

With containers we have what Java promized us before “Develop once, run evereywere”. But now we are not restricted in our choice of a programming language.

## Level 4: data ownership

Sharing the database between more than one service, will allow developpers of a service to use data writen by another one, thus hindering any changes to the schema of its data by the dependee service or even the use of another type of database.

So a rule of thumb is for each service to have its own dedicated database and choose the type that best much its needs: A relatinal database, NoSQL one, a Graph database, ….

## Level 5: Reverse Proxy

Now that you isolated some services your software system is now distributed one, and now Anything that can go wrong will go wrong. Thus you have to adopt the Let it crash philosophy of the Erlang language, by replicating services, load balancing traffic to different instances of the same service.

Reverse Proxy to the rescue. You can replicate the same service and let the reverse proxy load balance the traffic between those instances. This also allow your service to be location transparent.

Keep in mind that handling manually the configuration of the reverse proxy and keeping track of the status off all the running services put a lot of burden on the operational team.

## Level 6: automation

The Let it crash philosophy of the Erlang language discussed previously will be a burden if we can’t automaticaly detect failure of the services and take appropriate actions.

It would also be better if we can detect automatically an increase of the load on a given service and scale it automatically (by replicating the service), or in the case of low use of a service shutdown some of its instances.

This is exactly what Kubernetes (or k8s) allows us to do, without writing all this stuff from scratch.

With K8s you also avoid vendor locking on any specific provider of a public cloud.

There is only one catch: it is dificult to set up a k8s cluster, but once done it will make the life of the operational team much more easier.

## Reference

* [Microservices maturity model: From Monolith to Kubernetes](https://medium.com/@chekkal/microservices-maturity-model-from-monolith-to-kubernetes-90ce574a6b49)