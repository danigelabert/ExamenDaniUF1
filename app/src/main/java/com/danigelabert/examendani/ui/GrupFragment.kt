package com.danigelabert.examendani.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
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
        grupsViewModel = ViewModelProvider(this).get(grupViewModel::class.java)
        // Importante requireActivity() para mostrar los datos de un fragment a otro con el shared view model
//        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

//        binding.plusButton.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_catalegFragment_to_insertCatalegFragment)
//        }

        viewManager = LinearLayoutManager(context)
        recyclerView = binding.recyclerAlumnes.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }

        grupsViewModel.obtenirMobles(requireContext())?.observe(viewLifecycleOwner, Observer { moblesLlistat ->
            moblesLlistat?.let {
                viewAdapter = AlumnesAdapter(it) { selectedItem ->
                    Toast.makeText(requireContext(), "Sisplau, completi tots els camps", Toast.LENGTH_SHORT).show()

//                    sharedViewModel.setSelectedItem(selectedItem)
//                    findNavController().navigate(R.id.action_catalegFragment_to_editCatalegFragment)
                }
                recyclerView.adapter = viewAdapter
            }
        })

//        binding.buscarButton.setOnClickListener {
//            val nom = binding.buscarNom.text.toString()
//            val preu = binding.buscarPreu.text.toString().trim() // Es posa toString.trim() per poder fer la condició si es empty o no en el preu ja que es un int no string
//            // Condició per si els valors de nom y preu de buscar son buits i si es fa clic al boto que no peti la app que salta un toast y retorni a dalt
//            if (nom.isEmpty() || preu.isEmpty()) {
//                Toast.makeText(requireContext(), "Sisplau, completi tots els camps", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//            // Es posa preu.toInt per pasar preu amb string a Int
//            catalegViewModel.buscarMobles(requireContext(), nom, preu.toInt())?.observe(viewLifecycleOwner, Observer { mobles ->
//                if (mobles.isNotEmpty()) {
//                    Toast.makeText(requireContext(), "Producte trobat", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(requireContext(), "Producte NO trobat", Toast.LENGTH_SHORT).show()
//                }
//            })
//        }

        recyclerView.setOnClickListener{
            Toast.makeText(context, "hola", Toast.LENGTH_SHORT).show()
        }

        binding.button2?.setOnClickListener{
            findNavController().navigate(R.id.action_grupFragment_to_insertFragment, null)
        }

        binding.showAprovats.setOnClickListener{
            grupsViewModel.getAlumnesAprovats(requireContext())?.observe(viewLifecycleOwner, Observer { moblesLlistat ->
                moblesLlistat?.let {
                    viewAdapter = AlumnesAdapter(it) { selectedItem ->
                        Toast.makeText(requireContext(), "Sisplau, completi tots els camps", Toast.LENGTH_SHORT).show()

//                    sharedViewModel.setSelectedItem(selectedItem)
//                    findNavController().navigate(R.id.action_catalegFragment_to_editCatalegFragment)
                    }
                    recyclerView.adapter = viewAdapter
                }
            })
        }

        binding.showNoAprovats.setOnClickListener{
            grupsViewModel.getAlumnesNoAprovats(requireContext())?.observe(viewLifecycleOwner, Observer { moblesLlistat ->
                moblesLlistat?.let {
                    viewAdapter = AlumnesAdapter(it) { selectedItem ->
                        Toast.makeText(requireContext(), "Sisplau, completi tots els camps", Toast.LENGTH_SHORT).show()

//                    sharedViewModel.setSelectedItem(selectedItem)
//                    findNavController().navigate(R.id.action_catalegFragment_to_editCatalegFragment)
                    }
                    recyclerView.adapter = viewAdapter
                }
            })
        }


        return binding.root
    }

}