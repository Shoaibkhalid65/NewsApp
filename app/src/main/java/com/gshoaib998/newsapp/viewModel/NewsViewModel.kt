package com.gshoaib998.newsapp.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gshoaib998.newsapp.model.Article
import com.gshoaib998.newsapp.model.repo.NewsRepository
import com.gshoaib998.newsapp.utils.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(private val appContext: Context, private val newsRepository: NewsRepository):ViewModel() {

    val articlesLiveData = MutableLiveData<List<Article>>()
    val isLoading = MutableLiveData<Boolean>()

    fun loadArticles(q: String, apiKey: String) {
        isLoading.value=true
        val isConnected= NetworkUtils.isOnline(appContext)
        viewModelScope.launch (Dispatchers.IO){
            val articles = newsRepository.loadArticles(q, apiKey, isConnected)
            withContext(Dispatchers.Main) {
                articlesLiveData.postValue(articles)
                isLoading.value=false
            }
        }
    }

}