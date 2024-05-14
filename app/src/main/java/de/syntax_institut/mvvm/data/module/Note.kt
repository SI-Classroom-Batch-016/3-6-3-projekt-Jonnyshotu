package de.syntax_institut.mvvm.data.module

data class Note(
    val id: Int,
    var headline: String,
    var content: String,
    val priority: Int,
)