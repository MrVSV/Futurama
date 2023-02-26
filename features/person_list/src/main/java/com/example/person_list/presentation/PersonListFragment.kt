package com.example.person_list.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.example.core.base.BaseFragment
import com.example.core.base.BaseViewModelFactory
import com.example.core.model.Person
import com.example.core.tools.ClickableView
import com.example.core.tools.LoadState
import com.example.person_list.databinding.FragmentPersonListBinding
import com.example.person_list.di.PersonListComponentViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class PersonListFragment : BaseFragment<FragmentPersonListBinding>() {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentPersonListBinding.inflate(inflater)

    @Inject
    lateinit var personViewModelFactory: BaseViewModelFactory

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<PersonListComponentViewModel>()
            .newPersonListComponent.inject(this)
        super.onAttach(context)
    }

    private val viewModel by viewModels<PersonListViewModel> { personViewModelFactory }

    private val adapter by lazy {
        PersonAdapter { clickableView, item, position -> onClick(clickableView, item, position) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingAdapter()
        observePersonData()
        loadStateItemsObserve()
        initRefresher()
    }

    private fun loadStateItemsObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadState.collect{loadState ->
                when(loadState){
                    LoadState.SUCCESS -> {}
                    LoadState.ERROR -> {
                        Toast.makeText(requireContext(), loadState.message, Toast.LENGTH_SHORT)
                            .show()
                    }
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


    private fun onClick(clickableView: ClickableView, item: Person, position: Int) {
        if(clickableView == ClickableView.FAVORITE) {
            viewModel.onClick(item, position)
            adapter.notifyItemChanged(position)
        }
    }

    private fun initRefresher() {
        binding.swipeRefresh.setOnRefreshListener {
            observePersonData()
            binding.swipeRefresh.isRefreshing = false
        }
    }
}