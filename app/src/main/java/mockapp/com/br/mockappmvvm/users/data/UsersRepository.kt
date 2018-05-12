package mockapp.com.br.mockappmvvm.users.data

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import io.reactivex.Observable
import mockapp.com.br.mockappmvvm.application.data.entities.User

interface UsersRepository {
    fun getUsers(): Observable<PagedList<User>>
    fun getDataLoadStatus(): LiveData<DataLoadState>
}
