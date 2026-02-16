plugins {
    id("java-library")
    id("chirp.spring-boot-service")
}

group = "com.teksiak.chirp"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(projects.common)

    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.validation)

    runtimeOnly(libs.postgresql)
}