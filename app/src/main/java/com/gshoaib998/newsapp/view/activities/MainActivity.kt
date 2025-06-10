package com.gshoaib998.newsapp.view.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.gshoaib998.newsapp.utils.Constants
import com.gshoaib998.newsapp.utils.NetworkUtils
import com.gshoaib998.newsapp.model.database.NewsDatabase
import com.gshoaib998.newsapp.model.repo.NewsRepository
import com.gshoaib998.newsapp.viewModel.NewsViewModel
import com.gshoaib998.newsapp.viewModel.NewsViewModelFactory
import com.gshoaib998.newsapp.R
import com.gshoaib998.newsapp.view.ArticleItem
import com.gshoaib998.newsapp.databinding.ActivityMainBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var fastAdapter: FastAdapter<ArticleItem>
    private lateinit var itemAdapter: ItemAdapter<ArticleItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener { finish() }

        setupRecyclerView()

        lifecycleScope.launch(Dispatchers.IO) {
            val newsDAO = NewsDatabase.getDatabase(applicationContext).newsDao()
            val newsRepository = NewsRepository(newsDAO)
            val factory = NewsViewModelFactory(newsRepository, applicationContext)

            withContext(Dispatchers.Main) {
                viewModel = ViewModelProvider(this@MainActivity, factory)[NewsViewModel::class.java]
                observeProgressBar()
                observeData()
                delay(300)
                viewModel.loadArticles(Constants.SEARCH_DEFAULT_VALUE, Constants.NEWS_API_KEY)
            }
        }

    }
    private fun setupRecyclerView(){
        itemAdapter=ItemAdapter()
        fastAdapter=FastAdapter.with(itemAdapter)

        binding.recyclerview.adapter=fastAdapter
        binding.recyclerview.layoutManager=LinearLayoutManager(this)

        fastAdapter.onClickListener = { view,_, item,_ ->
            val intent = Intent(view?.context, ArticleDetailActivity::class.java).apply {
                putExtra(Constants.KEY_ARTICLE, item.article as Serializable)
            }
            startActivity(intent,  ActivityOptions.makeSceneTransitionAnimation(this,view,"view").toBundle())
            true
        }
    }
    private fun observeData(){
        viewModel.articlesLiveData.observe(this) {articles ->
            val articlesItem=articles.map {article-> ArticleItem(article = article) }
            itemAdapter.set(articlesItem)
        }
    }
    private fun observeProgressBar(){
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as? SearchView

        searchView?.queryHint = "Search News..."

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                lifecycleScope.launch {
                    query?.let {
                        if(NetworkUtils.isOnline(applicationContext))
                            withContext(Dispatchers.Main) {
                                viewModel.loadArticles(it, Constants.NEWS_API_KEY)
                            }
                        else
                            Toast.makeText(applicationContext,"You are Offline",Toast.LENGTH_SHORT).show()
                    }
                }
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return true
    }
}