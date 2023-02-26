plugins {
    id(Plugins.library)
    id(Plugins.android)
    id(Plugins.kapt)
}

android {
    namespace = "com.example.core"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
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
    }
}

dependencies {

    implementation(project(":api"))

    implementation(Dependence.Core.core)
    implementation(Dependence.Core.appcompat)
    implementation(Dependence.Core.fragmentKtx)
    implementation(Dependence.Core.material)

    testImplementation(Dependence.Test.junit)
    androidTestImplementation(Dependence.AndroidTest.junit)
    androidTestImplementation(Dependence.AndroidTest.espresso)

    implementation(Dependence.Dagger2.dagger)
    kapt(Dependence.Dagger2.kapt)

    implementation(Dependence.Glide.core)
    kapt(Dependence.Glide.kapt)
}