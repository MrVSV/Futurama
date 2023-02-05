package com.example.futurama.ui.person

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.futurama.databinding.FragmentPersonBinding
import com.example.futurama.domain.model.Person
import com.example.futurama.domain.tools.LoadState
import com.example.futurama.ui.base.BaseFragment
import com.example.humblrvsv.domain.tools.ClickableView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PersonFragment : BaseFragment<FragmentPersonBinding>() {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentPersonBinding.inflate(inflater)

    private val viewModel by viewModels<PersonViewModel>()

    private val adapter by lazy {
        PersonAdapter { clickableView, item -> onClick(clickableView, item) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: 123")
        settingAdapter()
        observePersonData()
        loadStateItemsObserve()
    }

    private fun loadStateItemsObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadState.collect{loadState ->
                when(loadState){
                    LoadState.SUCCESS -> {}
                    else -> {}
                }

            }
        }
    }

    private fun observePersonData() {
        viewModel.personList.onEach { personList ->
            adapter.setData(personList)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun settingAdapter() {
        binding.recycler.adapter = adapter
        binding.recycler.itemAnimator?.changeDuration = 0
    }


    private fun onClick(clickableView: ClickableView, item: Person) {}
}