package mockapp.com.br.mockappmvvm.users.data

import androidx.paging.PageKeyedDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.application.data.remote.StackOverflowConfig
import javax.inject.Inject

class UsersDataSource @Inject constructor(private val soApi: StackOverflowConfig) : PageKeyedDataSource<Int, User>() {


    var loadState: PublishSubject<NetworkState> = PublishSubject.create()

    var disposables: CompositeDisposable = CompositeDisposable()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        loadState.onNext(NetworkState.LOADING)
        val disposable = soApi.apiService.getTopUsers(1, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.items, 1, 2)
                    loadState.onNext(NetworkState.LOADED)
                }, {
                    loadState.onNext(NetworkState.error(it.message))
                })

        disposables.add(disposable)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        loadState.onNext(NetworkState.LOADED)

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        loadState.onNext(NetworkState.LOADING)
        val disposable = soApi.apiService.getTopUsers(params.key, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.items, params.key + 1)
                    loadState.onNext(NetworkState.LOADED)
                }, {
                    loadState.onNext(NetworkState.error(it.message))
                })
        disposables.add(disposable)
    }

    override fun invalidate() {
        super.invalidate()
        disposables.dispose()

    }

    companion object {
        const val SO_PAGE_SIZE = 20
    }
}


