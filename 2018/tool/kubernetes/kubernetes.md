# Kubernetes Overview

* [kubernetes commands](kubernetes-command.md)
* [kubernetes network](kubernetes-network/kubernetes-network.md)
* [kubernetes security](kubernetes-security/kubernetes-security.md)


## Kubernetes abbreviation

* rc for replicationcontrollers
* po for pods
* svc for services

## Kubernetes Concepts

* pluggable Container Runtime Interface (CRI) 

  It's makes easy to swap-out Docker(default Container Runtime ) for a different container runtime.

### ephemeral

A pod may disappear at any time—because the node it’s running on has failed, because someone deleted the pod, or because the pod was evicted from an otherwise healthy node. When any of those occurs, a missing pod is replaced with a new one by the ReplicationController, as described previously. This new pod gets a different IP address from the pod it’s replacing. This is where services come in—to solve the prob- lem of ever-changing pod IP addresses, as well as exposing multiple pods at a single constant IP and port pair.
When a service is created, it gets a static IP, which never changes during the lifetime of the service. Instead of connecting to pods directly, clients should connect to the service through its constant IP address. The service makes sure one of the pods receives the con- nection, regardless of where the pod is currently running (and what its IP address is).
Services represent a static location for a group of one or more pods that all provide the same service. Requests coming to the IP and port of the service will be forwarded to the IP and port of one of the pods belonging to the service at that moment.

## Kubernetes logging

* [logging and log collection strategies](https://kubernetes.io/docs/concepts/cluster-administration/logging/#system-component-logs)
* [Collecting Application Logs On Kubernetes](https://timber.io/blog/collecting-application-logs-on-kubernetes/)
* [Docker日志收集最佳实践](https://yq.aliyun.com/articles/72700)
  
## Kubernetes persistence volume

* [Persistent Volume](https://kubernetes.io/docs/concepts/storage/persistent-volumes/#portworx-volume)
* [Open Storage](https://github.com/libopenstorage/openstorage)
* [Container Storage Interface](https://github.com/kubernetes/community/blob/master/contributors/design-proposals/storage/container-storage-interface.md) 
  
## Kubernetes tool

* [minikube](https://github.com/kubernetes/minikube)
* [hepito](https://heptio.com/)
* [katacoda - online kubernetes test environment](https://www.katacoda.com/courses/kubernetes/playground) 
* [Play with Kubernetes](https://labs.play-with-k8s.com) 

## Kubernetes Install

* [Installing a VM Backed K8s Cluster](kubernetes-install.md)

## Kubernetes Reference

* [Kubernetes in action ]
* [Kubernetes install on Mac](https://matthewpalmer.net/kubernetes-app-developer/articles/guide-install-kubernetes-mac.html)