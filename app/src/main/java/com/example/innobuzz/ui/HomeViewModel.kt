package com.example.innobuzz.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innobuzz.MyApplication
import com.example.innobuzz.database.Posts
import com.example.innobuzz.network.RetrofitClient
import com.example.innobuzz.network.entity.Post
import com.example.innobuzz.utils.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    var posts: MutableList<Posts> = mutableListOf()
    val postLiveData = MutableLiveData<ApiResult<List<Post>>>()

    fun getUsers() {
        postLiveData.value = ApiResult.Loading

        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) { RetrofitClient.apiService.getPosts() }
                if (response.isSuccessful) {
                    val posts = response.body()
                    postLiveData.value = ApiResult.Success(posts!!)
                } else {
                    val errorBody = response.errorBody()?.string()
                    postLiveData.value = ApiResult.Error(errorBody ?: "Unknown error")
                }
            } catch (e: Exception) {
                postLiveData.value = ApiResult.Error(e.message ?: "Unknown error")
            }
        }
    }
    fun saveListToLocalDatabase(post: List<Post>) {
        for (i in post) {
            val temp = Posts(i.title, i.body, i.id, i.userId)
            posts.add(temp)
        }
    }
}
