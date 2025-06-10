package com.gshoaib998.newsapp.model.api


import com.gshoaib998.newsapp.utils.Constants
import com.gshoaib998.newsapp.model.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.EVERYTHING_END_POINT)
    suspend fun getEverythingArticles(
        @Query("q") q: String,
        @Query("apiKey") apiKey:String,
        @Query("pageSize") pageSize:Int=40

    ):Response<NewsApiResponse>
}