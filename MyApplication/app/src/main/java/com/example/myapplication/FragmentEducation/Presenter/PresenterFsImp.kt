package com.example.myapplication.FragmentEducation.Presenter

import android.os.Bundle
import com.example.myapplication.FragmentEducation.Interactor.InteractorFsImp
import com.example.myapplication.FragmentEducation.Interactor.InteractorFsInterface
import com.example.myapplication.FragmentEducation.View.FragmentEducation
import com.example.myapplication.Models.Response.Education

class PresenterFsImp(private val view: FragmentEducation) : ListenerFsInterface, PresenterFsInterface {

    var interactor : InteractorFsInterface ? = InteractorFsImp(this)

    override fun getInfo(arguments: Bundle?, keY_ARG_School: String) {
        interactor?.getInfo(arguments,keY_ARG_School)
    }

    override fun setdate(time: String) {
        view.setDate(time)
    }

    override fun setInfo(school: String) {
        view.setinfoSchool(school)
    }

}