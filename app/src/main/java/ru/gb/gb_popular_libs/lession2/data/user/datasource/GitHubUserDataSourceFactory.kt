package ru.gb.gb_popular_libs.lession2.data.user.datasource

import ru.gb.gb_popular_libs.lession2.data.api.GitHubApiFactory

object GitHubUserDataSourceFactory {
    fun create(){
        GitHubUserDataSourceImpl(GitHubApiFactory.create())
    }
}