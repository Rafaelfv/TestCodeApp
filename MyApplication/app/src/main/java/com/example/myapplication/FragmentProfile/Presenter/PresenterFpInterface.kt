package com.example.myapplication.FragmentProfile.Presenter

import android.os.Bundle
import com.example.myapplication.Models.Response.Profile

interface PresenterFpInterface {
    fun getInfoProfile(arguments: Bundle?, keY_ARG_PROFILE: String)
    fun getInfoProfileDone(profile: Profile)
}