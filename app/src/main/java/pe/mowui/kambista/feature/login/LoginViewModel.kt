package pe.mowui.kambista.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import pe.mowui.kambista.core.data.cloud.LoginRepository
import pe.mowui.kambista.core.data.model.LoginRequest
import pe.mowui.kambista.util.Resource

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    fun login(user: String, password: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val loginRequest = LoginRequest(user, password)
            emit(Resource.success(data = loginRepository.login(loginRequest)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error al loguearse"))
        }
    }

    fun loginMowui() = liveData(Dispatchers.IO) {
        try {
            emit(Resource.success(data = loginRepository.loginMowui()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error al loguearse"))
        }
    }

}