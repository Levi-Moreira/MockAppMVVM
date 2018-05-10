package mockapp.com.br.mockappmvvm.users

import io.reactivex.Single
import mockapp.com.br.mockappmvvm.application.data.entities.SOResponse
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.application.data.remote.StackOverflowConfig

class UsersRepository {
    var remoteDataSource: StackOverflowConfig = StackOverflowConfig()

    fun getUsers(pageSize: Int): Single<SOResponse<User>> = remoteDataSource.apiService.getTopUsers(pageSize)
}