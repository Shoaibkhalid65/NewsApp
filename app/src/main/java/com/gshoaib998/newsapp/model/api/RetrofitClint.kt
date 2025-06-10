package com.gshoaib998.newsapp.model.api

import com.gshoaib998.newsapp.utils.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClint {
    val apiService: ApiService by lazy {

        val loggingInterceptor=HttpLoggingInterceptor().apply {
            level=HttpLoggingInterceptor.Level.BODY
        }

        val clint=OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val moshi=Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        Retrofit.Builder()
            .baseUrl(Constants.NEWS_API_BASE_URL)
            .client(clint)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiService::class.java)
    }
}