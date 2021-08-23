package com.example.android.marsphotos.network

import com.example.android.marsphotos.models.MarsPhotos
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface MarsApiService {
    companion object {
        /**
         * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
         */
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        private const val BASE_URL =
            "https://android-kotlin-fun-mars-server.appspot.com"
        val retrofit: Retrofit =
            Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL).build()
    }

    @GET("photos")
    suspend fun getPhotos(): List<MarsPhotos>

    object MarsApi {
        val retrofitService: MarsApiService by lazy {
            retrofit.create(MarsApiService::class.java)
        }
    }
}

