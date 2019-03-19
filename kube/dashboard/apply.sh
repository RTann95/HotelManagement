#!/usr/bin/env bash

set -ex

kubectl apply -f kube/dashboard/dashboard.yaml
kubectl proxy &
kubectl create namespace hotel-management
