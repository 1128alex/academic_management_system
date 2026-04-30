# Stage 1: Build
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY gradlew gradlew.bat ./
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./
COPY src/ src/
RUN sed -i 's/\r$//' gradlew && chmod +x gradlew && ./gradlew build -x test --no-daemon

# Stage 2: Run
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/UnivWeb-0.0.1-SNAPSHOT.war app.war
COPY ./src/main/resources/static/db_query/ /app/sql/
RUN mkdir -p /app/images
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.war", "--spring.profiles.active=docker"]
