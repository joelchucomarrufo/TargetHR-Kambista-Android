package pe.mowui.kambista.core.data.api

import pe.mowui.kambista.core.data.model.LoginRequest

class ApiHelper(private val kambistaApi: KambistaApi) {

    suspend fun login(loginRequest: LoginRequest) = kambistaApi.login(loginRequest)
}