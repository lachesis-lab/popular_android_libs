package ru.gb.gb_popular_libs.lession2.presentation.user

import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.gb.gb_popular_libs.lession2.data.user.GithubUsersRepoImpl

class UserPresenter(private val login: String,private val repository: GithubUsersRepoImpl): MvpPresenter<UserView>() {

    private lateinit var disposable: Disposable

    override fun onFirstViewAttach() {
        disposable =
        getUserByLogin(login)
            .subscribe(viewState::showUser,{e->println(e.message.toString())})

    }
    fun getUserByLogin(login: String) = repository.getUserByLogin(login)

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}