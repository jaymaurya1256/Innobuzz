package com.example.innobuzz.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import com.example.innobuzz.MyApplication
import com.example.innobuzz.database.Table
import com.example.innobuzz.network.RetrofitClient
import com.example.innobuzz.network.entity.Post
import com.example.innobuzz.utils.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel : ViewModel() {
    var postDetailLiveData = MutableLiveData<Table?>()


    fun getDetails(id: Int) {
        viewModelScope.launch {
            try {
                postDetailLiveData.value = withContext(Dispatchers.IO) { MyApplication.database.dao().getDetails(id) }
            } catch (e: Exception) {
            }
        }
    }
}