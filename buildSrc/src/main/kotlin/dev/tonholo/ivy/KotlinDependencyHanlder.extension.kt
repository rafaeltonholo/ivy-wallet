package dev.tonholo.ivy

import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.bom(
    dependencyNotation: Provider<MinimalExternalModuleDependency>,
): Provider<MinimalExternalModuleDependency> =
    project.dependencies.platform(dependencyNotation)
