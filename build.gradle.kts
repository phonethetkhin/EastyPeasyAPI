plugins {
    kotlin("jvm") version "2.0.21" // latest stable Kotlin
    kotlin("plugin.serialization") version "2.0.21" // match Kotlin version
    id("io.ktor.plugin") version "3.0.0"

}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
}
val ktor_version = "3.0.0"
dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-cors:$ktor_version") // ✅ add this

    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("ch.qos.logback:logback-classic:1.5.13")

    implementation("io.ktor:ktor-server-swagger:${ktor_version}")


    testImplementation(kotlin("test"))
}
