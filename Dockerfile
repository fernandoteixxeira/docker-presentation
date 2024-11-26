FROM maven:3.9.9-eclipse-temurin-17 as builder

COPY . /app/
WORKDIR /app/

RUN mvn clean install

FROM openjdk:17-slim as release

WORKDIR /

EXPOSE 8080

ARG APP_NAME
ENV APP_NAME $APP_NAME

RUN echo "Application: $APP_NAME"
LABEL applicaion=$APP_NAME

HEALTHCHECK --interval=30s --timeout=5s --retries=3 CMD curl -f http://localhost:8080/actuator/health || exit 1

COPY --from=builder /app/target/*.jar /app.jar

CMD java -jar /app.jar