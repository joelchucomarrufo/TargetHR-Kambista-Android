package pe.mowui.kambista.core.data.cloud

import pe.mowui.kambista.core.data.api.ApiHelper
import pe.mowui.kambista.core.data.model.LoginRequest

class LoginRepository(private val apiHelper: ApiHelper) {

    suspend fun login(loginRequest: LoginRequest) = apiHelper.login(loginRequest)
}