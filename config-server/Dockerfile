FROM java:8-jre
MAINTAINER Iurii Golubnichenko <ghostrider.gu@gmail.com>

ARG JAR_FILE
COPY ${JAR_FILE} config-server.jar
CMD ["java", "-jar", "/config-server.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:9099/actuator/health || exit 1

EXPOSE 9099