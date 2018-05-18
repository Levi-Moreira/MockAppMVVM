package mockapp.com.br.mockappmvvm.users.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.users.data.NetworkState
import mockapp.com.br.mockappmvvm.users.data.UsersRepository
import javax.inject.Inject


class TopUsersViewModel @Inject constructor(val usersRepository: UsersRepository) : ViewModel() {
    fun getUserList(): LiveData<PagedList<User>> {
        val result = usersRepository
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.BUFFER)


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
