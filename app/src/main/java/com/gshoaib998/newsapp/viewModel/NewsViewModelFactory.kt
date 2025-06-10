package com.gshoaib998.newsapp.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gshoaib998.newsapp.model.repo.NewsRepository

@Suppress("UNCHECKED_CAST")
class NewsViewModelFactory (private val newsRepository: NewsRepository, val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(NewsViewModel::class.java)){
            NewsViewModel(context,newsRepository) as T
        }else{
            throw IllegalArgumentException("Unknown viewmodel class ${modelClass.name}")
        }
    }

}