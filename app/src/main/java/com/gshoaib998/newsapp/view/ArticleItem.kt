package com.gshoaib998.newsapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gshoaib998.newsapp.model.Article
import com.gshoaib998.newsapp.R
import com.gshoaib998.newsapp.databinding.HeadlineItemViewBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class ArticleItem(override val type: Int= R.id.main, val article: Article) : AbstractBindingItem<HeadlineItemViewBinding>() {
    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): HeadlineItemViewBinding {
        return HeadlineItemViewBinding.inflate(inflater,parent,false)
    }

    override fun bindView(binding: HeadlineItemViewBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)
        binding.article=article
    }

    override fun unbindView(binding: HeadlineItemViewBinding) {
        super.unbindView(binding)
        binding.article=null
    }
}