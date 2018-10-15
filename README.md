# Hotel Management

## About

I got bored, so I am using technology. The idea is to do something simple with cool tech.

This project is to be a monorepo application, and this repo will contain all parts (frontend, backend, etc), which
will be deployed locally via docker-compose and deployed to "production" (docker-for-mac Kuberneters node) via
Kubernetes.

I don't care much for frontend, so I'm focused on backend, which is a Springboot application.

I want to also utilize CockroachDB for data storage and have each separate container communicate via some service mesh
(probably Istio because Envoy sidecars are dope).

At the moment, the repo is clearly designed for just the Springboot application, but I will eventually separate each
part into separate top-level folders (frontend/, server/, etc)

## Kubernetes

### Running the Dashboard

`kubectl proxy` and it's available at http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/
