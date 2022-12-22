FROM openjdk:18-alpine

EXPOSE 5500

COPY target/transfer-money-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "/app.jar"]