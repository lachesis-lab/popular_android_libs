package ru.gb.gb_popular_libs.lession2

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class App: Application() {
    companion object Navigation {
        private  val cicerone by lazy {
            Cicerone.create()
        }
        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router

    }
}