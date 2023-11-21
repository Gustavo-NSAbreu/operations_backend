FROM maven:3.8.1-openjdk-17-slim AS build
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean package -D maven.test.skip=true


FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "app.jar"]