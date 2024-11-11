import dev.tonholo.ivy.bom
import dev.tonholo.ivy.kspAndroid
import dev.tonholo.ivy.kspIosArm64
import dev.tonholo.ivy.kspIosSimulatorArm64
import dev.tonholo.ivy.kspIosX64
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    org.jetbrains.kotlin.multiplatform
    com.google.devtools.ksp
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(bom(libs.io.insertkoin.koin.bom))
            implementation(libs.io.insertkoin.koin.core)
            implementation(bom(libs.io.insertkoin.koin.annotations.bom))
            api(libs.io.insertkoin.koin.annotations)
        }
        androidMain.dependencies {
            implementation(libs.io.insertkoin.koin.android)
        }
    }

    sourceSets.commonMain.configure {
        kotlin.srcDir("build/generated/ksp/commonMain/kotlin")
    }
}

dependencies {
    kspCommonMainMetadata(libs.io.insertkoin.koin.ksp.compiler)
    kspAndroid(libs.io.insertkoin.koin.ksp.compiler)
    kspIosX64(libs.io.insertkoin.koin.ksp.compiler)
    kspIosArm64(libs.io.insertkoin.koin.ksp.compiler)
    kspIosSimulatorArm64(libs.io.insertkoin.koin.ksp.compiler)
}

ksp {
    arg("KOIN_CONFIG_CHECK", "true")
    arg("KOIN_USE_COMPOSE_VIEWMODEL", "true")
}

project.tasks.withType(KotlinCompilationTask::class.java).configureEach {
    if (name != "kspCommonMainMetadata") {
        dependsOn("kspCommonMainMetadata")
    }
}
