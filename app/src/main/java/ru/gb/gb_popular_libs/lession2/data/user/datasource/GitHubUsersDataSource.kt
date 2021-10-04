package ru.gb.gb_popular_libs.lession2.data.user.datasource

import io.reactivex.Single
import ru.gb.gb_popular_libs.lession2.data.user.GitHubUser

interface GitHubUsersDataSource {
    fun fetchUsers(): Single<List<GitHubUser>>
}