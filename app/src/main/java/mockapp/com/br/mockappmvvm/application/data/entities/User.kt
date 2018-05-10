package mockapp.com.br.mockappmvvm.application.data.entities

import com.google.gson.annotations.SerializedName

class User {

    private val id: Long = 0

    @SerializedName("display_name")
    val displayName: String? = null

    @SerializedName("user_id")
    val userId: Int = 0

    val location: String? = null

    @SerializedName("profile_image")
    val profileImage: String? = null
}
