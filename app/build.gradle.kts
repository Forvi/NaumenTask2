plugins {
    application
}

repositories {
    mavenCentral()
}

object Versions {
    const val jackson = "2.18.6"

    const val jacksonCore = "com.fasterxml.jackson.core:jackson-core:$jackson"
    const val jacksonDatabind = "com.fasterxml.jackson.core:jackson-databind:$jackson"
    const val jacksonAnnotations = "com.fasterxml.jackson.core:jackson-annotations:$jackson"
}

configurations.all {
    exclude(group = "com.fasterxml.jackson", module = "jackson-bom")
}

dependencies {
    testImplementation(libs.junit)
    implementation(libs.guava)

    implementation(Versions.jacksonDatabind)
    implementation(Versions.jacksonCore)
    implementation(Versions.jacksonAnnotations)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "org.example.App"
        )
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

application {
    mainClass = "org.example.App"
}
