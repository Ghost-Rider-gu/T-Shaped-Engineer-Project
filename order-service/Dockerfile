FROM java:8-jre
MAINTAINER Iurii Golubnichenko <ghostrider.gu@gmail.com>

ARG JAR_FILE
COPY ${JAR_FILE} order-service.jar
CMD ["java", "-jar", "/order-service.jar"]

EXPOSE 8994