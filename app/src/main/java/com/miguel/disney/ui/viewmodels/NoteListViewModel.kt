package com.miguel.disney.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguel.disney.data.PersonajeServiceResult
import com.miguel.disney.data.repository.PersonajeRepository
import com.miguel.disney.model.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteListViewModel: ViewModel() {
    private val _notes : MutableLiveData<List<Personaje>> = MutableLiveData<List<Personaje>>()
    val notes: LiveData<List<Personaje>> = _notes

    private val repository = PersonajeRepository()

    /*fun getAllNotes() {
        val noteList = getData()
        _notes.value = noteList
    }*/

    fun getNotesFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getNotes()
            when (response) {
                is PersonajeServiceResult.Success -> {
                    _notes.postValue(response.data.notes)
                }
                is PersonajeServiceResult.Error -> {
                    //Pasar un error a otro lado
                }
            }
        }
    }

}