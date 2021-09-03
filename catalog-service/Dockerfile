FROM java:8-jre
MAINTAINER Iurii Golubnichenko <ghostrider.gu@gmail.com>

ARG JAR_FILE
COPY ${JAR_FILE} catalog-service.jar
CMD ["java", "-jar", "/catalog-service.jar"]

EXPOSE 8993