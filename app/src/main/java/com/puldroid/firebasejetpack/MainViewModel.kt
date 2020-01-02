package com.puldroid.firebasejetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObject
import com.puldroid.firebasejetpack.models.User
import com.puldroid.firebasejetpack.utils.runIO

class MainViewModel : ViewModel() {

    private var repo = MainRepository.getInstance()
    private var friendsList = MutableLiveData<List<User>>()


    init {
        runIO {
            repo.currentUser()?.let {
                //Todo check token from sharedprefs is matching or not
                val token = it.getString(DEVICE_TOKEN)
            } ?: run {
                //Case of Auth Expired

            }

        }

    }

    fun getFriends(): MutableLiveData<List<User>> {
        runIO {
            repo.fetchFriends()?.let {
                val list = mutableListOf<User>()
                for (doc in it) {
                    val userItem = doc.toObject<User>()
                    list.add(userItem)
                }
                friendsList.value = list
            } ?: run {
                //Error Handling
            }
        }
        return friendsList
    }


}