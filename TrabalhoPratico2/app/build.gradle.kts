plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"   // 🔹 Versão compatível do Compose Compiler
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildToolsVersion = "35.0.0"
}

dependencies {
    // Retrofit (Requisições HTTP)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Jetpack Compose (Corrigido para versões estáveis)
    implementation(libs.ui)
    implementation(libs.androidx.material)
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Material 3
    implementation(libs.material3)

    // Coroutines (Para operações assíncronas)
    implementation(libs.kotlinx.coroutines.android)

    // Hilt (Injeção de Dependências)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Firebase (Exemplo: Firestore)
    implementation(libs.firebase.firestore.ktx)

    // Lifecycle (Gerenciamento do ciclo de vida)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // AndroidX Core e Activity Compose
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose.v1100)

    // Testes
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom.v20250100))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}

kapt {
    correctErrorTypes = true
}
