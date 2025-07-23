package com.prakash.clario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.prakash.clario.authview.AuthViewModel
import com.prakash.clario.ui.theme.ClarioTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		val viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
		setContent {
			ClarioTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					ToDoList(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
				}
			}
		}
	}
}
