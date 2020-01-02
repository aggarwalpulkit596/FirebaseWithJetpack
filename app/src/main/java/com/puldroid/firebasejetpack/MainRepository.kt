package com.puldroid.firebasejetpack

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class MainRepository {

    private var firestoreDb = Firebase.firestore
    var user = FirebaseAuth.getInstance().currentUser!!

    suspend fun currentUser(): DocumentSnapshot? =
        firestoreDb.collection(USERS).document(user.uid).get().await()
//        safeApiCall {  }

    suspend fun fetchFriends(): QuerySnapshot? =
        firestoreDb.collection("$USERS/${user.uid}/$FRIENDS").get().await()

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: MainRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: MainRepository().also { instance = it }
            }
    }

}