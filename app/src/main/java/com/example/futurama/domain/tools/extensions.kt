package com.example.futurama.domain.tools

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.api.dto.PersonDto
import com.example.futurama.App
import com.example.futurama.R
import com.example.futurama.di.AppComponent
import com.example.futurama.domain.model.Person
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

fun Context.appComponent(): AppComponent =
    when(this){
        is App -> appComponent
        else -> this.applicationContext.appComponent()
    }

fun List<PersonDto>.toListPerson(): List<Person> =
    this.map { item -> item.toPerson() }

fun PersonDto.toPerson()= Person(
    name = name.fullName.joinToString(" "),
    images = images.main,
    gender = gender,
    species = species,
    homePlanet = homePlanet,
    occupation = occupation,
    id = id,
    age = age,
    isFavorite = isFavorite
)

fun TabLayout.setSelectedTabListener(block: (position: Int) -> Unit){
    this.addOnTabSelectedListener(object : OnTabSelectedListener{
        override fun onTabSelected(tab: TabLayout.Tab?) {
            if (tab != null) { block(tab.position) }
        }
        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabReselected(tab: TabLayout.Tab?) {}
    })
}

fun ImageView.loadImage(urls: String) {
    Log.d("Glide", "loadImage: ")
    Glide.with(this)
        .load(urls)
        .error(R.drawable.error_image)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(R.drawable.placeholder)
        .into(this)


}
