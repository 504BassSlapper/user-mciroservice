FROM openjdk:21-rc-oraclelinux8
ENV APP_NAME java21
ENV VERSION 0.0.1-SNAPSHOT
ENV JAR_FILE="${APP_NAME}-${VERSION}.jar"
RUN echo $JAR_FILE
COPY . /app
WORKDIR /app

EXPOSE 8080
#CMD ["java" , "-jar", "./target/${JAR_FILE}" ]
##ENTRYPOINT ["sleep", "300" ]
CMD java -jar "./target/user-microservice.jar"