package com.example.futurama.ui.person

import android.widget.ImageView
import com.example.futurama.databinding.PersonViewHolderBinding
import com.example.futurama.domain.model.Person
import com.example.futurama.domain.tools.loadImage
import com.example.futurama.ui.base.BaseViewHolder
import com.example.humblrvsv.domain.tools.ClickableView

class PersonViewHolder(private val binding: PersonViewHolderBinding) :
    BaseViewHolder<Person>(binding) {

    override fun bind(item: Person, onClick: (ClickableView, item: Person) -> Unit) {

        with(binding){
            name.text = item.name
            species.text = item.species
            avatar.loadImage(item.images)
        }
    }
}