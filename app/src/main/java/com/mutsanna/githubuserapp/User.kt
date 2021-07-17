package com.mutsanna.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
        val photo: Int,
        val name: String?,
        val username: String?,
        val followers: String?,
        val following: String?,
        val location: String?,
        val company: String?,
        val repo: String?
        ) : Parcelable