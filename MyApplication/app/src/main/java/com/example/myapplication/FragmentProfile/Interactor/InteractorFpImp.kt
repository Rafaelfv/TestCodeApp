package com.example.myapplication.FragmentProfile.Interactor

import android.os.Bundle
import com.example.myapplication.FragmentProfile.Presenter.ListenerFpInterface
import com.example.myapplication.Models.Response.Profile
import com.example.myapplication.R
import com.example.myapplication.Utils.MainClass
import com.example.myapplication.Utils.Utils

class InteractorFpImp(private val listener: ListenerFpInterface) : InteractorFpInterface {


    override fun getInfoProfile(arguments: Bundle?, keY_ARG_PROFILE: String) {
        if (arguments != null) {
            val profile: Profile = arguments.getParcelable(keY_ARG_PROFILE) as Profile

            listener.setName(profile.name)
            listener.setEmail(profile.email)
            listener.setNumber(profile.number)
            listener.setJob(profile.job)


        } else {
            MainClass().getAppContext()?.getString(R.string.WithOutData)?.let {
                MainClass().getAppContext()?.let { it1 ->
                    Utils().showToast(
                        it1,
                        it
                    )
                }
            }
        }

    }

    override fun getInfoProfileDone(profile: Profile) {
        profile.let {
            listener.setName(profile.name)
            listener.setEmail(profile.email)
            listener.setNumber(profile.number)
            listener.setJob(profile.job)
        }
    }

}