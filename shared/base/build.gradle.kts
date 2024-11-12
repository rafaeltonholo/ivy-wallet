import dev.tonholo.ivy.kspAndroid

plugins {
    id("ivy.kmp.feature")
    dagger.hilt.android.plugin
    com.google.devtools.ksp
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.hilt.core)
        }
        androidMain.dependencies {
            implementation(libs.bundles.hilt)
        }
    }

    sourceSets.androidMain.configure {
        kotlin.srcDir("build/generated/ksp/$name/kotlin")
    }
}

android {
    namespace = "dev.tonholo.ivy.base"
}

dependencies {
    kspAndroid(libs.hilt.compiler)
}
