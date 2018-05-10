package mockapp.com.br.mockappmvvm.application.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mockapp.com.br.mockappmvvm.users.TopUsersFragment
import mockapp.com.br.mockappmvvm.users.TopUsersModule

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = [(TopUsersModule::class)])
    abstract fun bindTopUsersFragment(): TopUsersFragment
}