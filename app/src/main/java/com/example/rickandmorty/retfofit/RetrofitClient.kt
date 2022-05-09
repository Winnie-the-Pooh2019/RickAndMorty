package com.example.rickandmorty.retfofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private lateinit var client: Retrofit

    fun getClient(url: String, interceptor: Interceptor): Retrofit {
        if (!this::client.isInitialized) {
            client = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient
                    .Builder()
                    .addInterceptor(interceptor)
                    .build())
                .build()
        }

        return client
    }
}