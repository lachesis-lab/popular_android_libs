package ru.lachesis.imagetransform.presentation

import android.content.Intent
import android.os.VibrationEffect
import androidx.core.app.ActivityCompat.startActivityForResult
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.lachesis.imagetransform.Schedulers
import ru.lachesis.imagetransform.data.Image
import ru.lachesis.imagetransform.data.Repository


class MainPresenter(
    private val repository: Repository,
    private val schedulers: Schedulers
) : MvpPresenter<MainView>() {

    val compositeDisposable = CompositeDisposable()

    fun convert(image: Image) {
        compositeDisposable += (
                repository.convert(image)
                    .observeOn(schedulers.main())
                    .subscribeOn(schedulers.background())
                    .subscribe()
                )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
/*
    fun showError(){
        val tmp =0

    }
    fun showLoading(){
        val tmp =0

    }
*/

}