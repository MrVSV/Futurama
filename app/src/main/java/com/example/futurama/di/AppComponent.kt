package com.example.futurama.di

import com.example.futurama.AppDeps
import com.example.futurama.ui.base.BaseViewModelFactory
import com.example.futurama.ui.person.PersonFragment
import com.example.futurama.ui.quiz.QuizFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ApiModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ],
    dependencies = [AppDeps::class]
)
@Singleton
interface AppComponent {
    fun inject(personFragment: PersonFragment)
    fun inject(quizFragment: QuizFragment)

    val factory: BaseViewModelFactory

    @Component.Builder
    interface Builder {

        //        @BindsInstance
        fun appDeps(appDeps: AppDeps): Builder

        fun build(): AppComponent


    }
}


