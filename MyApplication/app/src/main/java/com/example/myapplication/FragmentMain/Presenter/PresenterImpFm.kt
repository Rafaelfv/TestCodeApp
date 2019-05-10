package com.example.myapplication.FragmentMain.Presenter

import com.example.myapplication.FragmentMain.Interactor.InteractorFmImp
import com.example.myapplication.FragmentMain.Interactor.InteractorFmInterface
import com.example.myapplication.FragmentMain.View.FragmentMain
import com.example.myapplication.Models.Response.Education
import com.example.myapplication.Models.Response.Experience
import com.example.myapplication.Models.Response.Profile

class PresenterImpFm (val view: FragmentMain) : ListenerFmInterface,PresenterFmInterface {

    val interactor: InteractorFmInterface = InteractorFmImp(this)

    override fun getInfoCv() {
        interactor.getInfoCv()
    }

    /**
     * Function to show loader in screen
     */
    override fun showProgress() {
            view.showProgress()
    }

    /**
     * Function to hide progress
     */
    override fun hideProgress() {
        view.hideProgress()
    }

    override fun gotoProfileFragment() {
        interactor.gotoProfileFragment()
    }

    override fun startFragmentProfile(profile: Profile?) {
        view.startProgressProfile(profile)
    }

    override fun gotoExperienceFragment() {
        interactor.gotoExperienceFragment()
    }

    override fun startFragmentExperience(list: List<Experience>?) {
        view.startFragmentExperience(list)
    }

    override fun gotoSchoolFragment() {
        interactor.gotoSchoolFragment()
    }

    override fun startFragmentSchool(it: Education?) {
        view.startFragmentSchool(it)
    }
}