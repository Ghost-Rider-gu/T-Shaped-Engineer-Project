FROM java:8-jre
MAINTAINER Iurii Golubnichenko <ghostrider.gu@gmail.com>

ARG JAR_FILE
COPY ${JAR_FILE} processing-service.jar
CMD ["java", "-jar", "/processing-service.jar"]

EXPOSE 8999