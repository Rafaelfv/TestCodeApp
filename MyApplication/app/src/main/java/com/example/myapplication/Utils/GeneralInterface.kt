package com.example.myapplication.Utils

import android.support.v4.app.Fragment

interface GeneralInterface {
    fun addFragment(fragment: Fragment, tag: String)
    fun setFragment(fragment: Fragment, tag: String)
    fun onBackAction()
    fun removeFragment(fragment: Fragment, tag: String)


}
