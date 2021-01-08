package pe.mowui.kambista.core.data.api

import pe.mowui.kambista.core.data.model.LoginRequest
import pe.mowui.kambista.core.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface KambistaApi {

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

}