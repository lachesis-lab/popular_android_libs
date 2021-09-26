package ru.gb.gb_popular_libs.lession2.data

import io.reactivex.rxjava3.core.Single

interface GitHubUserRepo  {
    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Single<GitHubUser>
}