package com.example.futurama.di

import com.example.futurama.AppDeps
import com.example.futurama.ui.person.PersonFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
//    AppModule::class,
        ApiModule::class,
        DatabaseModule::class,
        RepositoryModule::class],
    dependencies = [AppDeps::class]
)
@Singleton
interface AppComponent {
    fun inject(personFragment: PersonFragment)

    @Component.Builder
    interface Builder {

//        @BindsInstance
        fun appDeps(appDeps: AppDeps): Builder

        fun build(): AppComponent


    }
}


