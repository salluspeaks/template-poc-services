FROM openjdk:8-jdk-alpine as build
ADD . /src
WORKDIR /src
RUN ./gradlew --no-daemon clean build --info
FROM openjdk:8-jre-alpine
EXPOSE 8080
COPY --from=build /src/ms-accelerator-service/build/libs/ms-accelerator-service-*.jar /usr/local/bin/ms-accelerator-service.jar
RUN chmod +x /usr/local/bin/ms-accelerator-service.jar
ENTRYPOINT ["java", "-jar", "/usr/local/bin/ms-accelerator-service.jar"]