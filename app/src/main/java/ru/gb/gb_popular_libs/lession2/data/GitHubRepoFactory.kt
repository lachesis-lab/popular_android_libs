package ru.gb.gb_popular_libs.lession2.data


object GitHubUserRepoFactory {

    fun create(): GitHubUserRepo = GithubUsersRepoImpl()

}