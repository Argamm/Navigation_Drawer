package com.example.navigationdrawer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.navigationdrawer.R
import kotlinx.android.synthetic.main.fragment_dialog.*

class CustomDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args = arguments
        val name = args?.getString(NAME)
        val img = args?.getInt(IMAGE)
        val info = args?.getString(INFO)

        if (img != null) {
            iv_custom_image.setBackgroundResource(img)
        }
        tv_custom_name.text = name
        tv_more_info.text = info
    }
}