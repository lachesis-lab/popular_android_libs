package ru.gb.gb_popular_libs.lession2.presentation.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.gb_popular_libs.lession2.R
import ru.gb.gb_popular_libs.lession2.data.user.GitHubUser
import ru.gb.gb_popular_libs.lession2.data.user.GithubUsersRepoImpl
import ru.gb.gb_popular_libs.lession2.databinding.UserBinding


class UserFragment : MvpAppCompatFragment(R.layout.user), UserView {

    private var viewBinding: UserBinding? = null
    private val presenter: UserPresenter?  by moxyPresenter { UserPresenter(userLogin,
        GithubUsersRepoImpl()
    ) }
    private val userLogin: String by lazy {
        arguments?.getString(USER_LOGIN).orEmpty()
    }

    companion object {
        private const val USER_LOGIN = "arg_user_login"
        fun newInstance(userId: String): Fragment {
            val args = Bundle()
            args.putString(USER_LOGIN, userId)
            return UserFragment().also { it.arguments = args }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = UserBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }


    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }

    override fun showUser(user: GitHubUser) {
        viewBinding!!.userLogin.text = user.login
    }


}