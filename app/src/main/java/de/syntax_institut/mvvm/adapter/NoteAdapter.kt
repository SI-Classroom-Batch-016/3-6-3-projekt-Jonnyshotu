package de.syntax_institut.mvvm.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.mvvm.R
import de.syntax_institut.mvvm.data.module.Note
import de.syntax_institut.mvvm.data.module.NoteDiffUtil
import de.syntax_institut.mvvm.databinding.NoteListBinding

class NoteAdapter(
    private val listener: OnClick
) : ListAdapter<Note, NoteAdapter.ItemViewHolder>(NoteDiffUtil()) {

    inner class ItemViewHolder(val binding: NoteListBinding) : RecyclerView.ViewHolder(binding.root)

    private val TAG = "Debug_NoteAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = NoteListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = getItem(position)

        Log.d(TAG, note.toString())
        Log.d(TAG, currentList.toString())

        with(holder.binding) {

            noteListHeaderTV.text = note.headline
            noteListPreviewTV.text = note.content

            when (note.priority) {
                1 -> noteListFlagIV.setImageResource(R.drawable.baseline_flag_24_green)
                2 -> noteListFlagIV.setImageResource(R.drawable.baseline_flag_24_yellow)
                3 -> noteListFlagIV.setImageResource(R.drawable.baseline_flag_24_red)
            }
            noteListEditBTN.setOnClickListener {
                listener.onEditNoteClick(note)
            }
            noteListLLTV.setOnClickListener {
                listener.onNoteClick(note)
            }
            noteListDeleteBTN.setOnClickListener {
                listener.onDeleteNoteClick(note)
            }
            noteListFlagIV.setOnClickListener {
                listener.onFlagClick(note)
            }
        }
    }
}
