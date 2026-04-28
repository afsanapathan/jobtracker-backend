FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# stay in root (IMPORTANT)
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

CMD ["sh", "-c", "java -jar target/*.jar"]