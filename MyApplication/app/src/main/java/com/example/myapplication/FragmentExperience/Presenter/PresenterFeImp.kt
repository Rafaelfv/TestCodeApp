package com.example.myapplication.FragmentExperience.Presenter

import android.os.Bundle
import com.example.myapplication.FragmentExperience.Interactor.InteractorFeImp
import com.example.myapplication.FragmentExperience.Interactor.InteractorFeInterface
import com.example.myapplication.FragmentExperience.View.FragmentExperience
import com.example.myapplication.Models.Response.Experience

class PresenterFeImp(fragmentExperience: FragmentExperience) : ListenerFeInterface,PresenterFeInterface {
    var view: FragmentExperience ? = fragmentExperience
    var interactor : InteractorFeInterface  = InteractorFeImp(this)


    override fun getInfoExperience(arguments: Bundle?, keY_OBJECT_EXPERIENCE: String) {
        interactor.getInfoExperience(arguments,keY_OBJECT_EXPERIENCE)
    }

    override fun setInfoExperience(myList: ArrayList<Experience>) {
        view.let { it?.setInfoExperience(myList) }
    }

}