package com.example.myapplication.FragmentMain.View

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.FragmentEducation.View.FragmentEducation
import com.example.myapplication.FragmentExperience.View.FragmentExperience
import com.example.myapplication.FragmentMain.Presenter.PresenterFmInterface
import com.example.myapplication.FragmentMain.Presenter.PresenterImpFm
import com.example.myapplication.FragmentProfile.View.FragmentProfile
import com.example.myapplication.Models.Response.Education
import com.example.myapplication.Models.Response.Experience
import com.example.myapplication.Models.Response.Profile
import com.example.myapplication.R
import com.example.myapplication.Utils.Constantes
import com.example.myapplication.Utils.GeneralInterface
import com.example.myapplication.Utils.ProgresDialogApp
import java.lang.Exception


class FragmentMain : Fragment(), MainViewInterface {
    private var myView: View? = null
    private var btnProfile: Button? = null
    private var btnExperience: Button? = null
    private var btnSchool: Button? = null
    private var generalInterface: GeneralInterface? = null
    private var presenter: PresenterFmInterface? = null
    private var progress: ProgresDialogApp? = null

    fun newInstance(): FragmentMain {
        val fragment = FragmentMain()
        val args = Bundle()
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PresenterImpFm(this)
        progress = ProgresDialogApp(activity)
        presenter?.getInfoCv()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.main_fragment, container, false)
        setupViews()
        setupEvents()
        return myView
    }

    private fun setupViews() {
        myView.apply {
            btnProfile = this?.findViewById(R.id.btnProfile_fgtMain)
            btnExperience = this?.findViewById(R.id.btnExperience_fgtMain)
            btnSchool = this?.findViewById(R.id.btnSchool_fgtMain)
        }
    }

    private fun setupEvents() {
        btnProfile?.setOnClickListener { presenter?.gotoProfileFragment() }
        btnExperience?.setOnClickListener { presenter?.gotoExperienceFragment() }
        btnSchool?.setOnClickListener { presenter?.gotoSchoolFragment() }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        generalInterface = context as GeneralInterface
    }

    /**
     * Function to show Progress
     */
    override fun showProgress() {
        try {
            progress?.show()
        } catch (e: Exception) {

        }
    }

    /**
     * Function to hide Progress
     */
    override fun hideProgress() {
        try {
            progress?.dismiss()
        } catch (e: Exception) {
        }
    }

    /**
     * Func to open the Fragment Profile
     */
    override fun startProgressProfile(profile: Profile?) {
        profile?.let { FragmentProfile().newInstance(it) }?.let {
            generalInterface?.addFragment(
                it,
                Constantes.TagsFragments.TAG_FRAGMENT_PROFILE.tag
            )
        }
    }


    /**
     * Func to open FragmentExperience
     */
    override fun startFragmentExperience(list: List<Experience>?) {
        list?.let { FragmentExperience().newIntance(ArrayList(it)) }?.let {
            generalInterface?.addFragment(
                it,
                Constantes.TagsFragments.TAG_FRAGMENT_EXPERIENCE.tag
            )
        }
    }

    /**
     * Func to start Fragment Education
     */
    override fun startFragmentSchool(school: Education?) {
        school?.let { FragmentEducation().newInstance(it) }?.let {
            generalInterface?.addFragment(
                it,
                Constantes.TagsFragments.TAG_FRAGMENT_EXPERIENCE.tag
            )
        }
    }

}
