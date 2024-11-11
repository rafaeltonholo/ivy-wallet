package dev.tonholo.ivy

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

/**
 * Generates a framework name based on the full project name.
 *
 * It uses the [Project.getDisplayName] to retrive the full projects name,
 * since its parent, and a pascalcased version of the name.
 *
 * Example:
 *  - `:shared:base` -> `IvySharedBase`
 *  - `:shared:data:core` -> `IvySharedDataCore`
 *  - `:screen:home` -> `IvyScreenHome`
 *  - `:screen:edit-transaction` -> `IvyScreenEditTransaction`
 *  - `:shared:ui:design-system:core` -> `IvySharedUiDesignSystemCore`
 */
context(Framework)
val Project.appleFrameworkBaseName: String
    get() {
        // display name returns 'project {:parent:project-name}'
        val fullname = displayName
            .removePrefix("project '")
            .removeSuffix("'")
            .replace(":", "-")

        return "Ivy${fullname.pascalCase()}"
    }
