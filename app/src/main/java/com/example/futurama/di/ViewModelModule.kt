package com.example.futurama.di

import com.example.futurama.ui.base.BaseViewModel
import com.example.futurama.ui.person.PersonViewModel
import com.example.futurama.ui.quiz.QuizViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
interface ViewModelModule {

    @Binds
    @[IntoMap ViewModelKey(PersonViewModel::class)]
    fun bindPersonViewModel(personViewModel: PersonViewModel): BaseViewModel

    @Binds
    @[IntoMap ViewModelKey(QuizViewModel::class)]
    fun bindQuizViewModel(quizViewModel: QuizViewModel): BaseViewModel
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out BaseViewModel>)