FROM java:8-jre
MAINTAINER Iurii Golubnichenko <ghostrider.gu@gmail.com>

ARG JAR_FILE
COPY ${JAR_FILE} monitoring-service.jar
CMD ["java", "-jar", "/monitoring-service.jar"]

EXPOSE 8080