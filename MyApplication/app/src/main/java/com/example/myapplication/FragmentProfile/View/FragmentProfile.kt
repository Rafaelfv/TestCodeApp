package com.example.myapplication.FragmentProfile.View

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.FragmentProfile.Presenter.PresenterFpImp
import com.example.myapplication.FragmentProfile.Presenter.PresenterFpInterface
import com.example.myapplication.Models.Response.Profile
import com.example.myapplication.R
import com.example.myapplication.Utils.GeneralInterface

class FragmentProfile : Fragment(), ViewProfileInterface {

    private val keyArgProfile = "KEY_PROFILE"
    private var myView: View? = null
    private var generalInterface: GeneralInterface? = null

    //private var photo: ImageView? = null
    private var tvNombre: TextView? = null
    private var tvNumber: TextView? = null
    private var tvEmail: TextView? = null
    private var tvJob: TextView? = null

    var presenter: PresenterFpInterface? = null

    fun newInstance(profile: Profile): FragmentProfile {
        val fragment = FragmentProfile()
        val args = Bundle()
        args.putParcelable(keyArgProfile, profile)
        fragment.arguments = args
        //fragment.setArguments(args)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PresenterFpImp(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_profile, container, false)
        // Todo implement a url from image photo to show in ImageView, set Visible Imageview
        setupViews()
        presenter?.getInfoProfile(arguments, keyArgProfile)

        return myView
    }

    private fun setupViews() {
        myView?.apply {
            tvNombre = this.findViewById(R.id.tvName_fp)
            tvEmail = this.findViewById(R.id.tvEmail_fp)
            tvJob = this.findViewById(R.id.tvJob_fp)
            tvNumber = this.findViewById(R.id.tvNumber_fp)
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        generalInterface = context as GeneralInterface
    }

    override fun setName(name: String) {
        tvNombre?.text = name
    }

    override fun setNuumber(number: String) {
        tvNumber?.text = number
    }

    override fun setJob(job: String) {
        tvJob?.text = job
    }

    override fun setEmail(email: String) {
        tvEmail?.text = email
    }

}