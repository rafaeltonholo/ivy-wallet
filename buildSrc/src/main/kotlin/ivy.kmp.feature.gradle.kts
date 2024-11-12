plugins {
    id("ivy.kmp")
    id("ivy.koin")
    org.jetbrains.kotlin.plugin.serialization
//    id("ivy.paparazzi")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.annotation)
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
