package com.puldroid.firebasejetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.puldroid.firebasejetpack.utils.getViewModel
import com.puldroid.firebasejetpack.utils.observer

class MainActivity : AppCompatActivity() {

    private val vm by lazy { getViewModel { MainViewModel() } }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm.getFriends().observer(this) {

        }
    }
}
