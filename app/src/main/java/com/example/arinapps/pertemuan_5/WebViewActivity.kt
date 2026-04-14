package com.example.arinapps.pertemuan_5

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.arinapps.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            // Matikan judul default agar tidak menutupi gambar Barbie
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
        }

        binding.webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://merdeka.com")

            // Improvisasi: ToolBar hide/show otomatis saat web di scroll
            setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
                if (scrollY > oldScrollY) binding.appBar.setExpanded(false, true)
                else if (scrollY < oldScrollY) binding.appBar.setExpanded(true, true)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            finish()
        }
        return true
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) binding.webView.goBack()
        else super.onBackPressed()
    }
}