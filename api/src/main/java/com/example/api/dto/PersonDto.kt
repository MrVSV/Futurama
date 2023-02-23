package com.example.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PersonDto(
    val name: NameDto,
    val images: ImagesDto,
    val gender: String,
    val species: String,
    val homePlanet: String?,
    val occupation: String,
    val sayings: List<String>,
    val id: Int,
    val age: String,
    @Json(ignore = true)
    var isFavorite: Boolean = false
){
//    fun toPerson()= Person(
//        name = name.fullName.joinToString(" "),
//        images = images.main,
//        gender = gender,
//        species = species,
//        homePlanet = homePlanet,
//        occupation = occupation,
//        id = id,
//        age = age,
//        isFavorite = isFavorite
//    )
}