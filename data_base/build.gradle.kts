plugins {
    id(Plugins.library)
    id(Plugins.android)
    id(Plugins.kapt)
}

android {
    namespace = "com.example.data_base"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
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
}

dependencies {

    implementation(Dependence.Core.core)
    implementation(Dependence.Core.appcompat)

    implementation(Dependence.Room.runtime)
    implementation(Dependence.Room.ktx)
    implementation(Dependence.Room.paging)
    kapt(Dependence.Room.kapt)
}