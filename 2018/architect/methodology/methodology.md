# Architecture Methodology Overview

* [Conway's Law](https://en.wikipedia.org/wiki/Conway%27s_law)

  Conway’s Law, any organization that designs a system will produce a design whose structure is a copy of the organization’s communication structure. In other words, we will have different teams working on different bounded contexts. They may result in very good communication within a team, but not between teams. When the communication between teams lack, the design decisions made
on corresponding bounded contexts do not get propagated to other parties properly. Having a context map helps each team track changes happening on the bounded contexts they rely on

* [Domain-Driven Design](https://en.wikipedia.org/wiki/Domain-driven_design)

## Reference

* Microservices for the Enterprise_Designing Developing, and Deploying
* Implementing Domain-Driven Design - Vaughn Version
* Domain-Driven Design Trackling Complexity in the heart of software- Eric Evans
* Patterns, Principles, and Practices of Domain-Driven Design - Scott Millett & Nick Tune
* Adaptive Code - Gary McLean Hall