package com.example.futurama.ui.person

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.futurama.databinding.FragmentPersonBinding
import com.example.futurama.domain.model.Person
import com.example.futurama.domain.tools.ClickableView
import com.example.futurama.domain.tools.LoadState
import com.example.futurama.domain.tools.appComponent
import com.example.futurama.ui.base.BaseFragment
import com.example.futurama.ui.base.BaseViewModelFactory
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class PersonFragment : BaseFragment<FragmentPersonBinding>() {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentPersonBinding.inflate(inflater)

    @Inject
    lateinit var personViewModelFactory: BaseViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent().inject(this)
    }

    private val viewModel by viewModels<PersonViewModel> { personViewModelFactory }

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