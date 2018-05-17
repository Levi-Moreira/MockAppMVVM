package mockapp.com.br.mockappmvvm.users.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mockapp.com.br.mockappmvvm.application.di.ViewModelKey
import mockapp.com.br.mockappmvvm.users.viewmodels.TopUsersViewModel

@Module
abstract class TopUsersModule {

    @Binds
    @IntoMap
    @ViewModelKey(TopUsersViewModel::class)
    abstract fun bindsMainViewModel(usersViewModel: TopUsersViewModel): ViewModel


}