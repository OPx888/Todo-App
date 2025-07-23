package com.prakash.clario.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

	val auth: FirebaseAuth = FirebaseAuth.getInstance()

	private val _authState = MutableLiveData<AuthState>()
	val authState : LiveData<AuthState> = _authState


	init {

		checkAuthState()
	}
	fun checkAuthState() {
		if (auth.currentUser !== null) {
			_authState.value = AuthState.Authenticate
		} else {
			_authState.value = AuthState.UnAuthenticate
		}
	}

	fun login(email: String, password: String){
		if (email.isEmpty() || password.isEmpty()){
			_authState.value = AuthState.Error("Email or Password is empty")
			return
		}
		_authState.value = AuthState.Loading
		auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
			if(task.isSuccessful){
				_authState.value = AuthState.Authenticate
			}else{
				_authState.value = AuthState.Error(task.exception?.message ?: "Unknown Error")
			}
		}
	}

	fun signup(email: String, password: String){
		if(email.isEmpty() || password.isEmpty()){
			_authState.value = AuthState.Error("Email or Password is empty")
			return
		}
		_authState.value = AuthState.Loading
		auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {task->
			if(task.isSuccessful){
				_authState.value = AuthState.Authenticate
			}else{
				_authState.value = AuthState.Error(task.exception?.message ?: "Unknown Error")
			}
		}
	}

	fun logout(){
		auth.signOut()
		_authState.value = AuthState.UnAuthenticate
	}
}

sealed class AuthState {
	object Authenticate : AuthState()
	object UnAuthenticate : AuthState()
	object Loading : AuthState()
	data class Error (val message : String) : AuthState()
}