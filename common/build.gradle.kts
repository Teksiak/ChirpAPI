plugins {
    id("java-library")
    id("chirp.kotlin-common")
}

group = "com.teksiak.chirp"
version = "0.0.1-SNAPSHOT"

dependencies {
    api(libs.jackson.module.kotlin)
}