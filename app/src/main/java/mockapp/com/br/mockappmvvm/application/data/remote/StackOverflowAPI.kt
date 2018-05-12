package mockapp.com.br.mockappmvvm.application.data.remote

import io.reactivex.Single
import mockapp.com.br.mockappmvvm.application.data.entities.SOResponse
import mockapp.com.br.mockappmvvm.application.data.entities.User
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface StackOverflowAPI {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("/2.2/users")
    fun getTopUsers(
            @Query("page") page: Int,
            @Query("pagesize") pagesize: Int,
            @Query("order") order: String = "desc",
            @Query("sort") sort: String = "reputation",
            @Query("site") site: String = "stackoverflow"

    ): Single<SOResponse<User>>

}
