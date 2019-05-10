package com.example.myapplication.FragmentProfile.Presenter

import android.os.Bundle
import com.example.myapplication.FragmentProfile.Interactor.InteractorFpImp
import com.example.myapplication.FragmentProfile.Interactor.InteractorFpInterface
import com.example.myapplication.FragmentProfile.View.FragmentProfile
import com.example.myapplication.FragmentProfile.View.ViewProfileInterface
import com.example.myapplication.Models.Response.Profile

class PresenterFpImp(fragmentProfile: ViewProfileInterface) : PresenterFpInterface,ListenerFpInterface {

    var view:ViewProfileInterface? = fragmentProfile
    var interactor:InteractorFpInterface ? = InteractorFpImp(this)


    override fun getInfoProfile(arguments: Bundle?, keY_ARG_PROFILE: String) {
        interactor?.getInfoProfile(arguments,keY_ARG_PROFILE)
    }

    override fun getInfoProfileDone(profile: Profile) {
        interactor?.getInfoProfileDone(profile)
    }

    override fun setName(name: String) {
        view.let { it?.setName(name) }
    }

    override fun setJob(job: String) {
        view.let { it?.setJob(job) }
    }

    override fun setNumber(number: Long) {
        view.let { it?.setNuumber(number.toString()) }
    }

    override fun setEmail(email: String) {
        view.let { it?.setEmail(email) }
    }
}