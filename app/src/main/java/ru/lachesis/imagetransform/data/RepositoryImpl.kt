package ru.lachesis.imagetransform.data

import android.content.Context
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.core.net.toUri
import io.reactivex.Single
import io.reactivex.SingleObserver
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

class RepositoryImpl(private val context: Context) : Repository {
    override fun convert(image: Image): Single<Image> = Single.just(
        convertImage(image)

    )

    fun convertImage(image: Image): Image {
        val tmpFile = File.createTempFile("tmp", null)

        val out = BufferedOutputStream(FileOutputStream(tmpFile))
        MediaStore.Images.Media
            .getBitmap(context.contentResolver, image.imageUri)
            .compress(Bitmap.CompressFormat.PNG, 10, out)

        return Image(tmpFile.toUri())

    }
}

class convertImage(context: Context, image: Image) : Single<Image>() {
    override fun subscribeActual(observer: SingleObserver<in Image>) {
        TODO("Not yet implemented")
    }
/*
        return Single.just(Glide.with(context)
            .load(image.imageUri)
            .placeholder(R.drawable.ic_launcher_background))


    }
*/
}