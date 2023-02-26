package com.example.person_list.presentation

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.person_list.di.PersonListComponentViewModel

class PersonListFragment : Fragment() {

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<PersonListComponentViewModel>()
            .newPersonListComponent.inject(this)
        super.onAttach(context)
    }
}