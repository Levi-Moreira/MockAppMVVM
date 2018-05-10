package mockapp.com.br.mockappmvvm.users

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides

@Module
class TopUsersModule {

    @Provides
    fun provideUsersRepository(): UsersRepository {
        return UsersRepository()
    }


}