package com.example.arinapps.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.arinapps.R
import com.example.arinapps.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            // MATIKAN judul bawaan agar tidak menabrak gambar Barbie kustom kamu
            setDisplayShowTitleEnabled(false)

            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        binding.btnWebView.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> { finish(); true }
            R.id.action_search -> { Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show(); true }
            R.id.sub_profile -> { Toast.makeText(this, "Buka Profil", Toast.LENGTH_SHORT).show(); true }
            else -> super.onOptionsItemSelected(item)
        }
    }
}