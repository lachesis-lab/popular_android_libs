package ru.lachesis.imagetransform.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MainScreen: FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        MainFragment.newInstance()

}