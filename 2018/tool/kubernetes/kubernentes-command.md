# Kubernetes Commands

```bash
#!/bin/bash

kubectl scale rc [image_name] --replicas=3

kubectl get pods -o wide

kubectl describe pod [pod_name]

kubectl cluster-info | grep dashboard  /minikube dashboard
```