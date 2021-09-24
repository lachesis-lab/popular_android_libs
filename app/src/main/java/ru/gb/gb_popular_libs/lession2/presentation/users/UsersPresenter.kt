package ru.gb.gb_popular_libs.lession2.presentation.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.gb.gb_popular_libs.lession2.data.GitHubUser
import ru.gb.gb_popular_libs.lession2.data.GitHubUserRepo
import ru.gb.gb_popular_libs.lession2.presentation.user.UserScreen

class UsersPresenter(
    private val repository: GitHubUserRepo,
    private val router: Router
) :
    MvpPresenter<UsersView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repository.getUsers().let { viewState::showUsers }
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

    fun getCount(): Int = repository.getUsers().count()


    fun getUser(pos: Int):GitHubUser =  repository.getUsers()[pos]


}