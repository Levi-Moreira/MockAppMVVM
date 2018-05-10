package mockapp.com.br.mockappmvvm.application.data.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class StackOverflowConfig {

    companion object {
        const val SERVER_BASE_URL = "https://api.stackexchange.com"
    }

    var serviceCreator: Retrofit

    var apiService : StackOverflowAPI

    init {
        serviceCreator = Retrofit.Builder()
                .baseUrl(SERVER_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiService = serviceCreator.create(StackOverflowAPI::class.java)
    }
}
