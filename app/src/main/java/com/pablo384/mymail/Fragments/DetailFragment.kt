package com.pablo384.mymail.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pablo384.mymail.Models.Mail

import com.pablo384.mymail.R
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DetailFragment.OnFragmentInteractionListenerDetailFragment] interface
 * to handle interaction events.
 */
class DetailFragment : Fragment() {

    private var mListenerDetailFragment: OnFragmentInteractionListenerDetailFragment? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_detail, container, false)
        // Inflate the layout for this fragment
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListenerDetailFragment != null) {
            mListenerDetailFragment!!.onFragmentInteractionDetailFun(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try{
            mListenerDetailFragment = context as OnFragmentInteractionListenerDetailFragment
        }catch (e:Exception){
            e.printStackTrace()
        }
        if (context is OnFragmentInteractionListenerDetailFragment) {
            mListenerDetailFragment = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListenerDetailFragment")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListenerDetailFragment = null
    }
    fun renderText(mail: Mail){
        textViewSubjectDetailFragment.text=mail.subject
        textViewFromDetailFragment.text=mail.from
        editTextBodyDetailFragment.text=mail.body
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListenerDetailFragment {
        // TODO: Update argument type and name
        fun onFragmentInteractionDetailFun(uri: Uri)
    }
}// Required empty public constructor
