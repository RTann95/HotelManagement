FROM anapsix/alpine-java:8

COPY build/libs/hotelmanagement-1.0-SNAPSHOT.jar .
COPY run.sh .

# Default command used for development.
CMD exec /run.sh dev-docker
