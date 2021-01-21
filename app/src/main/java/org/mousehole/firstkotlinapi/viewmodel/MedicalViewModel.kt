package org.mousehole.firstkotlinapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.operators.observable.ObservableReplay.observeOn
import io.reactivex.schedulers.Schedulers
import org.mousehole.firstkotlinapi.model.MedicalResults
import org.mousehole.firstkotlinapi.network.MedicalRetrofit

class MedicalViewModel: ViewModel() {

    private  val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val medicalLiveData: MutableLiveData<List<MedicalResults>> = MutableLiveData()

    private val medicalRetrofit: MedicalRetrofit = MedicalRetrofit()


    fun getMedical(){
        compositeDisposable.add(
            medicalRetrofit.getMedical()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    if (it.isNotEmpty())
                        medicalLiveData.postValue(it)
                },{
                    Log.d("TAG_X", "${it.localizedMessage}")
                })

        )
    }
}