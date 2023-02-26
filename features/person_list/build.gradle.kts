plugins {
    id(Plugins.library)
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
    implementation(project(":core"))

    implementation(Dependence.Core.core)
    implementation(Dependence.Core.appcompat)
    implementation(Dependence.Core.material)
    implementation(Dependence.Core.constraint)
    implementation(Dependence.Core.fragmentKtx)

    implementation(Dependence.Lifecycle.runtime)
    implementation(Dependence.Lifecycle.viewModel)
    implementation(Dependence.Lifecycle.liveData)

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
}