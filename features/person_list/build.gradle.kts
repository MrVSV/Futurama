plugins {
    id(Plugins.application)
    id(Plugins.android)
    id(Plugins.kapt)
}

android {
    namespace = "com.example.person_list"
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

    implementation(project(":api"))
    implementation(project(":data_base"))
    implementation(project(":core"))

    implementation(Dependence.Core.core)
    implementation(Dependence.Core.appcompat)
    implementation(Dependence.Core.material)
    implementation(Dependence.Core.constraint)
    implementation(Dependence.Core.fragmentKtx)

    implementation(Dependence.Dagger2.dagger)
    kapt(Dependence.Dagger2.kapt)


}