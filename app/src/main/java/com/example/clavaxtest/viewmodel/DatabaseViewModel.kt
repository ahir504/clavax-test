package com.example.clavaxtest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.clavaxtest.model.ZipList
import com.example.clavaxtest.repository.DatabaseRepo
import com.example.clavaxtest.roomdatabase.ZipcodeDatabase

/**
 * @Author : Sahil Yadav
 * @Date : 16-08-2022
 * @Email : rao.sahab504@gmail.com
 */
class DatabaseViewModel(application: Application) : AndroidViewModel(application) {


    private val databaseRepo : DatabaseRepo

    init {
        val zipDao = ZipcodeDatabase.getDatabase(application).roomDao()
        databaseRepo = DatabaseRepo(zipDao)
    }


    fun addZipCode(zipList: ZipList){
        databaseRepo.addZipCode(zipList)
    }

    fun updateZipCode(zipList: ZipList){
        databaseRepo.updateZipCode(zipList)
    }

    fun deleteZipCode(zipList: ZipList){
        databaseRepo.deleteZipCode(zipList)
    }

    fun deleteAllZipCode(){
        databaseRepo.deleteAllZipCode()
    }

    fun readAllZipCode() : LiveData<List<ZipList>>{
        return databaseRepo.readAllZipCode()
    }
}