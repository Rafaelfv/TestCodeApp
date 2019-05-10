package com.example.myapplication.FragmentProfile.Interactor

import android.os.Bundle
import com.example.myapplication.Models.Response.Profile

interface InteractorFpInterface {
    fun getInfoProfile(arguments: Bundle?, keY_ARG_PROFILE: String)
    fun getInfoProfileDone(profile: Profile)
}