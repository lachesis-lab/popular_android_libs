package ru.gb.gb_popular_libs.lession2.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.gb_popular_libs.lession2.App.Navigation.router
import ru.gb.gb_popular_libs.lession2.R
import ru.gb.gb_popular_libs.lession2.data.GitHubUser
import ru.gb.gb_popular_libs.lession2.data.GitHubUserRepoFactory
import ru.gb.gb_popular_libs.lession2.databinding.UsersBinding

class UsersFragment : MvpAppCompatFragment(R.layout.users), UsersView, UsersAdapter.Delegate {
    companion object {
        fun newInstance() = UsersFragment()
    }

    private var viewBinding: UsersBinding? = null

    private val presenter by moxyPresenter {
        UsersPresenter(GitHubUserRepoFactory.create(), router)
    }
    private val usersAdapter by lazy {   UsersAdapter(delegate = this, presenter = presenter)}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = UsersBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding!!.rvUsers.adapter = usersAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onUserClick(user: GitHubUser) {
        presenter.displayUser(user)
    }

    override fun showUsers(users: List<GitHubUser>) {
        presenter.viewState.showUsers(users)
    }
}