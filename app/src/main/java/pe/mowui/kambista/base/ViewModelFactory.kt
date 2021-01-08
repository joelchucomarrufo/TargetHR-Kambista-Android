package pe.mowui.kambista.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pe.mowui.kambista.core.data.api.ApiHelper
import pe.mowui.kambista.core.data.cloud.LoginRepository
import pe.mowui.kambista.feature.login.LoginViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(LoginRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("No se encuentra el viewmodel")
    }

}

