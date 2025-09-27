# Use Java 21 JDK
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy all project files
COPY . .

# Build the app
RUN ./gradlew installDist

# Set entrypoint to the Ktor executable
CMD ["./build/install/EasyPeasyAPI/bin/EasyPeasyAPI"]
