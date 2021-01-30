package com.demi.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {
    val defaultBaseUrl = "https://www.wanandroid.com/"
    fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            //失败重连
            .retryOnConnectionFailure(true)
            .build()
    }

    fun createRetrofit(baseUrl: String,factory:Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(createOkHttpClient())
            .addConverterFactory(factory)
//                .addCallAdapterFactory()
            .build()
    }

    fun <T> getService(service: Class<T>, baseUrl: String = defaultBaseUrl,factory:Converter.Factory= GsonConverterFactory.create()): T {
        return createRetrofit(baseUrl,factory).create(service)
    }
}