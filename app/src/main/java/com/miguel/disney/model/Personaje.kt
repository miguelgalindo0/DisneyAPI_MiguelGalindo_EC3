package com.miguel.disney.model

import android.graphics.Color
import com.google.gson.annotations.SerializedName

data class Personaje(
    val serie: String,
    val nombre: String,
    val labels: List<String>,
    val color: String,
    @SerializedName("created_on")
    val createdOn: String
) {
    fun getColor() : Int = Color.parseColor(color)
}
fun getData(): List<Personaje> {
    return listOf(
        Personaje("Bolt", "Bolt", listOf("Animal","Animado"), "#B3C5FF", "17/08/2000"),
        Personaje("Gravity Falls", "Dipper", listOf("Persona","Animada"), "#B3C5FF", "13/07/2015"),
        Personaje("Kick Buttowski", "Brad", listOf("Persona","Animada"), "#B3C5FF", "13/07/2023"),
        Personaje("Liv y Maddie", "Liv", listOf("Persona","Real"), "#B3C5FF", "13/07/2022"),
        Personaje("Los Hechiceros de Waverly Place", "Alex", listOf("Persona","Real"), "#B3C5FF", "13/07/2010"),
    )
}
