package com.example.futurama.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImagesDto(
    @Json(name = "head-shot")
    val headShot: String,
    val main: String
)