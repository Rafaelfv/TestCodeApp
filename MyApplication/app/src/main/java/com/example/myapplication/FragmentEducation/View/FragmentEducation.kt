package com.example.myapplication.FragmentEducation.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.FragmentEducation.Presenter.PresenterFsImp
import com.example.myapplication.FragmentEducation.Presenter.PresenterFsInterface
import com.example.myapplication.Models.Response.Education
import com.example.myapplication.R

class FragmentEducation : Fragment(),EducationView {

    private val KEY_ARG_School = "KEY_SHOOL"
    private var myView : View ? = null

    private var presenter : PresenterFsInterface ? = null
    private var title:TextView ? = null
    private var date:TextView ? = null

    fun newInstance(school:Education): FragmentEducation{

        val fragment = FragmentEducation()
        val args = Bundle()
        args.putParcelable(KEY_ARG_School,school)
        fragment.arguments = args
        //fragment.setArguments(args)
        return fragment

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PresenterFsImp(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_school,container,false)
        setupViews()
        presenter?.getInfo(arguments,KEY_ARG_School)

        return myView
    }

    private fun setupViews() {
        myView.apply {
            title = this?.findViewById(R.id.tvInfoSchool)
            date = this?.findViewById(R.id.dateSchool)
        }
    }

    override fun setinfoSchool(school: String) {
        title?.text = school
    }


    override fun setDate(time: String) {
        date?.text = time
    }
}