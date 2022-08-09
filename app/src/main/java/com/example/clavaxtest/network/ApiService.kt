package com.example.clavaxtest.network

import com.example.clavaxtest.model.Zipcode
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("zipcodes/")
    fun getZipcode(
        @Header("token") token: String = "100f8bcd4626d373cade4e832633b5f7",
        @Header("source") source: String = "ANDROID"
    ): Call<Zipcode>


    companion object {
        var apiService : ApiService? = null

        fun getInstance(): ApiService{
            if(apiService==null){
                val retrofit = Retrofit.Builder()
                .baseUrl("http://edflow.cladev.com/api/users/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService = retrofit.create(ApiService::class.java)
            }
            return  apiService!!
        }
    }
}
