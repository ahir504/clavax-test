 package com.example.clavaxtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.clavaxtest.adapter.ZipCodeAdapter
import com.example.clavaxtest.databinding.ActivityMainBinding
import com.example.clavaxtest.model.ZipList
import com.example.clavaxtest.model.Zipcode
import com.example.clavaxtest.network.ApiService
import com.example.clavaxtest.repository.ZipRepo
import com.example.clavaxtest.viewmodel.DatabaseViewModel
import com.example.clavaxtest.viewmodel.ZipModelFactory
import com.example.clavaxtest.viewmodel.ZipViewModel
import com.google.android.material.snackbar.Snackbar

 class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: ZipViewModel
    private lateinit var databaseViewModel : DatabaseViewModel
    private val apiService = ApiService.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        initViewModel()

    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this, ZipModelFactory(ZipRepo(apiService)))[ZipViewModel::class.java]

        databaseViewModel = ViewModelProvider(this)[DatabaseViewModel::class.java]

        viewModel.zipCode.observe(this){

            for (zipCode in it.data.list){
                databaseViewModel.addZipCode(zipCode)
            }
            getZipCodeFromDataBase()
        }

        viewModel.error.observe(this){
            Log.d("TAG",it.toString())
            Snackbar.make(binding.layout,it.toString(),Snackbar.LENGTH_LONG).show()
        }
        viewModel.getZipcode()
     }


    private fun getZipCodeFromDataBase(){
        databaseViewModel.readAllZipCode().observe(this){
            setAdapter(it)
        }
    }

     private fun setAdapter(zipList : List<ZipList>){
         val zipCodeAdapter = ZipCodeAdapter(zipList,this)
         binding.myAdapter = zipCodeAdapter

     }
}
