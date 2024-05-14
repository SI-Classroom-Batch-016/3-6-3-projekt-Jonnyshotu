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
import de.syntax_institut.mvvm.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val TAG = "Debug_DetailFragment"


    private lateinit var binding: FragmentDetailBinding
    private val viewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val note = viewModel.notes.value?.find { it.id == viewModel.id}
        Log.d(TAG,"${note.toString()} ${viewModel.id}")

        with(binding){
            detailHeaderTV.text = note?.headline
            detailNoteTV.text = note?.content
            binding.detailEditBTN.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToEditFragment())
            }
            binding.detailNoteDeleteBTN.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToHomeFragment())
                viewModel.deleteNote()
            }
        }

    }

}