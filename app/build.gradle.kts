plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.kotlinSerialization)
    id(BuildPlugins.navComponentSafeArgs)
    id(BuildPlugins.kotlinParcelize)
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "ru.coronavirus.testapp"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.covid19api.com/\"")

        }

        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.covid19api.com/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.dagger)
    kapt(Dependencies.daggerKapt)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.okhttp3)
    implementation(Dependencies.serializationConverter)
    implementation(Dependencies.kotlinxSerialization)

    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUiKtx)

    implementation(Dependencies.rxJava3)
    implementation(Dependencies.rxAndroid3)
    implementation(Dependencies.rxJava3RetrofitAdapter)

    implementation(Dependencies.room)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)

    implementation(Dependencies.chartsView)

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}