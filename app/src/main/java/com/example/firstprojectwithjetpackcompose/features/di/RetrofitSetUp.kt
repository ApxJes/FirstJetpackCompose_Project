package com.example.firstprojectwithjetpackcompose.features.di

import com.example.firstprojectwithjetpackcompose.core.Constants.BASE_URL
import com.example.firstprojectwithjetpackcompose.core.Constants.CONNECT_TIMEOUT
import com.example.firstprojectwithjetpackcompose.core.Constants.READ_TIMEOUT
import com.example.firstprojectwithjetpackcompose.core.Constants.WRITE_TIMEOUT
import com.example.firstprojectwithjetpackcompose.features.data.apiService.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitSetUp {

    @Provides
    @Singleton
    fun providesRetrofitInstance(): Retrofit {
        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }
}