package com.example.uts_appmob

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterclassTA (private val dataListTA: ArrayList<listMHSTA>):  RecyclerView.Adapter<adapterclassTA.ViewHolderClassTA>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterclassTA.ViewHolderClassTA {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_adapterclass_ta, parent, false)
        return adapterclassTA.ViewHolderClassTA(itemView)
    }

    override fun getItemCount(): Int {
        return dataListTA.size
    }

    override fun onBindViewHolder(holder: adapterclassTA.ViewHolderClassTA, position: Int) {
        val currentItem = dataListTA[position]
        holder.judulTA.text = currentItem.listJudulTA
        holder.fotoMHSTA.setImageResource(currentItem.listFotoTA)
        holder.namaMHSTA.text = currentItem.listNamaTA
        holder.nimMHSTA.text = currentItem.listNIMTA

        holder.detailTA.setOnClickListener {
            val intent = Intent(holder.itemView.context, MainActivityTA2::class.java)
            intent.putExtra("judul", currentItem.listJudulTA)
            intent.putExtra("gambar", currentItem.listFotoTA)
            intent.putExtra("nama", currentItem.listNamaTA)
            intent.putExtra("nim", currentItem.listNIMTA)
            holder.itemView.context.startActivity(intent)
        }

    }
    class ViewHolderClassTA(itemView: View): RecyclerView.ViewHolder(itemView) {
        val judulTA: TextView = itemView.findViewById(R.id.judulTA)
        val fotoMHSTA: ImageView = itemView.findViewById(R .id.fotoTA)
        val namaMHSTA: TextView = itemView.findViewById(R.id.namaTA)
        val nimMHSTA: TextView = itemView.findViewById(R.id.nimTA)
        val detailTA: Button = itemView.findViewById(R.id.detailTA)
    }
}