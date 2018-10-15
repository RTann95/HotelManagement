FROM anapsix/alpine-java:8

RUN apk add curl # Solely for testing the endpoints via docker exec in Kubernetes.

COPY build/libs/hotelmanagement-1.0-SNAPSHOT.jar .
COPY run.sh .

CMD ["/run.sh"]
