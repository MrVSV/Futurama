package com.example.futurama.di



import com.example.api.api.ApiPerson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideRedditClient(
    ): OkHttpClient = OkHttpClient.Builder()
        .followRedirects(true)
        .build()

    @Provides
    @Singleton
    @Named("Normal")
    fun provideRetrofit(okhttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/futurama/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiPerson(@Named("Normal") retrofit: Retrofit): ApiPerson =
        retrofit.create(ApiPerson::class.java)
}