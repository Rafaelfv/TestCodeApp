package com.example.myapplication.MainActivity.View

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.FragmentMain.View.FragmentMain
import com.example.myapplication.R
import com.example.myapplication.Utils.Constantes
import com.example.myapplication.Utils.GeneralInterface

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),GeneralInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar.let { it?.setDisplayShowTitleEnabled(false) }
        setFragment(FragmentMain().newInstance(),Constantes.TagsFragments.TAG_FRAGMENT_MAIN.tag)

    }
    /**
     * func to add Fragment un backstack
     */
    override fun addFragment(fragment: Fragment, tag: String) {
        Log.i("MainActivity","AddFragment")
        supportFragmentManager.beginTransaction()
            .add(R.id.content_main, fragment, tag)
            .addToBackStack(tag)
            .commitAllowingStateLoss()
    }
    /**
     * func to set Fragment in content activity
     */
    override fun setFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_main, fragment, tag)
            .commit()
    }

    override fun onBackAction() {
        onBackPressed()
    }

    /**
     * Func to remove Fragment of backstack
     */
    override fun removeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .remove(fragment)
            .commitAllowingStateLoss()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
