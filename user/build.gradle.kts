plugins {
    id("java-library")
    id("chirp.spring-boot-service")
}

group = "com.teksiak.chirp"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(projects.common)
}