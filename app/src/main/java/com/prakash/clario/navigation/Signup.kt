package com.prakash.clario.navigation

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.play.integrity.internal.n

@Composable
fun Signup(modifier: Modifier = Modifier , authViewModel: AuthViewModel , navController: NavController) {
	Column(
		modifier = Modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	){
		var email by remember { mutableStateOf("") }
		var password by remember { mutableStateOf("") }

		val authState = authViewModel.authState.observeAsState()
		var context = LocalContext.current

	  LaunchedEffect(authState.value) {
		  when(authState.value) {
			  is AuthState.Authenticate -> navController.navigate(Routs.Home)
			  is AuthState.Error -> Toast.makeText(context , (authState.value as AuthState.Error).message , Toast.LENGTH_SHORT).show()
			  else -> Unit
		  }
	  }
		Text(
			text = "Signup",
			fontSize = 32.sp,
			textAlign = TextAlign.Center
		)

		Spacer(modifier = Modifier.height(8.dp))

		OutlinedTextField(
			value = email,
			onValueChange = { email = it },
			label = { Text("email") }
		)
		Spacer(modifier = Modifier.height(4.dp))
		OutlinedTextField(
			value = password,
			onValueChange = { password = it },
			label = { Text("password") }
		)
		Spacer(modifier = Modifier.height(8.dp))

		Button(
			onClick = {
				authViewModel.signup(email, password)
			}
		) {
			Text(text = "Signup")
		}

		Spacer(modifier = Modifier.height(4.dp))

		TextButton(
			onClick = {
				navController.navigate(Routs.login)
			}
		) {
			Text(text = "Already have account? Login")
		}

	}
}