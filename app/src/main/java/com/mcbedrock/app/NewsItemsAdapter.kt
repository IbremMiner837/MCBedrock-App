package com.mcbedrock.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.mcbedrock.app.data.NewsItem

class NewsItemsAdapter(private val items: List<NewsItem>) : RecyclerView.Adapter<NewsItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: MaterialTextView = itemView.findViewById(R.id.TitleView)
        private val descriptionTextView: MaterialTextView = itemView.findViewById(R.id.TextView)

        fun bind(item: NewsItem) {
            nameTextView.text = item.title
            descriptionTextView.text = item.description
        }
    }
}