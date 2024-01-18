package com.danigelabert.examendani.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.danigelabert.examendani.R
import com.danigelabert.examendani.databinding.FragmentInsertBinding
import com.danigelabert.examendani.viewmodel.InsertViewModel

class InsertFragment : Fragment() {
    private lateinit var binding: FragmentInsertBinding
    private lateinit var insertViewModel: InsertViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_insert, container, false
        )

        insertViewModel = ViewModelProvider(this).get(InsertViewModel::class.java)

        binding.btnInsert.setOnClickListener {

            val nom = binding.nameEditText.text.toString()
            val grup = binding.grupEditText.text.toString()
            val nota = binding.notaEditText.text.toString().toInt()

            insertViewModel.newAlumnes(requireContext(), nom, grup, nota)
//            Navigation.findNavController(it).navigate(R.id.action_insertCatalegFragment_to_catalegFragment)



        }

        binding.button?.setOnClickListener{
            findNavController().navigate(R.id.action_insertFragment_to_grupFragment, null)
        }


        return binding.root
    }


}