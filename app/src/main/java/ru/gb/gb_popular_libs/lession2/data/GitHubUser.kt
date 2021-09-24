package ru.gb.gb_popular_libs.lession2.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUser(
    val login: String
) : Parcelable