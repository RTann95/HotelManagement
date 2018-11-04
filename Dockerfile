FROM openjdk:8-alpine

COPY build/libs/hotelmanagement-1.0-SNAPSHOT.jar .
COPY run.sh .

# HTTP endpoints.
EXPOSE 9000
# Metrics endpoints.
EXPOSE 9001

# Default command used for development.
CMD exec /run.sh dev-docker
