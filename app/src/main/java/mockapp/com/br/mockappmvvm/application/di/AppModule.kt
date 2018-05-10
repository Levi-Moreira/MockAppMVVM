package mockapp.com.br.mockappmvvm.application.di

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import mockapp.com.br.mockappmvvm.application.data.remote.StackOverflowConfig

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesBackend(): StackOverflowConfig = StackOverflowConfig()

    fun provideCompositeSubscription(): CompositeDisposable = CompositeDisposable()

}