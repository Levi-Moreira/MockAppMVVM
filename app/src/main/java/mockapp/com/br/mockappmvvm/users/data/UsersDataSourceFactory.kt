package mockapp.com.br.mockappmvvm.users.data

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.application.data.remote.StackOverflowConfig

class UsersDataSourceFactory : DataSource.Factory<Int, User>() {

    var dataSourceSingle: MutableLiveData<UsersDataSource> = MutableLiveData()
    override fun create(): DataSource<Int, User> {
        val usersDataSource = UsersDataSource(StackOverflowConfig())
        dataSourceSingle.postValue(usersDataSource)
        return usersDataSource
    }
}
