package org.mousehole.firstkotlinapi.network

import org.mousehole.firstkotlinapi.model.FdaResponse
import org.mousehole.firstkotlinapi.util.Constants.Companion.MEDICAL_PATH
import retrofit2.http.GET
import retrofit2.http.Query

interface MedicalAPI {

    @GET(MEDICAL_PATH)
    fun getMedical(): io.reactivex.Observable<FdaResponse>
}