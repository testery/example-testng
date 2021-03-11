plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
    id("io.testery") version "1.3"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:3.141.59")
    testImplementation("org.testng:testng:7.1.0")
}

testery {
    apiToken = System.getenv("TESTERY_API_TOKEN")
    projectKey = "example-testng"
    buildId = System.getenv("GITHUB_RUN_NUMBER")
    branch = System.getenv("GITHUB_REF")?.substringAfter("heads/")
    commitHash = System.getenv("GITHUB_SHA")
    environmentKey = System.getenv("TESTERY_ENVIRONMENT_KEY")
}

val test by tasks.getting(Test::class) {
    useTestNG()
}