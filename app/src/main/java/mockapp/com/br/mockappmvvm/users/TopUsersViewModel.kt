package mockapp.com.br.mockappmvvm.users

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mockapp.com.br.mockappmvvm.application.data.LiveResource
import mockapp.com.br.mockappmvvm.application.data.Resource
import mockapp.com.br.mockappmvvm.application.data.entities.User


class TopUsersViewModel : ViewModel() {


    var usersRepository: UsersRepository = UsersRepository()

    lateinit var usersLiveData: LiveData<LiveResource<List<User>>>


    fun getUserList(pageSize: Int): LiveData<LiveResource<List<User>>> {
        val result = usersRepository
                .getUsers(pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { result ->
                    Resource.success(result.items)
                }.toFlowable()


        usersLiveData = LiveDataReactiveStreams.fromPublisher(result)

        return usersLiveData


    }

}
