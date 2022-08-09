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
import com.example.clavaxtest.viewmodel.ZipModelFactory
import com.example.clavaxtest.viewmodel.ZipViewModel
import com.google.android.material.snackbar.Snackbar

 class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: ZipViewModel
    private val apiService = ApiService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        initViewModel()


    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this, ZipModelFactory(ZipRepo(apiService,this.application)))[ZipViewModel::class.java]

        viewModel.zipCode.observe(this){
            setAdapter(it.data.list)
            Log.d("TAG",it.toString())
        }

        viewModel.error.observe(this){
            Log.d("TAG",it.toString())
            Snackbar.make(binding.layout,it.toString(),Snackbar.LENGTH_LONG).show()
        }
        viewModel.getZipcode()
     }

     private fun setAdapter(zipList : List<ZipList>){
         val zipCodeAdapter = ZipCodeAdapter(zipList,this)
         binding.myAdapter = zipCodeAdapter

     }
}
