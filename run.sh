#!/usr/bin/env sh

set -ex

profile=$1

java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -jar hotelmanagement-1.0-SNAPSHOT.jar --spring.profiles.active=${profile}
