package com.example.gohr.ui.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.gohr.R
import com.example.gohr.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.requset,
                R.id.additional,
                R.id.table,
                R.id.complain,
                R.id.profile
            )
        )


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.requset -> {
                    changeBottomNav(true)
                }
                R.id.additional -> {
                    changeBottomNav(true)
                }
                R.id.table -> {
                    changeBottomNav(true)
                }
                R.id.complain -> {
                    changeBottomNav(true)
                }
                R.id.profile -> {
                    changeBottomNav(true)
                }
                else -> changeBottomNav(false)
            }
        }
        setupWithNavController(binding.bottomNav, navController)
    }

    private fun changeBottomNav(cond: Boolean) {
        binding.bottomNav.isVisible = cond
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}