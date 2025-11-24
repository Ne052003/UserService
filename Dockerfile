FROM gradle:8.10.2-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle booJar --no-daemon


FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app
COPY --from=build app/build/libs/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]