FROM openjdk:11
COPY target/*.jar gateway.jar
CMD java -jar gateway.jar
