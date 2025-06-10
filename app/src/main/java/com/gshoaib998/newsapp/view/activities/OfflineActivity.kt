package com.gshoaib998.newsapp.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.gshoaib998.newsapp.utils.Constants
import com.gshoaib998.newsapp.utils.NetworkUtils
import com.gshoaib998.newsapp.R

class OfflineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline)
        val btnRefresh=findViewById<Button>(R.id.btn_refresh)
        val url=intent.getStringExtra(Constants.KEY_URL)
        btnRefresh.setOnClickListener{
            if(NetworkUtils.isOnline(this.applicationContext)) {
                val intent = Intent(this, ArticleWebViewActivity::class.java).apply {
                    putExtra(Constants.KEY_URL, url)
                }
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }


    }
}