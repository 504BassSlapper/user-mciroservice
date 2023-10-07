FROM openjdk:21-rc-oraclelinux8

COPY . /app
WORKDIR /app

#CMD ["java" , "-jar", "./target/${JAR_FILE}" ]
##ENTRYPOINT ["sleep", "300" ]
CMD java -jar "./target/user-microservice.jar"