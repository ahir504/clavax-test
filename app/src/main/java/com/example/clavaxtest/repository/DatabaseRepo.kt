package com.example.clavaxtest.repository

import androidx.lifecycle.LiveData
import com.example.clavaxtest.model.ZipList
import com.example.clavaxtest.roomdatabase.RoomDao

/**
* @Author : Sahil Yadav
* @Date : 16-08-2022
* @Email : rao.sahab504@gmail.com
*/class DatabaseRepo(private val roomDao: RoomDao) {


    fun addZipCode(zipList: ZipList){
        roomDao.addZipCode(zipList)
    }

    fun updateZipCode(zipList: ZipList){
        roomDao.updateZipCode(zipList)
    }

    fun deleteZipCode(zipList: ZipList){
        roomDao.deleteZipCode(zipList)
    }

    fun deleteAllZipCode(){
        roomDao.deleteAllZipCode()
    }

    fun readAllZipCode() : LiveData<List<ZipList>>{
      return  roomDao.readAllZipCode()
    }
}