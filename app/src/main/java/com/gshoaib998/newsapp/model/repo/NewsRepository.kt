package com.gshoaib998.newsapp.model.repo

import com.gshoaib998.newsapp.model.Article
import com.gshoaib998.newsapp.model.api.ApiService
import com.gshoaib998.newsapp.model.database.NewsDAO
import com.gshoaib998.newsapp.model.api.RetrofitClint

class NewsRepository (private val newsDAO: NewsDAO, private val apiService: ApiService = RetrofitClint.apiService) {

    suspend fun loadArticles(q: String, apiKey: String,isOnline:Boolean): List<Article> {
        return if (isOnline) {
            val response = apiService.getEverythingArticles(q, apiKey)
            if (response.isSuccessful && response.body()?.status == "ok") {
                val articles = response.body()?.articles ?: emptyList()
                newsDAO.refreshArticles(articles)
                articles
            } else {
                newsDAO.getAllArticles()
            }
        } else {
            newsDAO.getAllArticles()
        }
    }

}