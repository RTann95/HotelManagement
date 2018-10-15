#!/usr/bin/env bash

./compile.sh && docker build -t hotelmanagement_web:latest .
