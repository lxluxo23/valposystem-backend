FROM openjdk:11-jdk-slim
COPY target/valposystem.jar /app/valposystem.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "valposystem.jar"]