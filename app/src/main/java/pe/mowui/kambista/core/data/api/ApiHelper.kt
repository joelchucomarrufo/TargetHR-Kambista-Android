package pe.mowui.kambista.core.data.api

import pe.mowui.kambista.core.data.model.LoginRequest

class ApiHelper(private val kambistaApi: KambistaApi, private val mowuiApi: MowuiApi) {

    suspend fun login(loginRequest: LoginRequest) = kambistaApi.login(loginRequest)

    suspend fun loginMowui() = mowuiApi.login()
}