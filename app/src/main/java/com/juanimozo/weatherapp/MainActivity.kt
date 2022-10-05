package com.juanimozo.weatherapp

import android.Manifest
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.juanimozo.weatherapp.navigation.Navigation
import com.juanimozo.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.updateUserLocation()
        }

        // Location Permission
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))

        // Make screen occupy Status bar
        // window.setFlags(
        //    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        //    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS )

        setContent {
            WeatherAppTheme {
                val navController = rememberNavController()
                Scaffold { padding ->
                    Column(modifier = Modifier.padding(padding)) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}