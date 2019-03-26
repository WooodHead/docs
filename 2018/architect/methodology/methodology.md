# Architecture Methodology Overview

## [Conway's Law](https://en.wikipedia.org/wiki/Conway%27s_law)

  Conway’s Law, any organization that designs a system will produce a design whose structure is a copy of the organization’s communication structure. In other words, we will have different teams working on different bounded contexts. They may result in very good communication within a team, but not between teams. When the communication between teams lack, the design decisions made
on corresponding bounded contexts do not get propagated to other parties properly. Having a context map helps each team track changes happening on the bounded contexts they rely on

## [Domain-Driven Design](https://en.wikipedia.org/wiki/Domain-driven_design)

## [12 factors - Heroku  2012](https://12factor.net)

The 12 Factor App is a manifesto9 published by Heroku in 2012. This manifesto is a collection of best practices and guidelines to build and maintain scalable, maintainable, and portable applications. Even though these best practices are initially derived from the applications deployed on the Heroku cloud platform, today it has become a mantra for any successful microservices deployment. These 12 factors discussed next are quite common and natural, so chances are very high that you are adhering to them, knowingly or unknowingly.

- Codebase

all your source code
in a version control system

- Dependencies

should explicitly declare and isolate your dependencies and should never rely on implicit system-wide dependencies

- Configruration

decouple environment specific settings from the code to configuration.

- Backing Services

backing services should be treated as attachable resources. In other words, they should be pluggable into our microservices implementation

- Build,Release,Run

having a clear separation among the build, release, and run phases of an application

- Processes

 should be stateless and should avoid using sticky sessions

- Shared Nothing Architecture

a system should not share either the disk or the memory with other nodes

- Port Binding

self-contained,application itself has to do the port binding and expose it as a service

- Concurrency

an application should be able to horizontally scale or scale out.

- Disposability

the ability of an application to spin up fast and shut down gracefully when required

## Reference

- Microservices for the Enterprise_Designing Developing, and Deploying
- Implementing Domain-Driven Design - Vaughn Version
- Domain-Driven Design Trackling Complexity in the heart of software- Eric Evans
- Patterns, Principles, and Practices of Domain-Driven Design - Scott Millett & Nick Tune
- Adaptive Code - Gary McLean Hall
- the eight fallacies of distributed computing - Peter Deutsch & James Gosling
- Release It Michael T. Nygard
- [Brief Introduction to architectural decision records](https://speakerdeck.com/vanto/a-brief-introduction-to-architectural-decision-records)
