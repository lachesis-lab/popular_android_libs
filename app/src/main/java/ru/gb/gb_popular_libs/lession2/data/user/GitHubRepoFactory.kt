package ru.gb.gb_popular_libs.lession2.data

import ru.gb.gb_popular_libs.lession2.data.user.GitHubUserRepo
import ru.gb.gb_popular_libs.lession2.data.user.GithubUsersRepoImpl


object GitHubUserRepoFactory {

    fun create(): GitHubUserRepo = GithubUsersRepoImpl()

}