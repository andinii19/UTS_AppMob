package com.example.uts_appmob

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivityKP2 : AppCompatActivity() {

    private lateinit var nilaisikap: EditText
    private lateinit var nilaipenguasaan: EditText
    private lateinit var nilaiisi: EditText
    private lateinit var isitotalnilai: TextView
    private lateinit var judulKP: TextView
    private lateinit var fotoKP: ImageView
    private lateinit var namaKP: TextView
    private lateinit var nimKP: TextView
    private lateinit var simpanKP: Button
    private lateinit var kembaliKP: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kp2)

        nilaisikap = findViewById(R.id.nilaisikap)
        nilaipenguasaan = findViewById(R.id.nilaipenguasaan)
        nilaiisi = findViewById(R.id.nilaiisi)
        isitotalnilai = findViewById(R.id.isitotalnilai)
        judulKP = findViewById(R.id.judulKP)
        fotoKP = findViewById(R.id.fotoKP)
        namaKP = findViewById(R.id.namaKP)
        nimKP = findViewById(R.id.nimKP)
        simpanKP = findViewById(R.id.simpanKP)
        kembaliKP = findViewById(R.id.kembaliKP)

        // Tambahkan listener ke EditText untuk memicu perhitungan total nilai
        nilaisikap.addTextChangedListener {
            hitungTotalNilai()
        }
        nilaipenguasaan.addTextChangedListener {
            hitungTotalNilai()
        }
        nilaiisi.addTextChangedListener {
            hitungTotalNilai()
        }


        val judul = intent.getStringExtra("judul")
        judulKP.text = judul
        val gambar = intent.getIntExtra("gambar", 0)
        fotoKP.setImageResource(gambar)
        val nama = intent.getStringExtra("nama")
        namaKP.text = nama
        val nim = intent.getStringExtra("nim")
        nimKP.text = nim

        simpanKP.setOnClickListener {
        // Tampilkan dialog peringatan jika ada EditText yang kosong
            showToast("Berhasil Disimpan")
        }

        kembaliKP.setOnClickListener {
            val intent = Intent(this, MainActivityKP1::class.java)
            startActivity(intent)
        }
    }

    private fun hitungTotalNilai(){
        // Ambil nilai dari EditText dan konversi ke tipe Int
        val nilaiSikap = nilaisikap.text.toString().toIntOrNull() ?: 0
        val nilaiPenguasaan = nilaipenguasaan.text.toString().toIntOrNull() ?: 0
        val nilaiIsi = nilaiisi.text.toString().toIntOrNull() ?: 0

        // Hitung total nilai
        val totalNilai = (nilaiSikap * 20)/100 + (nilaiPenguasaan * 40)/100 + (nilaiIsi * 40)/100

        // Setel total nilai pada TextView isitotalnilai
        isitotalnilai.text = totalNilai.toString()

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}