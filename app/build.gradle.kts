plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.gshoaib998.newsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.gshoaib998.newsapp"
        minSdk = 25
        targetSdk = 34
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
        }
    }
    buildFeatures{
        dataBinding=true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.animation)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Room components
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)

//  - Kotlin Extensions and Coroutines support
    implementation(libs.androidx.room.ktx)

// - Paging support
    implementation(libs.androidx.room.paging)

    // Retrofit core
    implementation(libs.retrofit.v300)

// Converter for JSON (using Moshi )
    implementation(libs.converter.moshi.v300)

    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)

//  - Coroutine call adapter
    implementation(libs.retrofit2.kotlin.coroutines.adapter)

    // Core FastAdapter library
    implementation(libs.fastadapter)

// Extensions (Optional based on your use case)
    implementation(libs.fastadapter.extensions.binding)  // For Data Binding
    implementation(libs.fastadapter.extensions.diff)     // DiffUtil support
    implementation(libs.fastadapter.extensions.utils)    // Click listeners etc.
// coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
// live data and viewmodel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.androidx.lifecycle.livedata.ktx)
//    coil library for image loading
    implementation(libs.coil)
// logging interceptor
    implementation(libs.logging.interceptor)











}