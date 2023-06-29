package com.example.innobuzz.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innobuzz.MyApplication
import com.example.innobuzz.database.Posts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel : ViewModel() {
    var postDetailLiveData = MutableLiveData<Posts?>()

    fun getDetails(id: Int) {
        viewModelScope.launch {
            try {
                postDetailLiveData.value = withContext(Dispatchers.IO) { MyApplication.database.dao().getDetails(id) }
            } catch (e: Exception) {
            }
        }
    }
}