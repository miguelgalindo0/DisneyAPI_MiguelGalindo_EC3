package com.miguel.disney.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.miguel.disney.databinding.FragmentNoteFavoriteBinding
import com.miguel.disney.model.Personaje

class NoteFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentNoteFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Replace this with your favorite Personaje object
        val favoritePersonaje = getFavoritePersonaje()

        binding.txtNoteTitle.text = favoritePersonaje.serie
        binding.txtContentNote.text = favoritePersonaje.nombre
        val labelString = favoritePersonaje.labels.joinToString(" | ")
        binding.txtLablesNote.text = labelString
        binding.txtCreatedonNote.text = favoritePersonaje.createdOn

        Glide.with(this).load("https://goo.gl/gEgYUd").into(binding.imageView)
    }

    // Replace this with your actual favorite Personaje
    private fun getFavoritePersonaje(): Personaje {
        return Personaje("Bolt", "Bolt", listOf("Animal", "Animado"), "#B3C5FF", "17/08/2000")
    }
}
