package com.gshoaib998.newsapp.view.activities

import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gshoaib998.newsapp.model.Article
import com.gshoaib998.newsapp.utils.Constants
import com.gshoaib998.newsapp.utils.NetworkUtils
import com.gshoaib998.newsapp.R
import com.gshoaib998.newsapp.databinding.ActivityArticleDetailBinding

class ArticleDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityArticleDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        window.enterTransition = Slide(Gravity.END).apply {
            duration = 300
            interpolator = AccelerateDecelerateInterpolator()
        }

        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_article_detail)
        val article: Article =intent.getSerializableExtra(Constants.KEY_ARTICLE) as Article
        binding.article=article
        binding.btnFullStory.setOnClickListener{view->
            if(NetworkUtils.isOnline(this.applicationContext)) {
                val intent = Intent(view.context, ArticleWebViewActivity::class.java).apply {
                    putExtra(Constants.KEY_URL, article.url)
                }
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }else{
                val intent = Intent(view.context, OfflineActivity::class.java).apply {
                    putExtra(Constants.KEY_URL, article.url)
                }
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
        binding.toolbar.setNavigationOnClickListener { finish() }



    }
}