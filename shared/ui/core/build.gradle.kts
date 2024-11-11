plugins {
    id("ivy.feature")
}

android {
    namespace = "com.ivy.ui"
}

dependencies {
    implementation(projects.shared.base)
    implementation(projects.shared.domain)
    implementation(projects.shared.ui.designSystem.core)
}
