package com.example.usersAppUDF

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.usersAppUDF.composable.ui.main.MainScreen
import com.example.usersAppUDF.viewModelImpl.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel by viewModels<MainViewModel>()
            MainScreen.Content(viewModel = viewModel)
        }
    }
}