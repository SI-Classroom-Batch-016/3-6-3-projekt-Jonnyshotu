package de.syntax_institut.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntax_institut.mvvm.data.Repository
import de.syntax_institut.mvvm.data.module.Note
import java.lang.Exception

class SharedViewModel : ViewModel() {

    private val TAG = "Debug_SharedViewModel"

    var id = 1

    private val exampleNotes: List<Note> = Repository().loadNotes()

    private var _notes = MutableLiveData(exampleNotes)
    val notes: LiveData<List<Note>>
        get() = _notes


    inner class IdManager() {
        private val assignedIDs
            get() = _notes.value?.map { it.id }

        fun getNextFreeID(): Int {
            Log.d("Debug_IDManager", "assignedIDs: $assignedIDs")
            var id = 1
            try {
                while (assignedIDs!!.contains(id)) {
                    id++
                }
            } catch (e: Exception) {
                id = 1
            }
            Log.d("Debug_IDManager", "next ID: $id")

            return id
        }
    }

    fun editNote(headline: String, content: String) {
        _notes.value = _notes.value?.map { note ->
            if (note.id == id) {
                note.copy(headline = headline, content = content)
            } else {
                note
            }
        }
    }

    fun deleteNote() {
        _notes.value = _notes.value?.filter { it.id != id }
    }

    fun changePriority() {
        _notes.value = _notes.value?.map { note ->
            if (note.id == id) {
                val newPriority = when (note.priority) {
                    1 -> 2
                    2 -> 3
                    3 -> 1
                    else -> 1
                }
                note.copy(priority = newPriority)
            } else {
                note
            }
        }
    }

    fun addNote() {
        val newId = IdManager().getNextFreeID()
        id = newId
        _notes.value = _notes.value?.plus(Note(newId, "", "", 1))
    }
}