package ru.gb.gb_popular_libs.lession2.data

interface GitHubUserRepo {
    fun getUsers(): List<GitHubUser>

    fun getUserByLogin(userId: String): GitHubUser?
}