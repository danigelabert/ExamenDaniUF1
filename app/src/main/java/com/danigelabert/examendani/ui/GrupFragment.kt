package com.danigelabert.examendani.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danigelabert.examendani.R
import com.danigelabert.examendani.adapter.AlumnesAdapter
import com.danigelabert.examendani.databinding.FragmentGrupBinding
import com.danigelabert.examendani.databinding.FragmentInsertBinding
import com.danigelabert.examendani.viewmodel.grupViewModel

class GrupFragment : Fragment() {



    private lateinit var binding: FragmentGrupBinding
    private lateinit var grupsViewModel: grupViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_grup, container, false
        )
        grupsViewModel = ViewModelProvider(this).get(grupsViewModel::class.java)


        viewManager = LinearLayoutManager(context)
        recyclerView = binding.recyclerAlumnes.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }

        grupsViewModel.obtenirMobles(requireContext())?.observe(viewLifecycleOwner, Observer { alumnesLlistat ->
            alumnesLlistat?.let {
                viewAdapter = AlumnesAdapter(it) { selectedItem ->
                }
                recyclerView.adapter = viewAdapter
            }
        })


        return binding.root
    }

}