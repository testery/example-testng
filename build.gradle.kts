import org.gradle.api.Project

buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("com.github.jengelman.gradle.plugins:shadow:6.1.0")
        classpath("com.squareup.okhttp3:okhttp:4.2.1")
        classpath(files("libs/gradle-plugin-0.1.jar"))
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
}

group "org.example"
version "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:3.141.59")
    testImplementation("org.testng:testng:7.1.0")
}

apply<io.testery.TesteryPlugin>()

fun Project.testery(block: io.testery.TesteryPluginExtension.() -> Unit) =
    block.invoke(extensions.getByName("testery") as io.testery.TesteryPluginExtension)

testery {
    apiKey = System.getenv("TESTERY_API_KEY")
    projectKey = "example-testng"
    buildId = System.getenv("GITHUB_RUN_NUMBER")
    branch = System.getenv("GITHUB_REF")?.substringAfter("heads/")
    commitHash = System.getenv("GITHUB_SHA")
    environmentKey = System.getenv("TESTERY_ENVIRONMENT_KEY")
}
