import dev.tonholo.ivy.appleFrameworkBaseName
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    org.jetbrains.kotlin.multiplatform
    org.jetbrains.kotlin.plugin.compose
    org.jetbrains.compose
    com.android.library
}

val javaVersion = catalog.version("jvm-target")
kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(javaVersion))
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = appleFrameworkBaseName
        }
    }

    jvmToolchain(javaVersion.toInt())

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
        }
        androidMain.dependencies {
            implementation(libs.bundles.arrow)
            implementation(libs.bundles.kotlin)
            implementation(catalog.bundle("kotlin-android"))
            implementation(libs.timber)
        }
        androidUnitTest.dependencies {
            implementation(libs.bundles.testing)
        }
    }
}

compose.resources {
    packageOfResClass = "dev.tonholo.ivy.${project.name}.resources"
    generateResClass = auto
}

android {
    compileSdk = catalog.version("compile-sdk").toInt()
    defaultConfig {
        minSdk = catalog.version("min-sdk").toInt()
    }
}

gradle.projectsEvaluated {
    // Increase tests Heap Size because of Kotest property-based tests
    tasks.withType<Test> {
        maxHeapSize = "2048m"
    }
}
