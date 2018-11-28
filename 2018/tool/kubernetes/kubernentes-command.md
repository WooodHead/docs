# Kubernetes Commands

```bash
#!/bin/bash

kubectl scale rc [image_name] --replicas=3
kubectl get pods -o wide
kubectl describe [pod|node] [pod_name|node_name]
kubectl cluster-info | grep dashboard  /minikube dashboard
kubectl run kubia --image=luksa/kubia --port=8080 --generator=run/v1
kubectl get [services | svc]
kubectl get [replicationcontrollers | rc]
kubectl expose rc kubia --type=LoadBalancer --name kubia-http
kubectl get po kubia-zxzij -o yaml
kubectl explain pods
kubectl explain pod.spec
kubectl create -f kubia-manual.yaml
kubectl get po <pod_name> -o json
kubectl logs <pod_name>
kubectl logs <pod_name> -c <container_name>
kubectl port-forward kubia-manual 8888:8080
kubectl get pods --all-namespaces
kubectl get svc inbound-intranet -n=local
```