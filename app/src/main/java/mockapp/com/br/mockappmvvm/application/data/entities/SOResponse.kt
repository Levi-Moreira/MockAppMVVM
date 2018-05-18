package mockapp.com.br.mockappmvvm.application.data.entities

import com.google.gson.annotations.SerializedName

class SOResponse<T> {

    var items: List<T> = mutableListOf()
    @SerializedName("has_more")
    var hasMore: Boolean = false
    @SerializedName("quota_max")
    var quotaMax: Int = 0

    @SerializedName("quota_remaining")
    var quotaRemaining: Int = 0
}
