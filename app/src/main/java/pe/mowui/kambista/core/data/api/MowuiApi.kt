package pe.mowui.kambista.core.data.api

import pe.mowui.kambista.core.data.model.LoginResponse
import retrofit2.http.GET

interface MowuiApi {

    @GET("login.json")
    suspend fun login(): LoginResponse

}