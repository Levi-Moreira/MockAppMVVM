package mockapp.com.br.mockappmvvm.users.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.users.data.DataLoadState
import mockapp.com.br.mockappmvvm.users.data.UsersRepositoryImpl


class TopUsersViewModel : ViewModel() {


    var usersRepository: UsersRepositoryImpl = UsersRepositoryImpl()

    lateinit var usersLiveData: LiveData<PagedList<User>>


    fun getUserList(): LiveData<PagedList<User>> {
        val result = usersRepository
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.BUFFER)


        usersLiveData = LiveDataReactiveStreams.fromPublisher(result)

        return usersLiveData

    }

    fun dataLoadStatus(): LiveData<DataLoadState> {
        return usersRepository.getDataLoadStatus()
    }

}
