# SSH Use Cases
* [SSH - Cloud Foundry](https://docs.cloudfoundry.org/concepts/diego/ssh-conceptual.html)
```
Application SSH Components and Processes
SSH Components
SSH Daemon
SSH Proxy Authentication
Page last updated: November 7, 2017

This document describes details about the Cloud Foundry SSH components for access to deployed application instances. Cloud Foundry supports native SSH access to applications and load balancing of SSH sessions with the load balancer for your Cloud Foundry deployment.

The SSH Overview document describes procedural and configuration information about application SSH access.

SSH Components
The Cloud Foundry SSH includes the following central components, which are described in more detail below:

An implementation of an SSH proxy server.
A lightweight SSH daemon.
If these components are deployed and configured correctly, they provide a simple and scalable way to access containers apps and other long running processes (LRPs).

SSH Daemon
The SSH daemon is a lightweight implementation that is built around the Go SSH library. It supports command execution, interactive shells, local port forwarding, and secure copy. The daemon is self-contained and has no dependencies on the container root file system.

The daemon is focused on delivering basic access to application instances in Cloud Foundry. It is intended to run as an unprivileged process, and interactive shells and commands will run as the daemon user. The daemon only supports one authorized key, and it is not intended to support multiple users.

The daemon can be made available on a file server and Diego LRPs that want to use it can include a download action to acquire the binary and a run action to start it. Cloud Foundry applications will download the daemon as part of the lifecycle bundle.

SSH Proxy Authentication
The SSH proxy hosts the user-accessible SSH endpoint and is responsible for authentication, policy enforcement, and access controls in the context of Cloud Foundry. After a user has successfully authenticated with the proxy, the proxy will attempt to locate the target container and create an SSH session to a daemon running inside the container. After both sessions have been established, the proxy will manage the communication between the user’s SSH client and the container’s SSH Daemon.
```