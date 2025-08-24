FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app
COPY . .

# Windows からコピーした場合の改行対応
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix gradlew

RUN chmod +x gradlew
RUN ./gradlew build -x test

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]