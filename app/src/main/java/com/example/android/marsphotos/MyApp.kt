package com.example.android.marsphotos

import android.app.Application
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import com.example.android.marsphotos.databinding.CircularLoadingLottieBinding

class MyApp: Application() {
    private var loadingDialog: Dialog? = null
    fun showDialog(context: Context?) {
        val binding: CircularLoadingLottieBinding =
            CircularLoadingLottieBinding.inflate(LayoutInflater.from(context))
        if (loadingDialog != null && loadingDialog!!.isShowing()) return
        loadingDialog = context?.let { Dialog(it, R.style.LoaderStyle) }
        loadingDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        loadingDialog?.setContentView(binding.root)
        loadingDialog?.setCancelable(false)
        if (loadingDialog?.window == null) return
        loadingDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        loadingDialog!!.window!!
            .setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        loadingDialog!!.show()
    }

    fun hideDialog() {
        if (loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog!!.dismiss()
        }
    }
}