package com.gshoaib998.newsapp.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gshoaib998.newsapp.model.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class NewsDatabase:RoomDatabase() {
    abstract fun newsDao(): NewsDAO
    companion object{
        @Volatile
        private var INSTANCE: NewsDatabase?=null
        fun getDatabase(context: Context): NewsDatabase {
            return INSTANCE ?: synchronized(this){
                val instance=Room.databaseBuilder(context.applicationContext,
                    NewsDatabase::class.java,"news_database").build()
                INSTANCE =instance
                instance
            }
        }
    }
}