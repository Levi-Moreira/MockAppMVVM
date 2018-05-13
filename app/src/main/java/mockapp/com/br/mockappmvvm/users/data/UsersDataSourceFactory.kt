package mockapp.com.br.mockappmvvm.users.data

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.application.data.remote.StackOverflowConfig
import javax.inject.Inject

class UsersDataSourceFactory @Inject constructor(val api: StackOverflowConfig) : DataSource.Factory<Int, User>() {

    var dataSourceLiveData: MutableLiveData<UsersDataSource> = MutableLiveData()
    override fun create(): DataSource<Int, User> {
        val usersDataSource = UsersDataSource(api)
        dataSourceLiveData.postValue(usersDataSource)
        return usersDataSource
    }
}
