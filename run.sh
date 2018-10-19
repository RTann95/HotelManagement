#!/usr/bin/env bash

set -ex

java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -jar hotelmanagement-1.0-SNAPSHOT.jar --spring.profiles.active=prod
