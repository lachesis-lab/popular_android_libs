package ru.gb.gb_popular_libs.lession2.data.api

import io.reactivex.Single
import retrofit2.http.GET
import ru.gb.gb_popular_libs.lession2.data.user.GitHubUser

interface GitHubApi {
    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>
}