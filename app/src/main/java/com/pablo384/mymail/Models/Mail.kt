package com.pablo384.mymail.Models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by pablo384 on 25/08/17.
 */
data class Mail(val subject:String, val from:String, val body:String):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(subject)
        p0.writeString(from)
        p0.writeString(body)
    }

    override fun describeContents(): Int=0

    companion object CREATOR : Parcelable.Creator<Mail> {
        override fun createFromParcel(parcel: Parcel): Mail {
            return Mail(parcel)
        }

        override fun newArray(size: Int): Array<Mail?> {
            return arrayOfNulls(size)
        }
    }
}