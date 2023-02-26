package com.example.api.api

import com.example.api.dto.PersonDto
import retrofit2.http.GET

interface ApiPerson {

    @GET("characters/")
    suspend fun getCharacters(): List<PersonDto>
}