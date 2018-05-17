package mockapp.com.br.mockappmvvm.application

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import mockapp.com.br.mockappmvvm.application.di.DaggerApplicationComponent
import javax.inject.Inject


class MockApplication : Application(), HasSupportFragmentInjector {
    override fun onCreate() {
        super.onCreate()
        initDagger();
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var supportFragmentDispatchingAndroidInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>

    fun initDagger() {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<androidx.fragment.app.Fragment> {
        return supportFragmentDispatchingAndroidInjector
    }
}
