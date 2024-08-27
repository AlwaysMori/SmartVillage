package com.pkpm.smartvillage.home.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pkpm.smartvillage.R
import com.pkpm.smartvillage.databinding.ActivitySosmedBinding

class SosmedActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySosmedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySosmedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.navy)

        binding.instagramCard.setOnClickListener {
            openUrl(getString(R.string.instagram_url))
        }

        binding.tiktokCard.setOnClickListener {
            openUrl(getString(R.string.tiktok_url))
        }

        binding.webCard.setOnClickListener {
            openUrl(getString(R.string.web_url))
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
