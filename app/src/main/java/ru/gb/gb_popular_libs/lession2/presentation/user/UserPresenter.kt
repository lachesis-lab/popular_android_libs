package ru.gb.gb_popular_libs.lession2.presentation.user

import moxy.MvpPresenter
import ru.gb.gb_popular_libs.lession2.data.GithubUsersRepoImpl

class UserPresenter(private val login: String,private val repository: GithubUsersRepoImpl): MvpPresenter<UserView>() {
    override fun onFirstViewAttach() {
        getUserByLogin(login)
            ?.let(viewState::showUser)

    }
    fun getUserByLogin(login: String) = repository.getUserByLogin(login)

}