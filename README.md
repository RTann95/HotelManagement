# Hotel Management

## About

I got bored, so I am using technology. The idea is to do something simple with cool tech.

This project is to be a mono-repo application, and this repo will contain all parts (frontend, backend, etc), which
will be deployed locally via docker-compose and deployed to "production" (docker-for-mac Kuberneters node) via
Kubernetes.

I don't care much for frontend, so I'm focused on backend, which is a Springboot application.

I want to also utilize CockroachDB for data storage and have each separate container communicate via some service mesh
(probably Istio because Envoy sidecars are dope).

At the moment, the repo is clearly designed for just the Springboot application, but I will eventually separate each
part into separate top-level folders (frontend/, server/, etc).

## Local (designed for just the server at the moment)

1. Run `cockroach start --insecure --host=localhost` to start a local CockroachDB cluster
(or `brew services start cockroach --insecure --host=localhost` to run it in the background
(just remember to `brew services stop cockroach` when you're done)).
2. Create the Database via `cockroach sql --insecure` then `> CREATE DATABASE hotelmanagement;`
3. Run `./start.sh` to compile and run the server.

You can see a CockroachDB Dashboard hosted [here](http://localhost:8080).

To do manual CockroachDB queries, run `cockroach sql --insecure -d hotelmanagement`.

## Local Docker

1. Run `docker-compose up` to build and run the entire project.

## Kubernetes

### Dashboard

1. (If this is the first time) run
`kubectl create -f https://raw.githubusercontent.com/kubernetes/dashboard/master/src/deploy/recommended/kubernetes-dashboard.yaml`
to get the Dashboard

2. Run `kubectl proxy` and it'll be available [here](http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/).

# Next Steps

1. Now that Cockroach is running on Mac, time to get it on Docker
2. Get it to run on Kubernetes
3. Proper validation
4. Metrics
5. Unit tests
6. CI
7. Look into other build systems (ones that make more sense than gradle but can also support spotbugs and spotless)
7. Cleanup/TODOs
8. Add more stuff
9. Look into CD (maybe Spinnaker can do CD on localhost?)

# TODO

1. Figure out how to set up the database automatically on startup
2. Find a better way to be allowed to name my own columns.
