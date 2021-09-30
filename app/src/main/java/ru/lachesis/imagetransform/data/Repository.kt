package ru.lachesis.imagetransform.data

import android.net.Uri
import io.reactivex.Single

interface Repository {
    fun convert(image: Image): Single<Image>

}