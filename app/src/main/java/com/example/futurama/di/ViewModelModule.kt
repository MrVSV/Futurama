package com.example.futurama.di

import com.example.futurama.ui.quiz.QuizViewModel
import com.example.person_list.presentation.PersonListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
interface ViewModelModule {

//    @Binds
//    @[IntoMap ViewModelKey(PersonViewModel::class)]
//    fun bindPersonViewModel(personViewModel: PersonViewModel): com.example.core.base.BaseViewModel

    @Binds
    @[IntoMap ViewModelKey(QuizViewModel::class)]
    fun bindQuizViewModel(quizViewModel: QuizViewModel): com.example.core.base.BaseViewModel

    @Binds
    @[IntoMap ViewModelKey(PersonListViewModel::class)]
    fun bindPersonListViewModel(personListViewModel: PersonListViewModel): PersonListViewModel
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out com.example.core.base.BaseViewModel>)