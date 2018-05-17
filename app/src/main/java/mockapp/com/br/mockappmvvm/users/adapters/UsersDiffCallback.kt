package mockapp.com.br.mockappmvvm.users.adapters

import androidx.recyclerview.widget.DiffUtil
import mockapp.com.br.mockappmvvm.application.data.entities.User


class UsersDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldProduct: User, newProduct: User): Boolean {
        return oldProduct.userId == newProduct.userId
    }

    override fun areContentsTheSame(oldProduct: User, newProduct: User): Boolean {
        return oldProduct.displayName == newProduct.displayName
    }
}
