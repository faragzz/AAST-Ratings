package com.example.aast_ratings.APIState

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val ASTO_BASE_URL ="https://aast-ratings.vercel.app/api/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(ASTO_BASE_URL)
    .build()

interface State {

    @GET("getStats")
    fun getProperties():Deferred<StateData>
}

object stateDetails {
    val stateretrofitService : State by lazy {
        retrofit.create(State::class.java)
    }
}