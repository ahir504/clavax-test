package com.example.clavaxtest.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.clavaxtest.model.ZipList

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addZipCode(zipList: ZipList)

    @Update
    fun updateZipCode(zipList: ZipList)

    @Delete
    fun deleteZipCode(zipList: ZipList)

    @Query("DELETE FROM zipcode_table")
    fun deleteAllZipCode()

    @Query("SELECT * FROM zipcode_table ORDER BY id")
    fun readAllZipCode(): LiveData<List<ZipList>>
}
