package com.example.uts_appmob

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class adapterclassKP (private  val dataListKP: ArrayList<listMHSKP> ): RecyclerView.Adapter<adapterclassKP.ViewHolderClassKP>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterclassKP.ViewHolderClassKP {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_adapterclass_kp, parent, false)
        return adapterclassKP.ViewHolderClassKP(itemView)

    }

    override fun getItemCount(): Int {
        return dataListKP.size
    }

    override fun onBindViewHolder(holder: adapterclassKP.ViewHolderClassKP, position: Int) {
        val currentItem = dataListKP[position]
        holder.judulKP.text = currentItem.listJudulKP
        holder.fotoMHSKP.setImageResource(currentItem.listFotoKP)
        holder.namaMHSKP.text = currentItem.listNamaKP
        holder.nimMHSKP.text = currentItem.listNIMKP

        holder.detailKP.setOnClickListener {
            val intent = Intent(holder.itemView.context, MainActivityKP2::class.java)
            intent.putExtra("judul", currentItem.listJudulKP)
            intent.putExtra("gambar", currentItem.listFotoKP)
            intent.putExtra("nama", currentItem.listNamaKP)
            intent.putExtra("nim", currentItem.listNIMKP)
            holder.itemView.context.startActivity(intent)
        }
    }


    class ViewHolderClassKP(itemView: View): RecyclerView.ViewHolder(itemView) {
        val judulKP: TextView = itemView.findViewById(R.id.judulKP)
        val fotoMHSKP: ImageView = itemView.findViewById(R .id.fotoKP)
        val namaMHSKP: TextView = itemView.findViewById(R.id.namaKP)
        val nimMHSKP: TextView = itemView.findViewById(R.id.nimKP)
        val detailKP: Button = itemView.findViewById(R.id.detailKP)
    }

}