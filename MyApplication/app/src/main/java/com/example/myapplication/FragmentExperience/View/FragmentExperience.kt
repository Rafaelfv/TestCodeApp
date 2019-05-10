package com.example.myapplication.FragmentExperience.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.FragmentExperience.Presenter.PresenterFeImp
import com.example.myapplication.FragmentExperience.Presenter.PresenterFeInterface
import com.example.myapplication.Models.Response.Experience
import com.example.myapplication.R

class FragmentExperience : Fragment(), ExperienceView {


    private var myView : View ? = null
    private var keyObjectExp = "KEY_ARRAY_EXP"
    private var myManagerRecycler: RecyclerView.LayoutManager? = null
    private var adapter:AdapterExperience ? = null
    private var recyclerView: RecyclerView? = null
    private var presenter:PresenterFeInterface ? = null
    private var listExp:ArrayList<Experience> ? = null


    fun newIntance(list :ArrayList<Experience>): FragmentExperience{
        val fragment = FragmentExperience()
        val args = Bundle()
        args.putParcelableArrayList(keyObjectExp,list)
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PresenterFeImp(this)
        listExp = ArrayList()
        adapter = AdapterExperience(listExp!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_experience,container,false)
        setupViews()
        presenter?.getInfoExperience(arguments,keyObjectExp)

        return myView
    }

    private fun setupViews() {
        myManagerRecycler = LinearLayoutManager(activity)
        recyclerView = myView?.findViewById<View>(R.id.recyclerExperience) as RecyclerView?
        recyclerView.apply {
            this?.setHasFixedSize(true)
            this?.layoutManager = myManagerRecycler
            this?.adapter = adapter
        }
    }

    override fun setInfoExperience(arrayList: ArrayList<Experience>) {
        listExp?.clear()
        listExp?.addAll(arrayList)
        adapter?.notifyDataSetChanged()
    }
}