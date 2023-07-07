FROM openjdk:17-alpine

WORKDIR /app

COPY build/libs/desafio-0.0.1-SNAPSHOT.jar /app/desafio.jar

ENV POSTGRES_HOST=localhost RABBIT_HOST=rabbitmq

CMD ["java", "-jar", "desafio.jar"]