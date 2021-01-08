package pe.mowui.kambista.core.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder{

    private const val BASE_URL = "https://api-qa.kambista.com/"
    private const val BASE_URL_MOWUI= "https://www.mowui.pe/kambista/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getRetrofitMowui(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL_MOWUI)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val kambistaApi: KambistaApi = getRetrofit().create(KambistaApi::class.java)
    val mowuiApi: MowuiApi = getRetrofitMowui().create(MowuiApi::class.java)
}