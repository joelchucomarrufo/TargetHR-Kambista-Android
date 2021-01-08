package pe.mowui.kambista.core.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder{

    private const val BASE_URL = "https://api-qa.kambista.com/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val kambistaApi: KambistaApi = getRetrofit().create(KambistaApi::class.java)
}