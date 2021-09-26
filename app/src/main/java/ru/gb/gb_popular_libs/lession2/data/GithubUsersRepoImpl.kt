package ru.gb.gb_popular_libs.lession2.data

import io.reactivex.rxjava3.core.Single

class GithubUsersRepoImpl: GitHubUserRepo {
    private val repositories = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5")
    )

    override fun getUsers(): Single<List<GitHubUser>> = Single.just(repositories)

    override fun getUserByLogin(userId: String): Single<GitHubUser> =
        Single.just(repositories.firstOrNull { user-> user.login == userId })

}