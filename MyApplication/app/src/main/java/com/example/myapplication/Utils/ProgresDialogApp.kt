package com.example.myapplication.Utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.example.myapplication.R


class ProgresDialogApp(context: Context?) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
        if (savedInstanceState == null) {
            setContentView(R.layout.dialog_loader)
        }
    }

    override fun show() {
        try {
            if (!isShowing) {
                super.show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    override fun dismiss() {
        super.dismiss()
    }

}
