package org.mousehole.firstkotlinapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import org.mousehole.firstkotlinapi.R
import org.mousehole.firstkotlinapi.model.FdaResult
import org.mousehole.firstkotlinapi.view.adapter.MedicalAdapter
import org.mousehole.firstkotlinapi.viewmodel.MedicalViewModel2

class MainActivity : AppCompatActivity() {

    private val viewModel : MedicalViewModel2 by viewModels()

    private lateinit var medicalRecyclerView: RecyclerView
    private val medicalAdapter: MedicalAdapter = MedicalAdapter(mutableListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        medicalRecyclerView = findViewById(R.id.fda_recyclerview)
        medicalRecyclerView.adapter = medicalAdapter

        val itemSnapHelper: SnapHelper = LinearSnapHelper()
        itemSnapHelper.attachToRecyclerView(medicalRecyclerView)

        viewModel.medicalLiveData.observe(this, Observer {
            Log.d("TAG_X", "Results obtained...${it.size}")
            medicalAdapter.updateMedicalList(it as MutableList<FdaResult>)
        })
        viewModel.getMedical()

    }
}