package ru.lachesis.imagetransform

import io.reactivex.Scheduler

interface Schedulers {

    fun main(): Scheduler
    fun background(): Scheduler

}