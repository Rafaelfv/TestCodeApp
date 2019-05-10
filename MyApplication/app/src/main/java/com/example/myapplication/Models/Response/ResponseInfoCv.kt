package com.example.myapplication.Models.Response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class ResponseInfoCv (
    val code: Int,
    val description: String,
    val info: Info
):Parcelable

@Parcelize
data class Info(
    val Education: List<Education>,
    val Experience: List<Experience>,
    val profile: Profile
):Parcelable

@Parcelize
data class Education(
    val school: String,
    val time: String
):Parcelable

@Parcelize
data class Experience(
    val content: String,
    val title: String
):Parcelable

@Parcelize
data class Profile (
    //@field:SerializedName("username")
    val email: String,
    val job: String,
    val name: String,
    val number: Long,
    val photo: String,
    val skills: List<String>
): Parcelable