package mockapp.com.br.mockappmvvm.application.di

import dagger.Module
import dagger.Provides
import mockapp.com.br.mockappmvvm.users.data.UsersDataSourceFactory
import mockapp.com.br.mockappmvvm.users.data.UsersRepository
import javax.inject.Singleton


@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideUsersRepository(dataSource: UsersDataSourceFactory): UsersRepository {
        return UsersRepository(dataSource)
    }
}
