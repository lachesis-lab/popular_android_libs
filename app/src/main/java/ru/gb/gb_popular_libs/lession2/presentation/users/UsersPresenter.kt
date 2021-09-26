package ru.gb.gb_popular_libs.lession2.presentation.users

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.gb.gb_popular_libs.lession2.data.GitHubUser
import ru.gb.gb_popular_libs.lession2.data.GitHubUserRepo
import ru.gb.gb_popular_libs.lession2.presentation.user.UserScreen

class UsersPresenter(
    private val repository: GitHubUserRepo,
    private val router: Router
) :
    MvpPresenter<UsersView>() {
    val usersCollection: MutableList<GitHubUser> = mutableListOf()
    private lateinit var disposable: Disposable

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getUsers()
    }


    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

    fun getCount(): Int {
        return usersCollection.count()
    }

    fun getUsers() {
        disposable =
            repository
                .getUsers()
                .subscribe({ users ->
                    usersCollection.clear()
                    usersCollection.addAll(users)
                },
                    { e -> println(e.message.toString()) }
                )

    }

    fun getUser(pos: Int): GitHubUser {
        return usersCollection[pos]

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}