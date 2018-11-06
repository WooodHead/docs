

# ![Cloud Foundry Deigo Auction Algorithms](diego-auction-process.png)

```
Allocate all jobs only to Cells that have the correct software stack to host them, and sufficient resources given their allocation so far during this auction.

Allocate LRP instances into Availability Zones that are not already hosting other instances of the same LRP.

Within each Availability Zone, allocate LRP instances to run on Cells that are not already hosting other instances of the same LRP.

Allocate any job to the Cell that has lightest load, from both the current auction and jobs it has been running already. In other words, distribute the total load evenly across all Cells.
```

# Reference
*  [Cloud Foundry Diego Auction Algorithms](https://docs.cloudfoundry.org/concepts/diego/diego-auction.html)