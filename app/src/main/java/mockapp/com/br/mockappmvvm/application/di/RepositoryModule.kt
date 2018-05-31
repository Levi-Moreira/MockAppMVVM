package mockapp.com.br.mockappmvvm.application.di

import dagger.Module
import dagger.Provides
import mockapp.com.br.mockappmvvm.application.data.remote.StackOverflowConfig
import mockapp.com.br.mockappmvvm.users.data.UsersDataSourceFactory
import mockapp.com.br.mockappmvvm.users.data.UsersRepository
import javax.inject.Singleton


@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideUsersRepository(dataSource: UsersDataSourceFactory, apiConfig: StackOverflowConfig): UsersRepository {
        return UsersRepository(dataSource, apiConfig)
    }
}
