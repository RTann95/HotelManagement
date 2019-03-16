# Note: This is temporary until there is a stable Alpine image for Java 11.
FROM openjdk:11.0.2-jre-slim

COPY build/libs/hotelmanagement-1.0-SNAPSHOT.jar .
COPY run.sh .

# HTTP endpoints.
EXPOSE 9000
# Metrics endpoints.
EXPOSE 9001

# Default command used for development.
CMD exec /run.sh dev-docker
