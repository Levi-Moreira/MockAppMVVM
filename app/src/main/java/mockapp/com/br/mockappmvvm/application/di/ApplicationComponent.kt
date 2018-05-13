package mockapp.com.br.mockappmvvm.application.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import mockapp.com.br.mockappmvvm.application.MockApplication
import mockapp.com.br.mockappmvvm.users.di.TopUsersModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (FragmentBuilder::class), (AppModule::class),
    (DaggerViewModelFactoryModule::class), (TopUsersModule::class), (RepositoryModule::class)])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MockApplication)

}