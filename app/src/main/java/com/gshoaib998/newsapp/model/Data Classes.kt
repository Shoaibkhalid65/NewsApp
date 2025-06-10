package com.gshoaib998.newsapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

import java.util.UUID


data class NewsApiResponse(
    val status:String,
    val totalResults:Int,
    val articles:List<Article>
)

@Entity(tableName = "article")
data class Article(
    @PrimaryKey
    val articleUUID : String = UUID.randomUUID().toString(),
    @Embedded
    val source: Source,
    val author: String?,
    val title:String,
    val description:String?,
    val url:String,
    val urlToImage:String?,
    val publishedAt:String,
    val content:String?
): Serializable
data class Source(
    val id:String?,
    val name:String?
):Serializable




