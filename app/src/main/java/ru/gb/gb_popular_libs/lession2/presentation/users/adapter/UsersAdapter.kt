package ru.gb.gb_popular_libs.lession2.presentation.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gb.gb_popular_libs.lession2.R
import ru.gb.gb_popular_libs.lession2.data.GitHubUser
import ru.gb.gb_popular_libs.lession2.databinding.UserBinding

class UsersAdapter(
    private val delegate: Delegate?,
    private val presenter: UsersPresenter
) :
    RecyclerView.Adapter<UserViewHolder>() {

    interface Delegate {
        fun onUserClick(user: GitHubUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {


        holder.bind(presenter.getUser(position), delegate!!)
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }


}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var viewBinding: UserBinding = UserBinding.bind(itemView)

    fun bind(user: GitHubUser, delegate: UsersAdapter.Delegate) {
        with(viewBinding) {
            userLogin.text = user.login
            root.setOnClickListener { delegate.onUserClick(user) }
        }
    }

}
