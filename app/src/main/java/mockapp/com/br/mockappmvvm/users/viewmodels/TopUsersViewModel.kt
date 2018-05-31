package mockapp.com.br.mockappmvvm.users.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import io.reactivex.BackpressureStrategy
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mockapp.com.br.mockappmvvm.application.data.LiveResource
import mockapp.com.br.mockappmvvm.application.data.LiveResourceStatus
import mockapp.com.br.mockappmvvm.application.data.entities.SOResponse
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.users.data.NetworkState
import mockapp.com.br.mockappmvvm.users.data.UsersRepository
import java.util.*
import javax.inject.Inject


class TopUsersViewModel @Inject constructor(val usersRepository: UsersRepository) : ViewModel() {

    var userList: MutableLiveData<LiveResource<SOResponse<User>>> = MutableLiveData()

    fun getUserList(): LiveData<PagedList<User>> {
        val result = usersRepository
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.BUFFER)


        return LiveDataReactiveStreams.fromPublisher(result)

    }

    fun getUserListNotPaged(page: Int, pageSize: Int): LiveData<SOResponse<User>> {
        val result = usersRepository
                .getUsersNotPaged(page, pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn {
                   SOResponse<User>()
                }
                .toFlowable()

        return LiveDataReactiveStreams.fromPublisher(result)
    }

    fun dataLoadStatus(): LiveData<NetworkState> {
        val result = usersRepository.getDataLoadStatus()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.BUFFER)

        return LiveDataReactiveStreams.fromPublisher(result)

    }

}
