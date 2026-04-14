package com.example.arinapps.pertemuan_2

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.arinapps.R
import androidx.appcompat.widget.Toolbar

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        // Toolbar Setup
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 2"
            setDisplayHomeAsUpEnabled(true)
        }

        val inputNama: EditText = findViewById(R.id.inputNama)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val nama = inputNama.text
            Log.e("Klik btnSubmit", "Isi: $nama")
            Toast.makeText(this, "Submit Berhasil", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}