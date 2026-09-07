plugins {
    alias(libs.plugins.application)
}

android {
    compileSdk =
        libs.versions.compile.sdk.version
            .get()
            .toInt()
    namespace = "com.github.appintro.example"

    defaultConfig {
        minSdk =
            libs.versions.min.sdk.version
                .get()
                .toInt()
        targetSdk =
            libs.versions.target.sdk.version
                .get()
                .toInt()

        vectorDrawables.useSupportLibrary = true
        applicationId = "com.github.appintro.example"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
    lint {
        disable.addAll(
            listOf(
                "MissingTranslation",
                "OldTargetApi",
                "GradleDependency",
                // See appintro/build.gradle.kts: version-drift check, fails once a newer AGP ships.
                "AndroidGradlePluginVersion",
            ),
        )
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        compilerOptions {
            jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
        }
    }
}

dependencies {
    implementation(project(":appintro"))
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.core.ktx)
}
