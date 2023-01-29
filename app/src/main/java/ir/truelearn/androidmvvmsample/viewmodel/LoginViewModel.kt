package ir.truelearn.androidmvvmsample.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.truelearn.androidmvvmsample.repository.LoginRepository
import ir.truelearn.androidmvvmsample.ui.screens.profile.ProfilePageState
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    var pageState by mutableStateOf(ProfilePageState.LOGIN_STATE)

    var inputPhoneState by mutableStateOf("")
    var inputPasswordState by mutableStateOf("")

}

