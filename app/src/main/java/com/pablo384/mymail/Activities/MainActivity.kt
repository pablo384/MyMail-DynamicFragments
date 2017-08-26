package com.pablo384.mymail.Activities

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pablo384.mymail.Fragments.HomeFragment
import com.pablo384.mymail.Models.Mail
import com.pablo384.mymail.R

class MainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListenerHomeFragment {
    override fun onFragmentInteractionHomeFragmentData(mail: Mail) {

        startActivity(Intent(this,DetailActivity::class.java)
                .putExtra(
                        "mail",
                        Mail(mail.subject,mail.from,mail.body)
                ))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
