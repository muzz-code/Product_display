package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    lateinit var fragmentTransaction: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
    }

    /*Method to Add Initial Fragment*/
    private fun initFragment() {
        val productsFragment = ProductFragment.newInstance()
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            setReorderingAllowed(true)
            replace(R.id.fragment_container, productsFragment)
            addToBackStack(null)
            commit()
        }
    }
}

