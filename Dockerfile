FROM openjdk:11-jdk-slim
COPY . /app
WORKDIR /app
RUN chmod +x mvnw
RUN ./mvnw clean package
EXPOSE 8080
CMD ["java", "-jar", "target/valposystem.jar"]