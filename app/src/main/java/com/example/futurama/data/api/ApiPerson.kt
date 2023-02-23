package com.example.futurama.data.api

import com.example.futurama.data.dto.PersonDto
import retrofit2.http.GET

interface ApiPerson {

    @GET("characters/")
    suspend fun getCharacters(): List<PersonDto>
}