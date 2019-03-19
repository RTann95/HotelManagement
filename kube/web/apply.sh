#!/usr/bin/env bash

set -ex

kubectl apply -f kube/web/web.yaml
kubectl get services hotel-management-web-public -n hotel-management | sed -n 2p | awk '{print $5}' | cut -d ':' -f 2 | cut -d '/' -f 1
