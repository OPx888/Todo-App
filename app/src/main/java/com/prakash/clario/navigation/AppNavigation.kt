package com.prakash.clario.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prakash.clario.ToDoList
import com.prakash.clario.authview.TodoViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation (modifier: Modifier = Modifier , authViewModel: AuthViewModel , ) {

	var navController = rememberNavController()
	NavHost(navController = navController , startDestination = Routs.login , builder = {
		composable(Routs.login){
			Login(modifier , authViewModel , navController)
		}
		composable (Routs.signup){
			Signup(modifier, authViewModel , navController)
		}
		composable (Routs.Home){
			ToDoList(modifier , TodoViewModel(), authViewModel)
		}

	})
}