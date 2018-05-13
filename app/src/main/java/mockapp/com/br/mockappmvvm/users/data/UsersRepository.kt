package mockapp.com.br.mockappmvvm.users.data

import android.arch.paging.PagedList
import android.arch.paging.RxPagedListBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.users.data.UsersDataSource.Companion.SO_PAGE_SIZE
import android.arch.lifecycle.Transformations.switchMap
import android.arch.lifecycle.LiveData
import javax.inject.Inject


class UsersRepository @Inject constructor(var dataSourceFactory: UsersDataSourceFactory) {


    fun getUsers(): Observable<PagedList<User>> {
        val config = PagedList.Config.Builder()
                .setInitialLoadSizeHint(SO_PAGE_SIZE)
                .setPageSize(SO_PAGE_SIZE)
                .build()

        val users = RxPagedListBuilder(dataSourceFactory, config)
                .setInitialLoadKey(1)
                .setFetchScheduler(Schedulers.io())
                .setNotifyScheduler(AndroidSchedulers.mainThread())
                .buildObservable()

        return users

    }

    fun getDataLoadStatus(): LiveData<NetworkState> {
        return switchMap(dataSourceFactory.dataSourceLiveData
        ) { dataSource -> dataSource.loadState }
    }
}