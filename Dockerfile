# Optimized Dockerfile setup
# *****************************************

# base build image
FROM maven:3.6.2-jdk-8-slim as maven

WORKDIR /app

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy other files
COPY ./src ./src

# build for release
RUN mvn package && cp target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

# final base image
FROM openjdk:8u171-jre-alpine

# set deployment directory
WORKDIR /app

# copy over the built artifact from the maven image
COPY --from=maven /app/demo-0.0.1-SNAPSHOT.jar ./demo-0.0.1-SNAPSHOT.jar

# set the startup command to run the binary
CMD ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]
