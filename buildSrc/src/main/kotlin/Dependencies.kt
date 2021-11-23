object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val daggerHiltAndroid = "dagger.hilt.android.plugin"
    const val kotlinSerialization = "kotlinx-serialization"
    const val kotlinParcelize = "kotlin-parcelize"
    const val navComponentSafeArgs = "androidx.navigation.safeargs.kotlin"
}

object ClasspathDependecies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.3"
    const val koltinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:1.5.31"
    const val navComponentSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5"
}

object Dependencies {
    private object Versions {
        const val room = "2.3.0"
        const val navigation = "2.3.5"
        const val glide = "4.12.0"
        const val dagger = "2.39"
    }

    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.6"
    const val coreKtx = "androidx.core:core-ktx:1.7.0"
    const val appCompat = "androidx.appcompat:appcompat:1.3.1"
    const val material = "com.google.android.material:material:1.4.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.1"
    const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerKapt = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:4.9.0"
    const val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    const val kotlinxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1"
}
