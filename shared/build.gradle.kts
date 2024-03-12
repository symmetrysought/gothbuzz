
//import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
//import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("multiplatform")
    //alias(libs.plugins.ksp)
    id("com.google.devtools.ksp") version "1.9.22-1.0.17"
}

kotlin {
    jvm()
    sourceSets {
        val commonMain by getting {
            kotlin.srcDir("build/generated/ksp/commonMain/kotlin")
            dependencies {
                implementation(project(":preprocessor"))
                project.dependencies.add("kspJvm", project(":preprocessor"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

dependencies {
    tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().all {
        if (name != "kspCommonMainMetadata") {
            dependsOn("kspCommonMainMetadata")
        }
    }
//    add("kspCommonMainMetadata", project(":ksp"))
//    add("kspJvm", project(":ksp"))
//    add("kspJvmTest", project(":ksp"))
//    add("kspJs", project(":ksp"))
//    add("kspJsTest", project(":ksp"))
    ksp(project(":preprocessor"))
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().all {
    if(name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
    //add("kspCommonMainKotlinMetadata", project(":ksp"))
}


//ksp {
//    arg("measureDuration", "true")
//}
