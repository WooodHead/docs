# Kubernetes Commands




## Kubernetes Issue

* github.com/containous/traefik/vender/k8s.io/client-go/informers/factory.go:86 vatchof *v1.Endpoints ended with: too old resource version: 8762782 {8762875}

```bash
#!/bin/bash
  kubectl cluster-info
  kubectl --server=https://53.126.101.106:6443 version

  Client Version: version.Info{Major:"1", Mirror:"7", GitVersion:"v1.7.7",GitCommit:"$Format:%H$",GitTreeState:"not a git tree","BuildDate":"2017-11-03T09:30:19Z", GovVersion:"go1.8.5",Compiler:"gc",Platform:"linux/amd64"}
  Server Version: version.Info(Major:"1", Mirror:"9+", GitVersion:"v1.9.11-dhc",GitCommit:"1bfeeb5f212146a22dc787b73e109-e5bccef13d,GitTreeState",GitTreeState"dirty",BuildDate:"2018-10-02T05:55:34Z",GoVersion:"go1.9.3",Complier:"gc",Platform:"linux/amd64")

# print pod env value

kubectl exec -it po <poname> -n=<namespace>
printenv
```