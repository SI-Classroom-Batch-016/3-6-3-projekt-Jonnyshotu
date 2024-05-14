package de.syntax_institut.mvvm.adapter

import de.syntax_institut.mvvm.data.module.Note

interface OnNoteClick {
    fun onNoteClick(note: Note)
}