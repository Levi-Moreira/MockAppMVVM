package mockapp.com.br.mockappmvvm.application.di

import android.app.Application

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import mockapp.com.br.mockappmvvm.application.MockApplication

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (FragmentBuilder::class), (AppModule::class)])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MockApplication)

}