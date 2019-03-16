#!/usr/bin/env bash
# Once Docker image is switched back to alpine, change the above to sh instead of bash.

set -ex

profile=$1

java -XX:+UseStringDeduplication -jar hotelmanagement-1.0-SNAPSHOT.jar --spring.profiles.active=${profile}
