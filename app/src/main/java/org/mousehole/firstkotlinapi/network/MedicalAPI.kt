package org.mousehole.firstkotlinapi.network

import android.database.Observable
import android.telecom.Call
import org.mousehole.firstkotlinapi.model.MedicalResponse
import org.mousehole.firstkotlinapi.model.MedicalResults
import org.mousehole.firstkotlinapi.util.Constants.Companion.MEDICAL_PATH
import retrofit2.http.GET

interface MedicalAPI {

    @GET(MEDICAL_PATH)
    fun getMedical(): io.reactivex.Observable<List<MedicalResults>>

}