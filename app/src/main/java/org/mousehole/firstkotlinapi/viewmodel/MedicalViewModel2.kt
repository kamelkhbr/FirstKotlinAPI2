package org.mousehole.firstkotlinapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.mousehole.firstkotlinapi.model.FdaResult
import org.mousehole.firstkotlinapi.network.MedicalRetrofit

class MedicalViewModel2 : ViewModel(){

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    public val medicalLiveData: MutableLiveData<List<FdaResult>> = MutableLiveData()

    private val medicalRetrofit: MedicalRetrofit = MedicalRetrofit()

    fun getMedical(){
        compositeDisposable.add(
                medicalRetrofit.getMedical().observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .map {
                            it.results
                        }
                        .subscribe ({
                                if (it.isNotEmpty())
                                    medicalLiveData.postValue(it)
                                compositeDisposable.clear()
                            }, {
                            Log.d("TAG_X", "${it.localizedMessage}")
                        })

        )


    }

}