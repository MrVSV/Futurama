plugins {
    id(Plugins.application)
    id(Plugins.android)
    id(Plugins.kapt)
    id(Plugins.safeargs)
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
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
    implementation(project(":data_base"))
    implementation(project(":features:person_list"))
    implementation(project(":core"))

    implementation(Dependence.Core.core)
    implementation(Dependence.Core.appcompat)
    implementation(Dependence.Core.material)
    implementation(Dependence.Core.constraint)
    implementation(Dependence.Core.fragmentKtx)

    testImplementation(Dependence.Test.junit)
    androidTestImplementation(Dependence.AndroidTest.junit)
    androidTestImplementation(Dependence.AndroidTest.espresso)

    implementation(Dependence.Navigation.fragmentKtx)
    implementation(Dependence.Navigation.uiKtx)

    implementation(Dependence.Recycler.recycler)
    implementation(Dependence.Recycler.recyclerSelection)
    implementation(Dependence.Recycler.paging)
    implementation(Dependence.Recycler.swipeRefresh)

    implementation(Dependence.LoggingInterceptor.log)

    implementation(Dependence.Room.runtime)
    implementation(Dependence.Room.ktx)
    implementation(Dependence.Room.paging)
    kapt(Dependence.Room.kapt)

    implementation(Dependence.Dagger2.dagger)
    kapt(Dependence.Dagger2.kapt)

    implementation(Dependence.Glide.core)
    kapt(Dependence.Glide.kapt)

    implementation(Dependence.Retrofit.core)
    implementation(Dependence.Retrofit.converterScalars)
    implementation(Dependence.Retrofit.converterMoshi)

    implementation(Dependence.Moshi.core)
    implementation(Dependence.Moshi.kotlin)
    implementation(Dependence.Moshi.adapters)
    kapt(Dependence.Moshi.kapt)
}