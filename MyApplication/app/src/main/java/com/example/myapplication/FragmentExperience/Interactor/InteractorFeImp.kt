package com.example.myapplication.FragmentExperience.Interactor

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import com.example.myapplication.FragmentExperience.Presenter.ListenerFeInterface
import com.example.myapplication.Models.Response.Experience

class InteractorFeImp(private val listener: ListenerFeInterface) :InteractorFeInterface {

    /**
     * Func to extract info of Experience
     */
    override fun getInfoExperience(arguments: Bundle?, keY_OBJECT_EXPERIENCE: String) {
        if(arguments!=null){
            val myList : ArrayList<Experience> =
                arguments.getParcelableArrayList<Experience>(keY_OBJECT_EXPERIENCE) as ArrayList<Experience>
            Log.i(TAG,"Lista con "+myList.size+" Objetos")
            listener.setInfoExperience(myList)
        }
    }
}