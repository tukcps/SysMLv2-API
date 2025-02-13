plugins {
    kotlin("jvm") version "2.1.10"
    id("maven-publish")
    id("java-library")
}

group = "com.github.tukcps"
version = "3.0.6"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:2.1.10")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("sysmlapi") {
            groupId = "com.github.tukcps"
            artifactId = "sysmlapi"

            from(components["java"])
        }
    }
    repositories {
        maven("https://cpsgit.informatik.uni-kl.de/api/v4/projects/164/packages/maven") {
            name = "GitLab"
            credentials(HttpHeaderCredentials::class) {
                name = "Deploy-Token"
                value = "ri2mY2J5Y5tqT2U4JfJR"
            }
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }
}