# Usamos Java 21 (Temurin)
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiamos todo el proyecto
COPY . .

# Damos permisos al wrapper de Maven
RUN chmod +x mvnw

# Compilamos sin tests para que sea más rápido
RUN ./mvnw -q -e -DskipTests package

# Exponemos el puerto 8080 que Spring Boot usa
EXPOSE 8080

# Ejecutamos el jar REAL de tu proyecto
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
