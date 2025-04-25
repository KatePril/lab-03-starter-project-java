FROM maven:3.9-amazoncorretto-21-alpine

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM openjdk:21-slim

WORKDIR /app

COPY --from=0 /app/target/lab3-0.0.1-SNAPSHOT.jar /app/lab3-0.0.1-SNAPSHOT.jar

COPY --from=0 /app/wait-for-it.sh /app/
RUN chmod +x /app/wait-for-it.sh

EXPOSE 8080

ENTRYPOINT ["/app/wait-for-it.sh", "postgres:5432", "--", "java", "-jar", "/app/lab3-0.0.1-SNAPSHOT.jar"]
