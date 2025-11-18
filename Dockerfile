FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Dar permisos de ejecución al wrapper
RUN chmod +x mvnw

# Descargar dependencias y empaquetar
RUN ./mvnw -B -DskipTests package

# Exponer el puerto
EXPOSE 8080

# Ejecutar el JAR generado
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]
