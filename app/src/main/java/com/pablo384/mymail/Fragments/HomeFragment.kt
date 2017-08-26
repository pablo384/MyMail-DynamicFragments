package com.pablo384.mymail.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

import com.pablo384.mymail.R
import com.pablo384.mymail.Adapter.AdapterMail
import com.pablo384.mymail.Models.Mail
import kotlinx.android.synthetic.main.fragment_home.view.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListenerHomeFragment] interface
 * to handle interaction events.
 */
class HomeFragment : Fragment() {

    private var mListenerHomeFragment: OnFragmentInteractionListenerHomeFragment? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_home, container, false)
        val listaMail = arrayListOf<Mail>()
        var a=0
        listaMail.add(Mail("Convension 2017 ","Robert $a","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\". Estos textos hacen parecerlo un español que se puede leer. Muchos paquetes de autoedición y editores de páginas web usan el Lorem Ipsum como su texto por defecto, y al hacer una búsqueda de \"Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo)."))
        while (a<30){
            listaMail.add(Mail("Dinero ","TU PADRE $a","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\". Estos textos hacen parecerlo un español que se puede leer. Muchos paquetes de autoedición y editores de páginas web usan el Lorem Ipsum como su texto por defecto, y al hacer una búsqueda de \"Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo)."))
            a++
        }

        with(view){
            listViewHome.adapter = AdapterMail(context,listaMail)
            listViewHome.onItemClickListener = AdapterView.OnItemClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
                Log.d("TAG","posicion ${adapterView.getItemAtPosition(position)}")
                onItemPressed(adapterView.getItemAtPosition(position) as Mail)

            }
        }

        // Inflate the layout for this fragment
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onItemPressed(mail: Mail) {
        if (mListenerHomeFragment != null) {
            mListenerHomeFragment!!.onFragmentInteractionHomeFragmentData(mail)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try{
            mListenerHomeFragment = context as OnFragmentInteractionListenerHomeFragment
        }catch (e:Exception){
            e.printStackTrace()
        }
        if (context is OnFragmentInteractionListenerHomeFragment) {
            mListenerHomeFragment = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListenerDetailFragment")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListenerHomeFragment = null
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
    interface OnFragmentInteractionListenerHomeFragment {
        // TODO: Update argument type and name
        fun onFragmentInteractionHomeFragmentData(mail: Mail)
    }
}// Required empty public constructor
