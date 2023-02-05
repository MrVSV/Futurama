package com.example.futurama.domain.model

data class Person(
    val name: String,
    val images: String,
    val gender: String,
    val species: String,
    val homePlanet: String?,
    val occupation: String,
//    val sayings: List<String>,
    val id: Int,
    val age: String
)
