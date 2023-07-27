package com.miguel.disney.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguel.disney.databinding.FragmentNoteListBinding
import com.miguel.disney.model.getData
import com.miguel.disney.ui.viewmodels.NoteListViewModel

class NoteListFragment : Fragment() {
    private lateinit var binding : FragmentNoteListBinding
    private lateinit var viewModel : NoteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[NoteListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener la lista de datos de Personaje
        val dataList = getData()

        // Crear e inicializar el adaptador con la lista de datos
        val adapter = RVNoteListAdapter(dataList)

        // Establecer el adaptador en el RecyclerView
        binding.rvNoteList.adapter = adapter

        // Configurar el LinearLayoutManager
        binding.rvNoteList.layoutManager = LinearLayoutManager(requireContext())
    }

}