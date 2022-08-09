package com.example.clavaxtest.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clavaxtest.model.ZipList
import com.example.clavaxtest.model.Zipcode
import com.example.clavaxtest.repository.ZipRepo
import com.example.clavaxtest.roomdatabase.ZipcodeDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ZipViewModel(private val repo: ZipRepo, application: Application) : AndroidViewModel(application) {
    val zipCode = MutableLiveData<Zipcode>()
    val error = MutableLiveData<String>()

    fun getZipcode(){
val dataResponce = repo.getZipCode()
        dataResponce.enqueue(object : Callback<Zipcode>{
            override fun onFailure(call: Call<Zipcode>, t: Throwable) {
                error.postValue(t.message)
            }

            override fun onResponse(call: Call<Zipcode>, response: Response<Zipcode>) {
                zipCode.postValue(response.body())
            }
        })
    }

}
