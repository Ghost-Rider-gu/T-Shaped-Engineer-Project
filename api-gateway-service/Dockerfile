FROM java:8-jre
MAINTAINER Iurii Golubnichenko <ghostrider.gu@gmail.com>

ARG JAR_FILE
COPY ${JAR_FILE} api-gateway-service.jar
CMD ["java", "-jar", "/api-gateway-service.jar"]

EXPOSE 8000