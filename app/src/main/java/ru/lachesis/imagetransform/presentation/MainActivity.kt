package ru.lachesis.imagetransform.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.lachesis.imagetransform.App
import ru.lachesis.imagetransform.App.Nav.navigatorHolder
import ru.lachesis.imagetransform.App.Nav.router
import ru.lachesis.imagetransform.R

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(MainScreen())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }


}