package com.miguel.disney.ui.fragments

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.miguel.disney.databinding.ItemNoteBinding
import com.miguel.disney.model.Personaje

/*private val notes*/
class RVNoteListAdapter(var notes : List<Personaje>) : RecyclerView.Adapter<NoteVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteVH(binding)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        holder.bind(notes[position])
    }
}

class NoteVH(private val binding : ItemNoteBinding) : ViewHolder(binding.root) {
    fun bind(note: Personaje) {
        binding.txtSerieTitle.text = note.serie
        binding.txtNombreNote.text = note.nombre
        val labelString = note.labels.joinToString( " | " )
        binding.txtLablesNote.text = labelString
        binding.txtCreatedonNote.text = note.createdOn
        binding.cvItemNote.setCardBackgroundColor(ColorStateList.valueOf(note.getColor()))
    }
}