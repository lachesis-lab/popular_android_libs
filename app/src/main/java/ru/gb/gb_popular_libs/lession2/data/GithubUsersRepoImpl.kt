package ru.gb.gb_popular_libs.lession2.data

class GithubUsersRepoImpl: GitHubUserRepo {
    private val repositories = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5")
    )

    override fun getUsers(): List<GitHubUser> = repositories

    override fun getUserByLogin(userId: String): GitHubUser? =
        repositories.firstOrNull { user-> user.login == userId }

}