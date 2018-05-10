package mockapp.com.br.mockappmvvm.application

import android.app.Application
import android.app.Activity
import android.support.v4.app.Fragment
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
    lateinit var supportFragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

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

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return supportFragmentDispatchingAndroidInjector
    }
}
