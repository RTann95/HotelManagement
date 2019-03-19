#!/usr/bin/env bash

set -ex

kubectl apply -f kube/cockroach/cockroachdb.yaml
kubectl apply -f kube/cockroach/cockroach-init.yaml
