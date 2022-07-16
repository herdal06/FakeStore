package com.example.fakestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fakestore.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.searchProductFragment, R.id.cartFragment
            )
        )


        // Hide toolbar and bottom navigation in the splash screen
        val noBottomNavigationIds = listOf(R.id.splashScreenFragment)
        val noToolbarNavigationIds = listOf(R.id.splashScreenFragment)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            val shouldShowBottomNavigationBars =
                noBottomNavigationIds.contains(destination.id).not()
            val shouldShowToolbar = noToolbarNavigationIds.contains(destination.id).not()

            binding.navView.isVisible = shouldShowBottomNavigationBars
            if (shouldShowToolbar) {
                supportActionBar?.show()
            } else {
                supportActionBar?.hide()
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}