val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

application {
    mainClassName = "com.seven.ApplicationKt"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-gson:$ktor_version")
    implementation("io.ktor:ktor-client-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-cio-jvm:$ktor_version")

    testImplementation("io.ktor:ktor-client-mock:$ktor_version")
    testImplementation("io.ktor:ktor-client-mock-jvm:$ktor_version")
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-common"))
    testImplementation(kotlin("test-testng"))
}

group = "com.seven"

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

plugins {
    application
    `java-library`
    kotlin("jvm") version "1.4.21"
    `maven-publish`
}

publishing {
/*    publications {
        create<MavenPublication>("SevenClient") {
            artifactId = "seven-client"
            from(components["java"])
            groupId = "$group"
            version = version
        }
    }

    repositories {
        mavenLocal() {
            name = "SevenClient"
            url = uri("file://${buildDir}/repo")
        }
       // maven {}
    }*/
}

repositories {
    //mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    maven { url = uri("https://kotlin.bintray.com/kotlinx") }
}

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

version = "0.0.2"