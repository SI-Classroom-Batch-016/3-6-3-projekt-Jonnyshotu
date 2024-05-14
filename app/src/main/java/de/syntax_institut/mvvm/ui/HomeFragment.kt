package de.syntax_institut.mvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.adapter.NoteAdapter
import de.syntax_institut.mvvm.adapter.OnDeleteNoteClick
import de.syntax_institut.mvvm.adapter.OnEditNoteClick
import de.syntax_institut.mvvm.adapter.OnFlagClick
import de.syntax_institut.mvvm.adapter.OnNoteClick
import de.syntax_institut.mvvm.data.module.Note
import de.syntax_institut.mvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), OnEditNoteClick, OnNoteClick, OnDeleteNoteClick, OnFlagClick {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: NoteAdapter
    private lateinit var recyclerView: RecyclerView
    private val viewModel: SharedViewModel by activityViewModels()

    private val TAG = "Debug_HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater)

        recyclerView = binding.homeRV
        adapter = NoteAdapter(this,this,this, this)

        recyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.notes.observe(viewLifecycleOwner){notes ->
            Log.d("$TAG on View Created", notes.toString())
            adapter.submitList(notes)
        }

        binding.homeAddFAB.setOnClickListener {
            viewModel.addNote()
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEditFragment())

        }
    }

    override fun onEditNoteClick(note: Note) {
        viewModel.id = note.id
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEditFragment())
    }

    override fun onNoteClick(note: Note) {
        viewModel.id = note.id
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment())
    }

    override fun onDeleteNoteClick(note: Note) {
        viewModel.id = note.id
        viewModel.deleteNote()
    }

    override fun onFlagClick(note: Note) {
        viewModel.id = note.id
        viewModel.changePriority()

    }


}