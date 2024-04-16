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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityTA2 : AppCompatActivity() {

    private lateinit var judulTA: TextView
    private lateinit var fotoTA: ImageView
    private lateinit var namaTA: TextView
    private lateinit var nimTA: TextView
    private lateinit var simpanTA: Button
    private lateinit var kembaliTA: Button
    private lateinit var nilai1: EditText
    private lateinit var nilai2: EditText
    private lateinit var nilai3: EditText
    private lateinit var nilai4: EditText
    private lateinit var nilai5: EditText
    private lateinit var nilai6: EditText
    private lateinit var nilai7: EditText
    private lateinit var nilai8: EditText
    private lateinit var nilai9: EditText
    private lateinit var nilai10: EditText
    private lateinit var nilai11: EditText
    private lateinit var nilai12: EditText
    private lateinit var isitotalnilai: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ta2)

        judulTA = findViewById(R.id.judulTA)
        fotoTA = findViewById(R.id.ta2foto)
        namaTA = findViewById(R.id.ta2nama)
        nimTA = findViewById(R.id.ta2nim)
        simpanTA = findViewById(R.id.simpanTA)
        kembaliTA = findViewById(R.id.kembaliTA)
        nilai1 = findViewById(R.id.nilai1)
        nilai2 = findViewById(R.id.nilai2)
        nilai3 = findViewById(R.id.nilai3)
        nilai4 = findViewById(R.id.nilai4)
        nilai5 = findViewById(R.id.nilai5)
        nilai6 = findViewById(R.id.nilai6)
        nilai7 = findViewById(R.id.nilai7)
        nilai8 = findViewById(R.id.nilai8)
        nilai9 = findViewById(R.id.nilai9)
        nilai10 = findViewById(R.id.nilai10)
        nilai11 = findViewById(R.id.nilai11)
        nilai12 = findViewById(R.id.nilai12)
        isitotalnilai = findViewById(R.id.isitotalnilai)

        nilai1.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai2.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai3.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai4.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai5.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai6.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai7.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai8.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai9.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai10.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai11.addTextChangedListener {
            hitungTotalNilai()
        }
        nilai12.addTextChangedListener {
            hitungTotalNilai()
        }


        simpanTA.setOnClickListener {
        // Tampilkan dialog peringatan jika ada EditText yang kosong
            showToast("Berhasil Disimpan")
        }

        kembaliTA.setOnClickListener {
            val intent = Intent(this, MainActivityTA1::class.java)
            startActivity(intent)
        }

        val judul = intent.getStringExtra("judul")
        judulTA.text = judul
        val gambar = intent.getIntExtra("gambar", 0)
        fotoTA.setImageResource(gambar)
        val nama = intent.getStringExtra("nama")
        namaTA.text = nama
        val nim = intent.getStringExtra("nim")
        nimTA.text = nim

    }

    private fun hitungTotalNilai() {
        // Ambil nilai dari EditText dan konversi ke tipe Int
        val nilai1 = nilai1.text.toString().toIntOrNull() ?: 0
        val nilai2 = nilai2.text.toString().toIntOrNull() ?: 0
        val nilai3 = nilai3.text.toString().toIntOrNull() ?: 0
        val nilai4 = nilai4.text.toString().toIntOrNull() ?: 0
        val nilai5 = nilai5.text.toString().toIntOrNull() ?: 0
        val nilai6 = nilai6.text.toString().toIntOrNull() ?: 0
        val nilai7 = nilai7.text.toString().toIntOrNull() ?: 0
        val nilai8 = nilai8.text.toString().toIntOrNull() ?: 0
        val nilai9 = nilai9.text.toString().toIntOrNull() ?: 0
        val nilai10 = nilai10.text.toString().toIntOrNull() ?: 0
        val nilai11 = nilai11.text.toString().toIntOrNull() ?: 0
        val nilai12 = nilai12.text.toString().toIntOrNull() ?: 0

        // Hitung total nilai
        val totalNilai = (nilai1+nilai2+nilai3+nilai4+nilai5+nilai6+nilai7+nilai8+nilai9+nilai10+nilai11+nilai12)/12

        // Setel total nilai pada TextView isitotalnilai
        isitotalnilai.text = totalNilai.toString()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}