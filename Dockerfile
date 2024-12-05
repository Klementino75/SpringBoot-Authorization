FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY target/SpringBoot-Authorization-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "myapp.jar"]