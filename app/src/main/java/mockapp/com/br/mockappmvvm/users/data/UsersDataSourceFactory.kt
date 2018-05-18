package mockapp.com.br.mockappmvvm.users.data

import androidx.paging.DataSource
import io.reactivex.subjects.PublishSubject
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.application.data.remote.StackOverflowConfig
import javax.inject.Inject

class UsersDataSourceFactory @Inject constructor(val api: StackOverflowConfig) : DataSource.Factory<Int, User>() {

    var observableEmitter: PublishSubject<UsersDataSource> = PublishSubject.create()

    override fun create(): DataSource<Int, User> {
        val usersDataSource = UsersDataSource(api)
        observableEmitter.onNext(usersDataSource)
        return usersDataSource
    }
}
