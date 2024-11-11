package dev.tonholo.ivy

import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.bom(dependencyNotation: Any) {
    project.dependencies.platform(dependencyNotation)
}
