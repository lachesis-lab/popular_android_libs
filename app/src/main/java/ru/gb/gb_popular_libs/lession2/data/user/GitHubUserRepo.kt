package ru.gb.gb_popular_libs.lession2.data.user

import io.reactivex.Maybe
import io.reactivex.Single
import ru.gb.gb_popular_libs.lession2.data.user.GitHubUser

interface GitHubUserRepo  {
    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>
}