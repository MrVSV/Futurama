object Dependence {

    private object Versions {
        const val core = "1.9.0"
        const val appcompat = "1.6.1"
        const val material = "1.8.0"
        const val constraint = "2.1.4"
        const val dagger = "2.45"
        const val navigation = "2.5.3"
        const val room = "2.5.0"
        const val glide = "4.14.2"
        const val retrofit = "2.9.0"
        const val moshi = "1.14.0"
        const val lifecycle = "2.5.1"
    }

    object Core {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.5"
    }

    object Dagger2 {
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val kapt = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
    }

    object AndroidTest {
        const val junit = "androidx.test.ext:junit:1.1.5"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
    }

    object Navigation {
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Recycler {
        const val recycler = "androidx.recyclerview:recyclerview:1.2.1"
        const val recyclerSelection = "androidx.recyclerview:recyclerview-selection:1.1.0"
        const val paging = "androidx.paging:paging-runtime:3.1.1"
        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
    }
    object LoggingInterceptor {
        const val log = "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
        const val paging = "androidx.room:room-paging:${Versions.room}"
        const val kapt = "androidx.room:room-compiler:${Versions.room}"
    }

    object Glide {
        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val kapt = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Retrofit {
        const val converterScalars = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object Moshi {
        const val core = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
        const val adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
        const val kapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    }

    object Lifecycle {
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }
}