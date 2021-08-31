FROM java:8-jre
MAINTAINER Iurii Golubnichenko <ghostrider.gu@gmail.com>

ARG JAR_FILE
COPY ${JAR_FILE} registry-service.jar
CMD ["java", "-jar", "/registry-service.jar"]

EXPOSE 8990