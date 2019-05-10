package com.example.myapplication.FragmentMain.Interactor

import com.example.myapplication.FragmentMain.Presenter.ListenerFmInterface

import com.example.myapplication.Models.Response.Experience
import com.example.myapplication.Models.Response.Info
import com.example.myapplication.Models.Response.ResponseInfoCv
import com.example.myapplication.Network.RetrofitClient
import com.example.myapplication.Network.WScv
import com.example.myapplication.R
import com.example.myapplication.Utils.Constantes
import com.example.myapplication.Utils.MainClass
import com.example.myapplication.Utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class InteractorFmImp (val listener: ListenerFmInterface): InteractorFmInterface {
    var infoCv:Info? = null

    /**
     * Function to get information of Cv
     */
    override fun getInfoCv() {
        //Log.d(TAG,"GetInfoCv in Interactor")
        this.listener.showProgress()
        RetrofitClient.instance.retrofit.create(WScv::class.java).infoCv.enqueue(object:Callback<ResponseInfoCv>{
            override fun onFailure(call: Call<ResponseInfoCv>?, t: Throwable?) {
                listener.hideProgress()
            }
            override fun onResponse(call: Call<ResponseInfoCv>?, response: Response<ResponseInfoCv>?) {
                listener.hideProgress()
                if (response != null) {
                    if(response.isSuccessful){
                        if (response.code() == Constantes.Values.HTTP_STATUS_OK.type){
                            infoCv = response.body().info
                        }else{
                            MainClass().getAppContext()?.let { Utils().showToast(it,it.getString(R.string.CodeErrorResponseStatus)) }
                        }
                    }else{
                        MainClass().getAppContext()?.let { Utils().showToast(it,it.getString(R.string.CodeErrorResponseStatus)) }
                    }
                }else{
                    MainClass().getAppContext()?.let { Utils().showToast(it,it.getString(R.string.CodeErrorResponseNull)) }
                }
            }

        })

    }

    /**
     * Function to get list Experience and open Fragment experience
     */
    override fun gotoExperienceFragment() {
        val myList : List<Experience>? = infoCv?.Experience
        myList.let { listener.startFragmentExperience(it) }
    }
    /**
     * Function to get ObjectProfile and open Fragment Profile
     */
    override fun gotoProfileFragment() {
        val profile = infoCv?.profile
        profile.let { listener.startFragmentProfile(it) }

    }

    override fun gotoSchoolFragment() {
        val school = infoCv?.Education?.get(0)
        school.let { listener.startFragmentSchool(it) }

    }
}