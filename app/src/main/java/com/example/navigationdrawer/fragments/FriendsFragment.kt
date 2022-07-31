package com.example.navigationdrawer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationdrawer.R
import kotlinx.android.synthetic.main.fragment_friends.*

const val NAME = "name"
const val IMAGE = "image"
const val INFO = "info"

class FriendsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val customDialog = CustomDialog()
        val bundle = Bundle()

        first_contact?.setOnClickListener {
            if (context != null) {
                bundle.putString(NAME, tv_one?.text.toString())
                bundle.putInt(IMAGE, R.drawable.img_1)
                bundle.putString(INFO, "I love swimming")
                customDialog.arguments = bundle
                activity?.supportFragmentManager?.let { it1 ->
                    customDialog.show(
                        it1,
                        "customDialog"
                    )
                }
            }
        }

        second_contact?.setOnClickListener {
            if (context != null) {
                bundle.putString(NAME, tv_two?.text.toString())
                bundle.putInt(IMAGE, R.drawable.img_2)
                bundle.putString(INFO, "I love reading")
                customDialog.arguments = bundle
                activity?.supportFragmentManager?.let { it1 ->
                    customDialog.show(
                        it1,
                        "customDialog1"
                    )
                }
            }
        }

        third_contact?.setOnClickListener {
            if (context != null) {
                bundle.putString(NAME, tv_three?.text.toString())
                bundle.putInt(IMAGE, R.drawable.img_3)
                bundle.putString(INFO, "I love talking")
                customDialog.arguments = bundle
                activity?.supportFragmentManager?.let { it1 ->
                    customDialog.show(
                        it1,
                        "customDialog2"
                    )
                }
            }
        }
    }
}