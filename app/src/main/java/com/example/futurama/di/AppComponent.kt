package com.example.futurama.di

import com.example.api.api.ApiPerson
import com.example.core.base.BaseViewModelFactory
import com.example.futurama.AppDependencies
import com.example.futurama.ui.person.PersonFragment
import com.example.futurama.ui.quiz.QuizFragment
import com.example.person_list.di.PersonListDependencies
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ApiModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ],
    dependencies = [AppDependencies::class]
)
@Singleton
interface AppComponent: PersonListDependencies {
    fun inject(personFragment: PersonFragment)
    fun inject(quizFragment: QuizFragment)



    @Component.Builder
    interface Builder {

        //        @BindsInstance
        fun appDependencies(appDependencies: AppDependencies): Builder

        fun build(): AppComponent


    }

    override val apiPerson: ApiPerson
}


