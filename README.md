[![CircleCI](https://circleci.com/gh/RTann95/HotelManagement.svg?style=svg)](https://circleci.com/gh/RTann95/HotelManagement)

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

**Note**: I'm aware of the speed (or lack thereof). If the idea of the project were to create a small application like this,
then using a lot of this tech would just be overkill. However, the point is to use the tech; the app itself isn't as important.

**IDEA: People manage via front end and then GRPC is used to communicate with backend instead of JSON**

## Local

The following steps show how to test the server locally (on Mac) with a single Cockroach node.

1. Run `cockroach start --insecure --host=localhost` to start a local CockroachDB cluster
(or `brew services start cockroach --insecure --host=localhost` to run it in the background
(just remember to `brew services stop cockroach` when you're done)).
2. Run `./start.sh` to compile and run the server.
3. Curl the server via `curl localhost:9000/ping`.

You can see a CockroachDB Dashboard hosted [here](http://localhost:8080).

To do manual CockroachDB queries, run `cockroach sql --insecure -d hotelmanagement`.

## Local Docker

The following steps show how to test the server locally on Docker with 3 nodes of Cockroach.

**Note**: This setup assumes roach0 will always be up, as the server can only communicate with that node.
Also, keep in mind Cockroach requires the liveness of a majority (in this case 2) nodes to work properly.
So, feel free to bring nodes 1 and 2 up and down as you please, but do not kill node 0 nor kill more than
1 node at a time (of course this is just testing, so feel free to do whatever, though).

1. Run `./compile.sh` to compile the server.
2. Run `docker-compose up` to build and run the entire project.
3. Run `docker-compose down` when done (**be sure to use `docker-compose` commands because it's stupid**).
4. Curl the server via `curl localhost:9000/ping`.

You can use the same link as above to see the Cockroach Dashboard.

## Kubernetes

1. Run
`kubectl create -f https://raw.githubusercontent.com/kubernetes/dashboard/master/src/deploy/recommended/kubernetes-dashboard.yaml`
to get the Kubernetes Dashboard if this is the first time. Otherwise, skip to step 2.
2. Run `kubectl proxy` and it'll be available [here](http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/).
3. Run `kubectl create namespace hotel-management` if this is the first time. Otherwise, skip to step 4.
4. Run `kubectl create -f kube/statefulsets/cockroachdb.yaml` to start the CockroachDB stateful set.
5. Run `kubectl create -f kube/jobs/cockroach-init.yaml` to initialize the CockroachDB cluster.
6. Run `./compile.sh` to compile the server.
7. Run `docker-compose build web` to build the Docker image.
8. Run `kubectl create -f kube/deployments/web.yaml` to create the web server deployment.
9. Run `kubectl get services hotel-management-web-public -n hotel-management` to fine the assigned node port (the port on the right side of the colon).
10. Curl the server via `localhost:<node_port>`.
11. Run `kubectl port-forward cockroachdb-0 8080 -n hotel-management` to be able to see the Cockroach Dashboard via localhost.
12. Run `kubectl delete namespaces hotel-management` to cleanup everything.

**Note**: I probably could have just done port forwarding to curl the server, but then I wouldn't have learned about services,
which defeats the purpose of this.

# Next Steps

1. ~~Now that Cockroach is running on Mac, time to get it on Docker~~
2. ~~Get it to run on Kubernetes~~
3. Metrics
4. Look into other build systems (ones that make more sense than gradle but can also support spotbugs and spotless)
5. Play around with the namespaces and look into Istio
6. Proper validation
7. Unit tests
8. CI
9. Cleanup/TODOs
10. Add more stuff
11. Look into CD (maybe Spinnaker can do CD on localhost?)

# TODO

* Find a better way to be allowed to name my own columns.
* Deploy all parts of the app without so many kubectl commands.
