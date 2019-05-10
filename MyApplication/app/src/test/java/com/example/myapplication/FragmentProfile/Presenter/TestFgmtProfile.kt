package com.example.myapplication.FragmentProfile.Presenter


import android.os.Bundle
import com.example.myapplication.FragmentProfile.View.FragmentProfile
import com.example.myapplication.FragmentProfile.View.ViewProfileInterface
import com.example.myapplication.Models.Response.Profile
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import java.util.ArrayList

import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class TestFgmtProfile {

    private val skills = ArrayList<String>()

    private val profile = Profile("gmail.com", "Android", "Jorge", 22323232, "", skills)

    @Mock
    private val view: ViewProfileInterface? = null

    private var presenter: PresenterFpImp? = null

    @Before
    fun setUp() {
        skills.add("skil1")
        presenter = PresenterFpImp(view!!)
    }

    @Test
    fun checkorCorrectName() {
        presenter.let {  it?.getInfoProfileDone(profile)}
        verify<ViewProfileInterface>(view).setName("Jorge")
    }

}
