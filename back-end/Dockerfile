FROM maven:3.6.0-jdk-8-alpine as build

RUN mkdir -p /build
WORKDIR /build

COPY ./ ./

RUN mvn clean package -DskipTests=true

FROM openjdk:8

WORKDIR /build

COPY --from=build /build/ns-rest/target/ns-rest.jar ./ns-rest.jar

# This line should be commented when debuging
ENTRYPOINT ["java", "-jar", "/build/ns-rest.jar"]