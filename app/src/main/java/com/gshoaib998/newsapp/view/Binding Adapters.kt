package com.gshoaib998.newsapp.view

import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import coil.load
import com.gshoaib998.newsapp.R
import java.time.Duration
import java.time.ZoneId
import java.time.ZonedDateTime


@BindingAdapter("imageUrl")
fun loadImage(view: ImageView,url:String?){
    view.load(url){
        placeholder(R.drawable.__dots_bounce)
        error(R.drawable.broken_image)
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@BindingAdapter("formatedDate")
fun setDate(textView: TextView, inputDate:String){
        try {
            val inputZonedDateTime = ZonedDateTime.parse(inputDate)
            val currentZonedDateTime = ZonedDateTime.now(ZoneId.systemDefault())
            val duration = Duration.between(inputZonedDateTime, currentZonedDateTime)
            val result: String = when {
                duration.toMinutes() < 60 -> "${duration.toMinutes()}m"
                duration.toHours() < 24 -> "${duration.toHours()}h"
                else -> "${duration.toDays()}d"
            }
            textView.text = result
        } catch (e: Exception) {
            textView.text = "Invalid date"
        }
    }
@BindingAdapter("formatedContent")
fun setContent(textView: TextView,content:String){
    val l=content.length
    val truncatedContent=content.substring(0,l-13)
    textView.text=truncatedContent
}
@BindingAdapter("formatedAuthor")
fun setAuthor(textView: TextView,author:String?){
    author?.let {
        val l = author.length
        var truncatedAuthor: String
        if (l > 15) {
            truncatedAuthor = author.split(" ")[0]
            if (truncatedAuthor.length > 15)
                truncatedAuthor = author.substring(0, 14)
        } else
            truncatedAuthor = author
        textView.text = "by $truncatedAuthor"
    }
}