package ru.lachesis.imagetransform

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class SchedulersImpl: Schedulers {
    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun background(): Scheduler = io.reactivex.schedulers.Schedulers.newThread()
}