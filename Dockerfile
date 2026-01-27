FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Duser.timezone=Asia/Kolkata","-jar","app.jar"]
