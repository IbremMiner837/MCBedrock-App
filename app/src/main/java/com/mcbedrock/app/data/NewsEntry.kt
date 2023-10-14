package com.mcbedrock.app.data

data class NewsEntry(
    val entries: List<Entry>,
    val version: Int
)

data class Entry(
    val cardBorder: Boolean,
    val category: String,
    val date: String,
    val id: String,
    val newsPageImage: NewsPageImage,
    val newsType: List<String>,
    val playPageImage: PlayPageImage,
    val readMoreLink: String,
    val tag: String,
    val text: String,
    val title: String
)

data class NewsPageImage(
    val dimensions: Dimensions,
    val title: String,
    val url: String
)

data class PlayPageImage(
    val title: String,
    val url: String
)

data class Dimensions(
    val height: Int,
    val width: Int
)