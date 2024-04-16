package com.example.uts_appmob

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.view.Window
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import android.widget.TextView
import android.widget.Toast

class MainActivityHOME : AppCompatActivity() {

    private lateinit var bttnKP: Button
    private lateinit var bttnTA: Button
    private lateinit var logohome: ImageButton
    private lateinit var logotas: ImageButton
    private lateinit var logotoga: ImageButton
    private lateinit var logokeluar: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        inisialisasiTampilan()
        aturPendengarKlik()
    }
    private fun inisialisasiTampilan() {
        bttnKP = findViewById(R.id.bttnKP)
        bttnTA = findViewById(R.id.bttnTA)
        logohome = findViewById(R.id.logohome)
        logotas = findViewById(R.id.logotas)
        logotoga = findViewById(R.id.logotoga)
        logokeluar = findViewById(R.id.logokeluar)
    }

    private fun aturPendengarKlik() {
        bttnKP.setOnClickListener { tampilkanDialogKP("Pilih Kategori Mahasiswa/i") }
        bttnTA.setOnClickListener { tampilkanDialogTA("Pilih Kategori Mahasiswa/i") }
        logohome.setOnClickListener { /* menghandle aksi home */ }
        logotas.setOnClickListener { tampilkanDialogKP("Pilih Kategori Mahasiswa/i") }
        logotoga.setOnClickListener { tampilkanDialogTA("Pilih Kategori Mahasiswa/i") }
        logokeluar.setOnClickListener { tampilkanDialogKeluar("Apakah Kamu Yakin Ingin Keluar?") }
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

    private fun tampilkanDialogKeluar(pesanDialog: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_main_log_out)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val pesan: TextView = dialog.findViewById(R.id.pesan)
        val bttnYa: Button = dialog.findViewById(R.id.bttnYa)
        val bttnTidak: Button = dialog.findViewById(R.id.bttnTidak)

        pesanDialog?.let { pesan.text = it }

        bttnYa.setOnClickListener {
            Toast.makeText(this, "Anda Telah LogOut", Toast.LENGTH_LONG).show()
            val intent = Intent(dialog.context, MainActivityLOGIN::class.java)
            startActivity(intent)
        }

        bttnTidak.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }
}