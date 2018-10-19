#!/usr/bin/env bash

./compile.sh && ./gradlew bootRun -Dspring.profiles.active=dev
