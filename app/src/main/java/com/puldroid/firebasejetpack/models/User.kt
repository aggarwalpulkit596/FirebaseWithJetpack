package com.puldroid.firebasejetpack.models

import com.google.firebase.firestore.GeoPoint

data class User(
    var thumb_image: String,
    var image: String,
    var name: String,
    var location: GeoPoint?,
    var dateofbirth: String,
    var about: String,
    var place: String,
    var college: String,
    var gender: String,
    var isActive: Boolean = true,
    var uid: String
) : Comparable<User> {
    /*
    *Default Constructor
     */
    constructor() : this("", "", "", null, "", "", "", "", "", true, "")

    override fun compareTo(other: User): Int {
        return 0
    }

}