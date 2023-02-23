package com.example.person_list

import com.example.data_base.entity.PersonEntity

data class Person(
    val name: String,
    val images: String,
    val gender: String,
    val species: String,
    val homePlanet: String?,
    val occupation: String,
//    val sayings: List<String>,
    val id: Int,
    val age: String,
    var isFavorite: Boolean
){
    fun toPersonEntity() = PersonEntity(
        id = id,
        name = name
    )
}
