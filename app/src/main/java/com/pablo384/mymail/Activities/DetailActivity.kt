package com.pablo384.mymail.Activities

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pablo384.mymail.Fragments.DetailFragment
import com.pablo384.mymail.Models.Mail
import com.pablo384.mymail.R
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.listitem_mail.*

class DetailActivity : AppCompatActivity(), DetailFragment.OnFragmentInteractionListenerDetailFragment {
    override fun onFragmentInteractionDetailFun(uri: Uri) {

    }
    lateinit var mail:Mail
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (intent.extras!=null){
            mail = intent.getParcelableExtra("mail")
        }
        val fragmentDetails:DetailFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetail) as DetailFragment
        fragmentDetails.renderText(mail)

    }
}
