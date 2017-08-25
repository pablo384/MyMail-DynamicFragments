package com.pablo384.mymail.Activities

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pablo384.mymail.Fragments.DetailFragment
import com.pablo384.mymail.R

class DetailActivity : AppCompatActivity(), DetailFragment.OnFragmentInteractionListenerDetailFragment {
    override fun onFragmentInteractionDetailFun(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
