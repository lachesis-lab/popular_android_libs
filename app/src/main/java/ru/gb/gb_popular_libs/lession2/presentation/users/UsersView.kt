package ru.gb.gb_popular_libs.lession2.presentation.users

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.gb.gb_popular_libs.lession2.data.GitHubUser

interface UsersView: MvpView     {
    @SingleState
    fun showUsers(users: List<GitHubUser>)

}