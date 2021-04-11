FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} soccer-api.jar
ENTRYPOINT ["java","-jar","/soccer-api.jar"]
EXPOSE 8080