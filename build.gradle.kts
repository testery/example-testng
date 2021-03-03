plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
    id("io.testery") version "1.1"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:3.141.59")
    testImplementation("org.testng:testng:7.1.0")
}

testery {
    apiKey = System.getenv("TESTERY_API_KEY")
    projectKey = "example-testng"
    buildId = System.getenv("GITHUB_RUN_NUMBER")
    branch = System.getenv("GITHUB_REF")?.substringAfter("heads/")
    commitHash = System.getenv("GITHUB_SHA")
    environmentKey = System.getenv("TESTERY_ENVIRONMENT_KEY")
}
