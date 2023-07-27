package com.miguel.disney.data.retrofit

import com.miguel.disney.data.response.ListNoteResponse
import retrofit2.http.GET

interface PersonajeService {
    @GET("10a576f3-9640-4823-a033-e17a2a0535b9")
    suspend fun getAllNotes(): ListNoteResponse
}