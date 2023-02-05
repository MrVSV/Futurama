package com.example.futurama.domain.tools

enum class LoadState (var message:String="") {
    START,LOADING_STAGE_1,LOADING_STAGE_2,ERROR,SUCCESS
}