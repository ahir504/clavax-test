package com.example.clavaxtest.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clavaxtest.model.Zipcode
import com.example.clavaxtest.repository.ZipRepo

class ZipModelFactory(private val repo: ZipRepo, private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ZipViewModel::class.java)) {
            ZipViewModel(this.repo, this.application) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
