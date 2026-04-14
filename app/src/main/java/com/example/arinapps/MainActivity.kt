package com.example.arinapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.arinapps.databinding.ActivityMainBinding
import com.example.arinapps.pertemuan_4.FourthActivity
import com.example.arinapps.pertemuan_5.FifthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengaktifkan tampilan Edge-to-Edge
        enableEdgeToEdge()

        // Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur Padding agar konten tidak tertutup System Bars (Status Bar/Navigation Bar)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navigasi ke Pertemuan 4 dengan mengirimkan Data Intent
        binding.btnPertemuan4.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)

            // Mengirim data tambahan ke FourthActivity
            intent.putExtra("nama", "Politeknik Caltex Riau")
            intent.putExtra("asal", "Rumbai")
            intent.putExtra("usia", 25)

            startActivity(intent)
        }

        // Navigasi ke Pertemuan 5
        binding.btnPertemuan5.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }
    }
}