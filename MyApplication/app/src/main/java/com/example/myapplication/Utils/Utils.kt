package com.example.myapplication.Utils

import android.content.Context
import android.widget.Toast
import java.security.AccessControlContext

class Utils{

    /**
     * Function to show a toast from any place
     */
    fun showToast(context: Context,message: String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

}
