# 1️⃣ Build stage using official Gradle image
FROM gradle:8.2-jdk21 AS builder

WORKDIR /app

COPY . .

# Make sure gradlew is executable
RUN chmod +x gradlew

RUN ./gradlew installDist --no-daemon

# 2️⃣ Runtime stage using lightweight JDK
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=builder /app/build/install/EasyPeasyAPI ./build/install/EasyPeasyAPI

EXPOSE 8080

CMD ["./build/install/EasyPeasyAPI/bin/EasyPeasyAPI"]
