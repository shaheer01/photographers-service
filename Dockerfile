FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} photographers-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/photographers-service-1.0-SNAPSHOT.jar"]COPY
