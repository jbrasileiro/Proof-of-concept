FROM openjdk:8-jdk
VOLUME /tmp
ADD ./*.jar application.jar
CMD java $JAVA_OPTS -jar /application.jar
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n","-jar","/application.jar"]