package com.pablo384.mymail.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.pablo384.mymail.Models.Mail
import com.pablo384.mymail.R
import com.pablo384.mymail.R.layout.listitem_mail

/**
 * Created by pablo384 on 25/08/17.
 */
class AdapterMail(context:Context, array: ArrayList<Mail>):BaseAdapter() {
    private var sList:ArrayList<Mail>
    private val mInflator: LayoutInflater
    init {
        this.mInflator = LayoutInflater.from(context)
        this.sList = array
    }


    override fun getItem(position: Int): Any =sList[position]

    override fun getItemId(position: Int): Long =position.toLong()

    override fun getCount(): Int=sList.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.listitem_mail, parent, false)
            vh = ListRowHolder(view)
            view!!.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        vh.init.text = sList[position].from.substring(0..0)
        vh.title.text = sList[position].from
        vh.body.text = sList[position].body.substring(0..90)
        return view
    }

    private class ListRowHolder(row:View?){
        val init:TextView= row?.findViewById(R.id.textViewInit)!!
        val title:TextView= row?.findViewById(R.id.textViewTitle)!!
        val body:TextView= row?.findViewById(R.id.textViewBody)!!

    }
}