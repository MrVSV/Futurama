package com.example.api.dto


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NameDto(
    val first: String,
    val middle: String,
    val last: String
){
    val fullName = listOf(first, middle, last)
}