package mockapp.com.br.mockappmvvm.users.data

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.application.data.remote.StackOverflowConfig
import javax.inject.Inject

class UsersDataSource @Inject constructor(private val soApi: StackOverflowConfig) : PageKeyedDataSource<Int, User>() {


    var loadState: MutableLiveData<NetworkState> = MutableLiveData()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        loadState.postValue(NetworkState.LOADING)
        val disposable = soApi.apiService.getTopUsers(1, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.items, 1, 2)
                    loadState.postValue(NetworkState.LOADED)
                }, {
                    loadState.postValue(NetworkState.error(it.message))
                })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        loadState.postValue(NetworkState.LOADING)
        val disposable = soApi.apiService.getTopUsers(params.key, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val previousKey = if (params.key > 1) params.key - 1 else null
                    callback.onResult(it.items, previousKey)
                    loadState.postValue(NetworkState.LOADED)
                }, {
                    loadState.postValue(NetworkState.error(it.message))
                })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        loadState.postValue(NetworkState.LOADING)
        val disposable = soApi.apiService.getTopUsers(params.key, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.items, params.key + 1)
                    loadState.postValue(NetworkState.LOADED)
                }, {
                    loadState.postValue(NetworkState.error(it.message))
                })
    }


    companion object {
        const val SO_PAGE_SIZE = 20
    }
}


