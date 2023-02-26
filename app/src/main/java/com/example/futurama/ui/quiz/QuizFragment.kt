package com.example.futurama.ui.quiz

import android.view.LayoutInflater
import com.example.futurama.databinding.FragmentQuizBinding
import com.example.core.base.BaseFragment

class QuizFragment : com.example.core.base.BaseFragment<FragmentQuizBinding>() {

    private lateinit var viewModel: QuizViewModel
    override fun initBinding(inflater: LayoutInflater) =
        FragmentQuizBinding.inflate(inflater)


}