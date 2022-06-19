FROM openjdk:11.0.7
ARG JAR_FILE=target/reto-CP-*.jar

ENV JAVA_OPTS="-Xms64m -Xmx256m"

COPY ${JAR_FILE} retp-CP.jar

ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -server -jar reto-CP.jar