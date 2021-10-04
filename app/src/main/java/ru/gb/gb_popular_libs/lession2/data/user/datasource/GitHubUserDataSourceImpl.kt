package ru.gb.gb_popular_libs.lession2.data.user.datasource

import io.reactivex.Single
import ru.gb.gb_popular_libs.lession2.data.api.GitHubApi
import ru.gb.gb_popular_libs.lession2.data.user.GitHubUser

class GitHubUserDataSourceImpl(
    private val gitHubApi: GitHubApi
): GitHubUsersDataSource {
    override fun fetchUsers(): Single<List<GitHubUser>> =
        gitHubApi.fetchUsers()

}