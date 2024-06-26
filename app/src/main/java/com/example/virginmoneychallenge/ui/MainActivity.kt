package com.example.virginmoneychallenge.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.virginmoneychallenge.R
import com.example.virginmoneychallenge.databinding.ActivityMainBinding
import com.example.virginmoneychallenge.ui.people.PeopleFragment
import com.example.virginmoneychallenge.ui.room.RoomsFragment
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val TAG = "TAG: MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.fragmentContainer.id) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.nav_people_detailed) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_people -> {
                    Log.i(TAG, "setFragment: People")
                    navController.navigate(R.id.nav_people)
                    true
                }

                R.id.nav_rooms -> {
                    Log.i(TAG, "setFragment: Room")
                    navController.navigate(R.id.nav_rooms)
                    true
                }

                else -> {
                    Log.i(TAG, "setFragment: Else")
                    false
                }
            }
        }
    }
}

