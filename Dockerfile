FROM openjdk:8
COPY ./target/test-bcp-1.0.0-SNAPSHOT.jar /tmp/test-bcp.jar
WORKDIR /tmp
EXPOSE 8080
CMD ["java", "-jar", "test-bcp.jar"]