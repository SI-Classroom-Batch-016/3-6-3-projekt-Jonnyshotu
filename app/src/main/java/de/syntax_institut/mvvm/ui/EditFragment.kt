package de.syntax_institut.mvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.databinding.FragmentEditBinding

class EditFragment : Fragment() {
    private val TAG = "Debug_EditFragment"


    private lateinit var binding: FragmentEditBinding
    private val viewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val note = viewModel.notes.value?.find { it.id == viewModel.id }
        Log.d(TAG, "${note.toString()} ${viewModel.id}")

        with(binding) {
            editHeaderET.hint = note?.headline?.ifBlank { "headline" }
            editNoteET.setText(note?.content)

            editSaveBTN.setOnClickListener {
                if (editHeaderET.text.isBlank()) {
                    editHeaderET.setText(editHeaderET.hint)
                }
                viewModel.editNote(editHeaderET.text.toString(), editNoteET.text.toString())
                findNavController().navigate(EditFragmentDirections.actionEditFragmentToHomeFragment())
            }
            editCancelBTN.setOnClickListener {
                findNavController().navigate(EditFragmentDirections.actionEditFragmentToHomeFragment())
            }
            editDeleteBTN.setOnClickListener {
                findNavController().navigate(EditFragmentDirections.actionEditFragmentToHomeFragment())
                viewModel.deleteNote()
            }
        }

    }

}