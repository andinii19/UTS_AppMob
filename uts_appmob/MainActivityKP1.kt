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

class MainActivityKP1 : AppCompatActivity() {

    private lateinit var  recyclerViewKP: RecyclerView
    private lateinit var  dataListKP: ArrayList<listMHSKP>
    lateinit var listJudulKP: ArrayList<String>
    lateinit var listGambarKP: ArrayList<Int>
    lateinit var listNamaKP: ArrayList<String>
    lateinit var listNIMKP: ArrayList<String>
    private lateinit var logohome: ImageButton
    private lateinit var logotas: ImageButton
    private lateinit var logotoga: ImageButton
    private lateinit var logokeluar: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kp1)

        logohome = findViewById(R.id.logohome)
        logotas = findViewById(R.id.logotas)
        logotoga = findViewById(R.id.logotoga)
        logokeluar = findViewById(R.id.logokeluar)


        listJudulKP = arrayListOf(
            "PERANCANGAN APLIKASI ABSENSI GURU DAN PEGAWAI PADA MADRASAH ALLIYAH DARUSSALAM PANGKALPINANG BERBASIS ANDROID",
            "PEMBUATAN WEBSITE SEKOLAH DI SMA TAMAN MADYA JETIS YOGYAKARTA",
            "IMPLEMENTASI AUGMENTED REALITY SEBAGAI MEDIA PROMOSI INTERAKTIF UNTUK KATALOG PRODUCT AND SERVICE DI PT. MISTAR MEDIA PARIWARA"
        )


        listGambarKP = arrayListOf(
            R.drawable.andin,
            R.drawable.deli,
            R.drawable.tasya
        )

        listNamaKP = arrayListOf(
            "Restu Kharrisa Andini",
            "Nur Delifah",
            "Tasya Dwi Yanti"
        )

        listNIMKP = arrayListOf(
            "12250124591",
            "12250123957",
            "12250123081"
        )


        recyclerViewKP = findViewById(R.id.recylerView)
//        detail = findViewById(R.id.detail)
        recyclerViewKP.layoutManager = LinearLayoutManager(this)
        recyclerViewKP.setHasFixedSize(true)

        dataListKP = arrayListOf<listMHSKP>()
        getData()

        logohome.setOnClickListener {
            val intent = Intent(this, MainActivityHOME::class.java)
            startActivity(intent)
        }


        logotas.setOnClickListener {
            Toast.makeText(this, "Anda Sudah Berada Dihalaman Input Nilai Seminar KP", Toast.LENGTH_LONG).show()
        }

        logotoga.setOnClickListener {
            tampilkanDialogTA("Pilih Kategori Mahasiswa/i")
        }
        logokeluar.setOnClickListener {
            val pesanDialog: String? = "Apakah Kamu Yakin Ingin Keluar?"
            showCustomDialogBox(pesanDialog)
        }

    }


    private fun getData() {
        for (i in listGambarKP.indices) {
            val listMHS = listMHSKP(listJudulKP[i], listGambarKP[i], listNamaKP[i], listNIMKP[i])
            dataListKP.add(listMHS)
        }
        recyclerViewKP.adapter = adapterclassKP(dataListKP)
    }

    private fun tampilkanDialogTA(pesanDialogTA: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_main_kategori)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val teks: TextView = dialog.findViewById(R.id.teks)
        val kembali: ImageButton = dialog.findViewById(R.id.kembali)
        val diuji: Button = dialog.findViewById(R.id.diuiji)
        val dibimbing: Button = dialog.findViewById(R.id.dibimbing)

        pesanDialogTA?.let { teks.text = it }

        kembali.setOnClickListener { dialog.dismiss() }

        diuji.setOnClickListener {
            val intent = Intent(dialog.context, MainActivityTA1::class.java)
            startActivity(intent)
        }

        dibimbing.setOnClickListener {
            val intent = Intent(dialog.context, MainActivityTA1::class.java)
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

