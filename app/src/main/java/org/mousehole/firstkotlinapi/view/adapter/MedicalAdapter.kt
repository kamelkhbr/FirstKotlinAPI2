package org.mousehole.firstkotlinapi.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.mousehole.firstkotlinapi.R
import org.mousehole.firstkotlinapi.model.FdaResult

class MedicalAdapter(private var medicalList: MutableList<FdaResult>):RecyclerView.Adapter<MedicalAdapter.MedicalViewHolder>() {

    fun updateMedicalList (medicalList: MutableList<FdaResult>){
        this.medicalList= medicalList
        notifyDataSetChanged()
    }

    class MedicalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val recallFirmTextView : TextView = itemView.findViewById(R.id.recall_firmtv)
        val recallReasonTextView: TextView = itemView.findViewById(R.id.recall_reasontv)
        val recallQTTextView: TextView = itemView.findViewById(R.id.prod_quantitytv)
        val statusTextView : TextView= itemView.findViewById(R.id.status_tv)
        val countryTextView: TextView= itemView.findViewById(R.id.country_tv)
        val cityTextView: TextView= itemView.findViewById(R.id.city_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicalViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fda_result_item, parent,false)
        return MedicalViewHolder(itemView)
    }

    override fun getItemCount(): Int= medicalList.size

    override fun onBindViewHolder(holder: MedicalViewHolder, position: Int) {
        val medicalItem = medicalList[position]

        holder.apply {
            recallFirmTextView.text = medicalItem.recalling_firm
            recallReasonTextView.text = "Recall Reason: "+medicalItem.reason_for_recall
            recallQTTextView.text = "Quantity: "+medicalItem.product_quantity
            statusTextView.text = "Status: "+medicalItem.status
            countryTextView.text = medicalItem.country
            cityTextView.text = medicalItem.city
        }


    }


}