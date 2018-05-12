package mockapp.com.br.mockappmvvm.users.di

import dagger.Module
import dagger.Provides
import mockapp.com.br.mockappmvvm.users.data.UsersRepositoryImpl

@Module
class TopUsersModule {

    @Provides
    fun provideUsersRepository(): UsersRepositoryImpl {
        return UsersRepositoryImpl()
    }


}