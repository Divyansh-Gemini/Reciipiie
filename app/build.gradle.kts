import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.gms.google.services)
}

android {
    namespace = "dev.divyanshgemini.reciipiie"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.divyanshgemini.reciipiie"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val localProperties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            localPropertiesFile.inputStream().use { stream ->
                localProperties.load(stream)
            }
        }
        buildConfigField("String", "SPOONACULAR_API_KEY", "\"${localProperties["SPOONACULAR_API_KEY"]}\"")
        buildConfigField("String", "OAUTH_WEB_CLIENT_ID", "\"${localProperties["OAUTH_WEB_CLIENT_ID"]}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.core.splashscreen)     // SplashScreen API

    // Material Design
    implementation(libs.material)                       // Material Design 3

    // Retrofit
    implementation(libs.retrofit)                       // Retrofit
    implementation(libs.gson)                           // Gson Converter

    // Firebase
    implementation(libs.firebase.auth)                  // Firebase Auth
    implementation(libs.gms)                            // Google Gms Google Services

    // Glide
    implementation(libs.glide)                          // Glide
    annotationProcessor(libs.compiler)                  // Glide Compiler

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}