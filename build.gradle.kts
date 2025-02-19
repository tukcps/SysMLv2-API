plugins {
    kotlin("jvm") version "2.1.10"
    id("maven-publish")
    id("java-library")
    id("org.jetbrains.dokka") version "2.0.0"
//    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
    signing
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(kotlin.sourceSets.main.get().kotlin)
}

val javadocJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Javadoc JAR"
    archiveClassifier.set("javadoc")
    from(tasks.named("dokkaHtml"))
}

group = "io.github.tukcps"
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

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

publishing {
    publications {
        create<MavenPublication>("sysmlapi") {
            groupId = "io.github.tukcps"
            artifactId = "sysmlapi"
            version = project.version.toString()

            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])
            pom{
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()

                pom {
                    name.set(project.name)
                    description.set("Kotlin SysMLv2 API implementation.")
                    url.set("https://github.com/tukcps/SysMLv2-API")
                    licenses {
                        license {
                            name.set("Apache-2.0")
                            url.set("https://opensource.org/licenses/Apache-2.0")
                        }
                    }
                    developers {
                        developer {
                            id.set("grimm")
                            name.set("Christoph Grimm")
                            organization.set("University of Kaiserslautern-Landau")
                            organizationUrl.set("https://github.com/tukcps/")
                        }
                        developer {
                            id.set("herzog")
                            name.set("Moritz Herzog")
                            organization.set("University of Kaiserslautern-Landau")
                            organizationUrl.set("https://github.com/tukcps/")
                        }
                    }
                    scm {
                        url.set("https://github.com/tukcps/SysMLv2-API.git")
                        connection.set("scm:git:git://github.com/tukcps/SysMLv2-API.git")
                        developerConnection.set("scm:git:git://github.com/tukcps/SysMLv2-API.git")
                    }
                    issueManagement {
                        url.set("https://github.com/tukcps/SysMLv2-API/issues")
                    }
                }
            }
        }
    }

    repositories {
        maven("https://cpsgit.informatik.uni-kl.de/api/v4/projects/164/packages/maven") {
            name = "GitLab"
            credentials(HttpHeaderCredentials::class) {
                name = "Deploy-Token"
                value = System.getenv("DEPLOY_TOKEN")
            }
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }
}

signing {
    val signingKey = System.getenv("SIGNING_KEY")
    val signingPassphrase = System.getenv("SIGNING_PASSPHRASE")
    useInMemoryPgpKeys(signingKey, signingPassphrase)
    sign(publishing.publications["sysmlapi"])
}