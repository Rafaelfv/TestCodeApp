package com.example.myapplication.FragmentMain.View

import com.example.myapplication.Models.Response.Education
import com.example.myapplication.Models.Response.Experience
import com.example.myapplication.Models.Response.Profile

interface MainViewInterface {

    fun showProgress()
    fun hideProgress()
    fun startProgressProfile(profile: Profile?)
    fun startFragmentExperience(list: List<Experience>?)
    fun startFragmentSchool(school: Education?)
}