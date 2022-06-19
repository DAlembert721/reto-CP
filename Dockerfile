FROM openjdk:11.0.7
ARG JAR_FILE=target/retoCP*.jar

COPY ${JAR_FILE} retoCP.jar

CMD [ "sh", "-c", "java -Dserver.port=$PORT -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar /retoCP.jar" ]