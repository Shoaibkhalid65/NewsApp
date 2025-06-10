package com.gshoaib998.newsapp.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.gshoaib998.newsapp.model.Article

@Dao
interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllArticles(articles:List<Article>)

    @Query("DELETE FROM article")
    suspend fun deleteAllArticles()

    @Transaction
    suspend fun refreshArticles(articles: List<Article>){
        deleteAllArticles()
        insertAllArticles(articles)
    }

    @Query("SELECT * FROM article ORDER BY publishedAt DESC")
    suspend fun getAllArticles():List<Article>
}