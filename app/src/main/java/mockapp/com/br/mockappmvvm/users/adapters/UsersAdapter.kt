package mockapp.com.br.mockappmvvm.users.adapters

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_list_item.view.*
import mockapp.com.br.mockappmvvm.R
import mockapp.com.br.mockappmvvm.application.data.entities.User
import mockapp.com.br.mockappmvvm.glideUrl
import mockapp.com.br.mockappmvvm.inflate

class UsersAdapter : PagedListAdapter<User, UsersAdapter.UsersViewHolder>(UsersDiffCallback()) {

    lateinit var clickListener: (User) -> (Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder = UsersViewHolder(parent.inflate(R.layout.user_list_item))

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        val user: User? = getItem(position)

        user?.let {
            holder.bind(user, this.clickListener)
        }
    }

    inner class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: User, listener: (User) -> Unit) = with(itemView) {
            displayName.text = item.displayName
            userId.text = item.userId.toString()
            location.text = item.location
            userImage.glideUrl(item.profileImage.toString())
            setOnClickListener { listener(item) }
        }
    }
}

