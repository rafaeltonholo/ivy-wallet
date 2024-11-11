package dev.tonholo.ivy

import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.kspAndroid(dependencyNotation: Any) {
    add("kspAndroid", dependencyNotation)
}

fun DependencyHandlerScope.kspIosX64(dependencyNotation: Any) {
    add("kspIosX64", dependencyNotation)
}

fun DependencyHandlerScope.kspIosArm64(dependencyNotation: Any) {
    add("kspIosArm64", dependencyNotation)
}

fun DependencyHandlerScope.kspIosSimulatorArm64(dependencyNotation: Any) {
    add("kspIosSimulatorArm64", dependencyNotation)
}
