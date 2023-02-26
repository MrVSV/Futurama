package com.example.person_list.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.core.databinding.PersonViewHolderBinding
import com.example.core.tools.ClickableView
import com.example.core.model.Person

class PersonAdapter(
    private val onClick: (ClickableView, Person, position: Int) -> Unit
) : Adapter<PersonViewHolder>() {

    private var personList: List<Person> = emptyList()

    fun setData(personList: List<Person>){
        this.personList = personList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        PersonViewHolder(
            PersonViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = personList.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val item = personList[position]
        holder.bind(item) { clickableView, person -> onClick(clickableView, person, position) }
    }
}