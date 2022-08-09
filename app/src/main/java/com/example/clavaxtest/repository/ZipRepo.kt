package com.example.clavaxtest.repository

import android.app.Application
import com.example.clavaxtest.network.ApiService

class ZipRepo(private val apiService: ApiService) {


    fun getZipCode() = apiService.getZipcode()



}
