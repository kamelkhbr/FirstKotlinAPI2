package org.mousehole.firstkotlinapi.network

import android.database.Observable
import org.mousehole.firstkotlinapi.model.MedicalResults
import org.mousehole.firstkotlinapi.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MedicalRetrofit {

    private val medicalAPI : MedicalAPI

    init {
        medicalAPI = createMedicalAPI(createRetrofitInstance())
    }

    private fun createRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createMedicalAPI( retrofit: Retrofit): MedicalAPI =
        retrofit.create(MedicalAPI :: class.java)


    fun getMedical(): io.reactivex.Observable<List<MedicalResults>> {
        return medicalAPI.getMedical()
    }
}