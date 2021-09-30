package ru.lachesis.imagetransform.data

import android.content.Context

object RepositoryFactory {
    fun create(context: Context) = RepositoryImpl(context)


}