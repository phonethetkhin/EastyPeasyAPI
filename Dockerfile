# 1️⃣ Build stage using official Gradle image
FROM gradle:8.2-jdk21-alpine AS builder

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Make sure gradlew is executable
RUN chmod +x gradlew

# Build the Ktor app
RUN ./gradlew installDist --no-daemon

# 2️⃣ Runtime stage using lightweight JDK
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the built app from builder
COPY --from=builder /app/build/install/EasyPeasyAPI ./build/install/EasyPeasyAPI

# Expose port used by Ktor
EXPOSE 8080

# Start the Ktor application
CMD ["./build/install/EasyPeasyAPI/bin/EasyPeasyAPI"]
