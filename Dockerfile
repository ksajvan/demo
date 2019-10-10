FROM alpine
RUN apk add --no-cache openjdk8
COPY target/demo-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch demo-0.0.1-SNAPSHOT.jar'

EXPOSE 8081

ENTRYPOINT [ "java","-jar","demo-0.0.1-SNAPSHOT.jar" ]