package de.syntax_institut.mvvm.adapter

import de.syntax_institut.mvvm.data.module.Note

interface  OnClick {
    fun onEditNoteClick(note: Note)
    fun onNoteClick(note: Note)
    fun onFlagClick (note: Note)
    fun onDeleteNoteClick(note: Note)

}