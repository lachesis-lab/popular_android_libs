package ru.lachesis.imagetransform.data

import android.net.Uri
import io.reactivex.Single

interface Convertation {
    fun convert(uri: Uri): Single<Uri>
}