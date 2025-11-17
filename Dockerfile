FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copiamos archivos necesarios para descargar dependencias
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

# Copiamos todo el proyecto
COPY . .

# Construimos el proyecto
RUN ./mvnw clean package -DskipTests

# Exponemos el puerto de Spring Boot
EXPOSE 8080

# Ejecutar el JAR que aparece en tu carpeta target
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
