package com.example.basicrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentInputData = InputDataFragment()
        loadFragment(fragmentInputData)
    }

      private fun loadFragment(fragment: Fragment) {
       val fragmentManager = supportFragmentManager
       val fragmentTransaction = fragmentManager.beginTransaction()
       fragmentTransaction.replace(R.id.flShowFragment, fragment)
       fragmentTransaction.commit()

   }
}