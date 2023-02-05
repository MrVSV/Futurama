package com.example.futurama.di

import com.example.futurama.data.api.ApiPerson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

//    @Provides
//    @Singleton
//    fun provideAuthTokenProvider(@ApplicationContext context: Context): AuthTokenProvider =
//        AuthTokenProvider(context)
//
//    @Provides
//    @AuthTokenInterceptorQualifier
//    fun provideAuthTokenInterceptor(tokenProvider: AuthTokenProvider): Interceptor =
//        AuthTokenInterceptor(tokenProvider)
//
//    @Provides
//    @LoggingInterceptorQualifier
//    fun provideLoginInterceptor(): Interceptor =
//        HttpLoggingInterceptor()
//            .setLevel(HttpLoggingInterceptor.Level.BODY)
//
    @Provides
    @Singleton
    fun provideRedditClient(
//        @LoggingInterceptorQualifier loggingInterceptor: Interceptor,
//        @AuthTokenInterceptorQualifier authTokenInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
//        .addNetworkInterceptor(loggingInterceptor)
//        .addInterceptor(authTokenInterceptor)
        .followRedirects(true)
        .build()

    @Provides
    @Singleton
    @Named("Normal")
    fun provideRetrofit(okhttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/futurama/")
            .addConverterFactory(MoshiConverterFactory.create())
//            .client(okhttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiPerson(@Named("Normal") retrofit: Retrofit): ApiPerson =
        retrofit.create(ApiPerson::class.java)



//    @Provides
//    @Singleton
//    fun provideMoshi(): Moshi =
//        Moshi.Builder()
//            .add(KotlinJsonAdapterFactory())
//            .add(RepliesAdapter())
//            .add(
//                PolymorphicJsonAdapterFactory.of(ThingDto::class.java, "kind")
//                    .withSubtype(PostDto::class.java, "t3")
//                    .withSubtype(CommentDto::class.java, "t1")
//                    .withSubtype(More::class.java, "more")
//            )
//            .build()
//
//    @Provides
//    @Singleton
//    @Named("Converted")
//    fun provideRetrofitConverted(okhttpClient: OkHttpClient, moshi: Moshi): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://oauth.reddit.com/")
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .client(okhttpClient)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideApiToken(@Named("Normal") retrofit: Retrofit): ApiToken =
//        retrofit.create(ApiToken::class.java)
//
//    @Provides
//    @Singleton
//    fun provideApiProfile(@Named("Normal") retrofit: Retrofit): ApiProfile =
//        retrofit.create(ApiProfile::class.java)
//
//    @Provides
//    @Singleton
//    fun provideApiSubreddit(@Named("Normal") retrofit: Retrofit): ApiSubreddit =
//        retrofit.create(ApiSubreddit::class.java)
//
//    @Provides
//    @Singleton
//    fun provideApiPost(@Named("Normal") retrofit: Retrofit): ApiPost =
//        retrofit.create(ApiPost::class.java)
//
//    @Provides
//    @Singleton
//    fun provideApiSinglePost(@Named("Converted") retrofit: Retrofit): ApiSinglePost =
//        retrofit.create(ApiSinglePost::class.java)
//
//    @Provides
//    @Singleton
//    fun provideApiUser(@Named("Converted") retrofit: Retrofit): ApiUser =
//        retrofit.create(ApiUser::class.java)

}