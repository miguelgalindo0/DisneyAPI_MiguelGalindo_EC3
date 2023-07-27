package com.miguel.disney.data.repository

import com.miguel.disney.data.PersonajeServiceResult
import com.miguel.disney.data.response.ListNoteResponse
import com.miguel.disney.data.retrofit.RetrofitHelper
import com.miguel.disney.model.Personaje

class PersonajeRepository {
    suspend fun getNotes() : PersonajeServiceResult<ListNoteResponse> {
        return try {
            val response = RetrofitHelper.personajeService.getAllNotes()
            PersonajeServiceResult.Success(response)
        }
        catch (e : Exception) {
            PersonajeServiceResult.Error(e)
        }
    }
}