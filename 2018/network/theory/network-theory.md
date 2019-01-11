# Network Theory

## Concepts

### Subset Mask

* how devices communicate using IP when the devices are on the same subnet
* 255.255.255.0(/24)  

If the devices are in the same subnet, the mechanism used to determine the location of the destination device is the broadcast. A broadcast packet is a special packet on the subnetwork that's sent to every device on the subnetwork. The broadcast address is designated as 255.255.255.255. This is known as a limited broadcast because it is limited to the subnet that it originated from.

When a broadcast is received -- which is actually a broadcast MAC address that is local to that VLAN -- all devices within that subnet respond with their IP address and the physical MAC address of the network card. These two pieces of information are then placed into an address resolution protocol (ARP) table. The table is used to keep track of the location of devices on the same subnet. And ultimately, the ARP table is used to efficiently switch data on the same subnet at the data link layer of the OSI model.

As you can imagine, the larger the subnetwork is, the more broadcast and ARP traffic will consume your network. In our example, a 255.255.255.0 network mask can hold up to 254 different devices. The next largest network is 512, and then 1024. Depending on your network capacity, anything over 1024 hosts on a single subnet is going to create too much broadcast traffic. Instead, subnets are intended to shrink broadcast domains so that the broadcasts themselves have little to no impact on the performance of the network.

### Default Gateway 

* on different subsets

I've covered how devices communicate using IP when the devices are on the same subnet. But what happens if they are on different networks? This is where the default gateway comes into play. As described previously, the source device and destination device are either on the same subnet or they're on different subnets. In this example, let's change our source IP address, while keeping the destination address the same. So now our source and destination address and subnet masks are:

192.168.99.15 255.255.255.0

192.168.40.39 255.255.255.0

Because we are still using /24 subnet masks, we know these two devices are in different subnets since the third octet for each is different. And because subnets are used to break up broadcasts, using the broadcast mechanism with an ARP table will not work in this situation. This is why we need a default gateway.

The default gateway is used as the destination of all traffic that is not on the same subnet. The gateway is a layer 3 device such as a router or multi-layer switch that is used to route traffic on a hop-by-hop basis. But for the purposes of this discussion, the only thing the end device needs to know is whether the data is on the same subnet. If it's not, the source device delivers traffic to the end device through the default gateway.

The default gateway always resides in the same subnet as the end device IP. The gateway can really be any unique address within the subnet itself, but most network administrators designate the first number of the subnet as the gateway. Therefore, 192.168.99.1 would be the default gateway of our source device given the fact that we have a 255.255.255.0 subnet mask.

##  Reference

* [IPAddress,Subnet Mask,Default Gaetway](https://www.networkcomputing.com/network-security/ip-addresses-subnet-masks-and-default-gateways/1835691346)