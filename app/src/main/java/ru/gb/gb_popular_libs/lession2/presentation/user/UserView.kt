package ru.gb.gb_popular_libs.lession2.presentation.user

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.gb.gb_popular_libs.lession2.data.user.GitHubUser

interface UserView: MvpView {
 @SingleState
 fun showUser(user: GitHubUser)
}