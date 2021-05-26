package com.example.week4

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.week4.views.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var fragmentTransaction: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    /** Listener for handling selection events on bottom navigation items. */
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            /*Initialize Intent for Each Bottom Nav Components*/
            when (item.itemId) {
                R.id.mProducts -> {

                    val productsFragment = ProductsFragment.newInstance()
                    openFragment(productsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.mSupport -> {

                    val supportFragment = SupportFragment.newInstance()
                    openFragment(supportFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.mPayments -> {

                    val supportFragment = PaymentsFragment.newInstance()
                    openFragment(supportFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.mHistory -> {

                    val supportFragment = HistoryFragment.newInstance()
                    openFragment(supportFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.mMore -> {

                    val supportFragment = MoreFragment.newInstance()
                    openFragment(supportFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    /*Method to Create Fragment*/
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
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



