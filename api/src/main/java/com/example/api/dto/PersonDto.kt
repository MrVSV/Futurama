package com.example.api.dto

import com.example.futurama.data.dto.ImagesDto
import com.example.futurama.data.dto.NameDto
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

}