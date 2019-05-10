package com.example.myapplication.FragmentEducation.Interactor

import android.os.Bundle
import com.example.myapplication.FragmentEducation.Presenter.ListenerFsInterface
import com.example.myapplication.Models.Response.Education

class InteractorFsImp(public val listener: ListenerFsInterface) : InteractorFsInterface {


    /**
     * func to get infoSchool
     */
    override fun getInfo(arguments: Bundle?, keY_ARG_School: String) {
        var education = arguments?.getParcelable(keY_ARG_School) as Education
        listener.setdate(education.time)
        listener.setInfo(education.school)
    }



}