import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    application
}

group = "ar.coders"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

val kotestVersion: String by project
val mordantVersion: String by project
dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testRuntimeOnly("io.kotest:kotest-assertions-core:$kotestVersion")
    implementation("com.github.ajalt.mordant:mordant:$mordantVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClassName = "MainKt"
}


tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("kacman")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "ar.coders.kacman.main"))
        }
    }
}
