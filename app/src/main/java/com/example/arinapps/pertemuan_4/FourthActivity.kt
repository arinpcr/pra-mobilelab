package com.example.arinapps.pertemuan_4

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.arinapps.R
import com.example.arinapps.databinding.ActivityFourthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            // Matikan judul default agar tidak menabrak Barbie kamu
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini Snackbar", Snackbar.LENGTH_SHORT).show()
        }

        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Yakin?")
                .setPositiveButton("Ya") { d, _ -> d.dismiss() }
                .show()
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