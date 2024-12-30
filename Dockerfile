FROM openjdk:21-jdk-slim

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw && ./mvnw clean install -DskipTests

ENTRYPOINT ["java", "-jar", "target/foods-app-0.0.1-SNAPSHOT.jar"]
