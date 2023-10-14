package com.mcbedrock.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.mcbedrock.app.R
import com.mcbedrock.app.data.NewsEntry

class NewsAdapter(var context: Context, var newsEntryList: MutableList<NewsEntry>):
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleView: MaterialTextView
        var textView: MaterialTextView
        var imageView: ImageView
        var readMoreBtn: MaterialButton

        init {
            titleView = itemView.findViewById(R.id.TitleView)
            textView = itemView.findViewById(R.id.TextView)
            imageView = itemView.findViewById(R.id.ImageView)
            readMoreBtn = itemView.findViewById(R.id.ActionButton)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news_card, parent, false))
    }

    override fun onBindViewHolder(holder: NewsAdapter.MyViewHolder, position: Int) {
        val entry = newsEntryList[position].entries[position]

        holder.titleView.text = entry.title
        holder.textView.text = entry.text

        Glide.with(context)
            .load("https://launchercontent.mojang.com/" + entry.newsPageImage.url)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return newsEntryList.size
    }
}