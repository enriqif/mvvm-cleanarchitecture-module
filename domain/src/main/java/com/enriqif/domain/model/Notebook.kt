package com.enriqif.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Notebook(
    val title: String?,
    val description: String?,
    val image: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Notebook> {
        override fun createFromParcel(parcel: Parcel): Notebook {
            return Notebook(parcel)
        }

        override fun newArray(size: Int): Array<Notebook?> {
            return arrayOfNulls(size)
        }
    }
}