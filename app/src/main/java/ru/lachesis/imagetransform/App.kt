package ru.lachesis.imagetransform

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class App: Application() {
    companion object Nav {
        private  val cicerone by lazy {
            Cicerone.create()
        }
        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router

    }
}