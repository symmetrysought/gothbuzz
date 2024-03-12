@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation("com.squareup:javapoet:1.12.1")
                implementation("com.google.devtools.ksp:symbol-processing-api:1.9.22-1.0.17")
                //implementation("com.google.devtools.ksp:symbol-processing-api")
            }
            kotlin.srcDir("src/main/kotlin")
            resources.srcDir("src/main/resources")
        }
    }
}
