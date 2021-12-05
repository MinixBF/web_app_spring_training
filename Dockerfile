# (1)
FROM maven:3.8.3-openjdk-17 AS build
COPY src /src
COPY pom.xml /pom.xml
# (2)
RUN mvn -f /pom.xml clean package

# (3)
FROM eclipse-temurin:17-jdk-focal
# (4)
COPY --from=build /target/web_app_spring_training-1.0.0-SNAPSHOT.jar /usr/local/lib/app.jar
# (5)
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]