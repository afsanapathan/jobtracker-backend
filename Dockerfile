FROM eclipse-temurin:17-jdk

WORKDIR /app

# copy everything
COPY . .

# move into correct folder
WORKDIR /app/jobtracker

# build project
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# run jar
CMD ["sh", "-c", "java -jar target/*.jar"]