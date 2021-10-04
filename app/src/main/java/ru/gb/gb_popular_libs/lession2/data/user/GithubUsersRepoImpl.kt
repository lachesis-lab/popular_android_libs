package ru.gb.gb_popular_libs.lession2.data.user

import io.reactivex.Maybe
import io.reactivex.Single
import ru.gb.gb_popular_libs.lession2.data.user.datasource.GitHubUsersDataSource

class GithubUsersRepoImpl(
    private val gitHubUsersDataSource : GitHubUsersDataSource

): GitHubUserRepo {

    override fun getUsers(): Single<List<GitHubUser>> = gitHubUsersDataSource.fetchUsers()
        .map {users-> users.map{it.copy(login=it.login.toLowerCase())}}

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubUsersDataSource
            .fetchUsers()
            .flatMapMaybe {users-> users.firstOrNull { user-> user.login.contentEquals(userId,true) }  }
            ?.

}