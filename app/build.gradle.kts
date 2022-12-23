plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.example.compose_1"
        minSdk = 22
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility (JavaVersion.VERSION_1_8)
        targetCompatibility (JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
        /* Citi form
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")*/
    }
}

dependencies {
    application()
    implementation ("androidx.compose.material:material:${Versions.compose}")
    implementation ("androidx.compose.ui:ui-tooling-preview:${Versions.compose}")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation ("androidx.activity:activity-compose:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.0")
    implementation("androidx.navigation:navigation-compose:${Versions.navigation}")
    // Java language implementation
    implementation("androidx.fragment:fragment:${Versions.fragment}")
    // Kotlin
    implementation("androidx.fragment:fragment-ktx:${Versions.fragment}")
    implementation("androidx.appcompat:appcompat:${Versions.appcompat}")
    // For loading and tinting drawables on older versions of the platform
    implementation("androidx.appcompat:appcompat-resources:${Versions.appcompat}")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:${Versions.compose}")
    debugImplementation ("androidx.compose.ui:ui-tooling:${Versions.compose}")
}
