FROM openjdk:8

WORKDIR /build

COPY ./ct-rest/target/ns-rest.jar ./ns-rest.jar

#ENTRYPOINT ["java", "-jar", "/build/ns-rest.jar"]