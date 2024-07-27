FROM openjdk:21-jdk-bookworm
ARG JAR_FILE=irs-ms/target/*.jar
COPY elastic-apm-agent.jar elastic-apm-agent.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]