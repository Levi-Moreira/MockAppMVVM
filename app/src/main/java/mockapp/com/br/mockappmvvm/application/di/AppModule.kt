package mockapp.com.br.mockappmvvm.application.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import mockapp.com.br.mockappmvvm.application.data.remote.StackOverflowConfig
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesBackend(): StackOverflowConfig = StackOverflowConfig()

    fun provideCompositeSubscription(): CompositeDisposable = CompositeDisposable()

}