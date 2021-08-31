FROM java:8
MAINTAINER Iurii Golubnichenko <ghostrider.gu@gmail.com>
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]