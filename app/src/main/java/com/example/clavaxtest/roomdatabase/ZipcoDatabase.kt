package com.example.clavaxtest.roomdatabase

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clavaxtest.model.ZipList

@Database(entities = [ZipList::class], version = 1, exportSchema = false)
abstract class ZipcodeDatabase() : RoomDatabase() {


    abstract fun roomDao(): RoomDao

    companion object {
        @Volatile
        private var INSTANCE: ZipcodeDatabase? = null

        fun getDatabase(context: Context): ZipcodeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ZipcodeDatabase::class.java,
                    "zip_code_db"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build().also {
                        INSTANCE = it
                    }

                INSTANCE=instance
                return instance
            }
        }
    }
}
