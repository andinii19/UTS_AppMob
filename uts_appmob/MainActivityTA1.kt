package com.example.uts_appmob

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityTA1 : AppCompatActivity() {

    private lateinit var  recyclerViewTA: RecyclerView
    private lateinit var  dataListTA: ArrayList<listMHSTA>
    lateinit var listJudulTA: ArrayList<String>
    lateinit var listGambarTA: ArrayList<Int>
    lateinit var listNamaTA: ArrayList<String>
    lateinit var listNIMTA: ArrayList<String>
    private lateinit var logohome: ImageButton
    private lateinit var logotas: ImageButton
    private lateinit var logotoga: ImageButton
    private lateinit var logokeluar: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ta1)

        logohome = findViewById(R.id.logohome)
        logotas = findViewById(R.id.logotas)
        logotoga = findViewById(R.id.logotoga)
        logokeluar = findViewById(R.id.logokeluar)

        logohome.setOnClickListener {
            val intent = Intent(this, MainActivityHOME::class.java)
            startActivity(intent)
            finish()
        }


        logotas.setOnClickListener {
            tampilkanDialogKP("Pilih Kategori Mahasiswa/i")
        }

        logotoga.setOnClickListener {
            Toast.makeText(this, "Anda Sudah Berada Dihalaman Input Nilai Seminar TA", Toast.LENGTH_LONG).show()
        }

        logokeluar.setOnClickListener {
            val pesanDialog: String? = "Apakah Kamu Yakin Ingin Keluar?"
            showCustomDialogBox(pesanDialog)
        }

        listJudulTA = arrayListOf(
            "Implementasi Cloud Controller Menggunakan Eucalyptus sebagai Private Cloud Berbasis Centos",
            "Implementasi Teknik Mixing Real Video dan Animasi 3D pada Video Tutorial Dasar-dasar Bermain Sepakbola dengan Menggunakan Metode Chroma Key",
            "Perancangan Aplikasi Image Editor Berbasis Web Menggunakan Metode Adaptive Web Design"
        )


        listGambarTA = arrayListOf(
            R.drawable.akbar,
            R.drawable.faiz,
            R.drawable.ready
        )

        listNamaTA = arrayListOf(
            "Muhammad Ilham Akbar",
            "Rifki Faiz Azzurananda",
            "Ready Malik Putra"
        )

        listNIMTA = arrayListOf(
            "12250113387",
            "12250113451",
            "12250113761"
        )


        recyclerViewTA = findViewById(R.id.recylerView)
//        detail = findViewById(R.id.detail)
        recyclerViewTA.layoutManager = LinearLayoutManager(this)
        recyclerViewTA.setHasFixedSize(true)

        dataListTA = arrayListOf<listMHSTA>()
        getData()

    }

    private fun getData() {
        for (i in listGambarTA.indices) {
            val listMHS = listMHSTA(listJudulTA[i], listGambarTA[i], listNamaTA[i], listNIMTA[i])
            dataListTA.add(listMHS)
        }
        recyclerViewTA.adapter = adapterclassTA(dataListTA)
    }

    private fun tampilkanDialogKP(pesanDialogKP: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_main_kategori)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val teks: TextView = dialog.findViewById(R.id.teks)
        val kembali: ImageButton = dialog.findViewById(R.id.kembali)
        val diuji: Button = dialog.findViewById(R.id.diuiji)
        val dibimbing: Button = dialog.findViewById(R.id.dibimbing)

        pesanDialogKP?.let { teks.text = it }

        kembali.setOnClickListener { dialog.dismiss() }

        diuji.setOnClickListener {
            val intent = Intent(dialog.context, MainActivityKP1::class.java)
            startActivity(intent)
        }

        dibimbing.setOnClickListener {
            val intent = Intent(dialog.context, MainActivityKP1::class.java)
            startActivity(intent)
        }
        dialog.show()
    }

    private fun showCustomDialogBox(pesanDialog: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_main_log_out)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val pesan: TextView = dialog.findViewById(R.id.pesan)
        val bttnYa: Button = dialog.findViewById(R.id.bttnYa)
        val bttnTidak: Button = dialog.findViewById(R.id.bttnTidak)

        pesan.text = pesanDialog

        bttnYa.setOnClickListener {
            Toast.makeText(this, "Anda Telah LogOut", Toast.LENGTH_LONG).show()
            val intent = Intent(dialog.context, MainActivityLOGIN::class.java)
            startActivity(intent)
        }

        bttnTidak.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}