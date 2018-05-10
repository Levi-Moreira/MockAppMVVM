package mockapp.com.br.mockappmvvm.application.data

class LiveResource<T>(
        val status: LiveResourceStatus,
        val data: T?,
        val message: String?)

enum class LiveResourceStatus {
    ERROR, SUCCESS
}

object Resource {
    fun <T> success(data: T): LiveResource<T> {
        return LiveResource(LiveResourceStatus.SUCCESS, data, null)
    }

    fun <T> error(msg: String, data: T?): LiveResource<T> {
        return LiveResource(LiveResourceStatus.ERROR, data, msg)
    }
}

