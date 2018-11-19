# architecture patterns

* request/response pattern
* request/acknowledge pattern
* pushlish/subscribe pattern
* one-way pattern
* stream pattern
* ![sidecar pattern](../diagram/diagram-anti-corruption-layer.png)
* ![shared kernel pattern](pattern-shared-kernel.png)
* customer/supplier

A customer does not have complete say over what a supplier does. But, then again, the supplier cannot totally ignore customer feedback. A good supplier will always listen to its customers, extract the positives, give feedback back to the customers, and produce the best products to address their needs. No point in producing something useless to its customers. This is the level of collaboration expected between upstream/downstream contexts adhering to the customer/supplier pattern. This helps the downstream contexts to provide suggestions, and request changes to the interface between the two contexts. Following this pattern, there is more responsibility on the upstream context. A given upstream context not only deals with one downstream context. You need to be extra careful that a suggestion from one downstream context does not break the contract between the upstream context and another downstream context

* Partnership

When we have two or more teams building microservices under different bounded contexts, but overall moving toward the same goal, and there are notable inter-dependencies between them, partnership pattern is an ideal way to build collaboration. Teams can collaborate
in making decisions over the technical interfaces, release schedules, and anything of common interest. The partnership pattern is also applicable to any teams using the shared kernel pattern. The collaboration required to build the shared kernel can be established via a partnership. Also keep in mind that the output of the partnership pattern is not necessarily a shared kernel. It can be any interdependent services with nothing concrete to share

## reference

* streaming data-understanding the real-time pipeline-Manning.2017
* Microservices for the Enterprise_Designing Developing, and Deploying