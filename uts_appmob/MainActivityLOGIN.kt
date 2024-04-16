package com.example.uts_appmob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivityLOGIN : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var pw:EditText
    private lateinit var bttnlogin: Button
    private lateinit var showPW: ImageButton
    private lateinit var hidePW:ImageButton
    private var cursorPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        email = findViewById(R.id.email)
        pw = findViewById(R.id.pw)
        bttnlogin = findViewById(R.id.bttnlogin)
        showPW = findViewById(R.id.showPW)
        hidePW = findViewById(R.id.hidePW)

        showPW.setOnClickListener {
            cursorPosition = pw.selectionStart
            pw.transformationMethod = null
            showPW.visibility = ImageButton.GONE
            hidePW.visibility = ImageButton.VISIBLE
            pw.setSelection(cursorPosition)
        }

        hidePW.setOnClickListener {
            cursorPosition = pw.selectionStart
            pw.transformationMethod = PasswordTransformationMethod.getInstance()
            showPW.visibility = ImageButton.VISIBLE
            hidePW.visibility = ImageButton.GONE
            pw.setSelection(cursorPosition)
        }


        bttnlogin.setOnClickListener {
            if (cekEditTeks()) {
                // Lanjut ke aktivitas berikutnya jika kedua EditText terisi
                val intent = Intent(this, MainActivityHOME::class.java)
                startActivity(intent)
            } else {
                // Tampilkan dialog peringatan jika ada EditText yang kosong
                showToast("Email dan password harus diisi.")
            }
        }
    }

    // Fungsi untuk memeriksa apakah kedua EditText terisi
    private fun cekEditTeks(): Boolean {
        val email = email.text.toString()
        val password = pw.text.toString()
        return email.isNotEmpty() && password.isNotEmpty()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}