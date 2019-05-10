package com.example.myapplication.FragmentMain.Presenter

import com.example.myapplication.Models.Response.Education
import com.example.myapplication.Models.Response.Experience
import com.example.myapplication.Models.Response.Profile

interface ListenerFmInterface {
    fun showProgress()
    fun hideProgress()
    fun startFragmentProfile(profile: Profile?)
    fun startFragmentExperience(list: List<Experience>?)
    abstract fun startFragmentSchool(it: Education?)
}