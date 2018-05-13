package mockapp.com.br.mockappmvvm.users.data


data class NetworkState private constructor(val status: Status,
                                            val msg: String? = null) {

    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.RUNNING)
        fun error(msg: String?) = NetworkState(Status.FAILED, msg)
    }
}

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}