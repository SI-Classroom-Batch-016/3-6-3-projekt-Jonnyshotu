package de.syntax_institut.mvvm.data.module

import android.util.Log
import androidx.recyclerview.widget.DiffUtil.ItemCallback

class NoteDiffUtil : ItemCallback<Note>() {

    private val TAG = "Debug_NoteDiffUtil"
    override fun areItemsTheSame(oldNote: Note, newNote: Note): Boolean {
        val result = oldNote.content == newNote.content
        Log.d(TAG, "result: $result oldNote: $oldNote, newNote: $newNote")
        return result
    }

    override fun areContentsTheSame(oldNote: Note, newNote: Note): Boolean {
        val result = oldNote == newNote
        Log.d(TAG, "result: $result oldNote: $oldNote, newNote: $newNote")
        return result
    }
}