package com.pkpm.smartvillage.home.galeri

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pkpm.smartvillage.R

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GaleriActivity : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_galeri)
            enableEdgeToEdge()
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            // Contoh data untuk galeri
            val items = listOf(
                GalleryAdapter.GalleryItem(R.drawable.slide3, "Tugu Masuk Desa SungaiLangka"),
                GalleryAdapter.GalleryItem(R.drawable.slide4, "Balai Desa SungaiLangka"),
                GalleryAdapter.GalleryItem(R.drawable.lapangan, "Lapangan Bola SungaiLangka"),
                GalleryAdapter.GalleryItem(R.drawable.voli, "Lapangan Voli SungaiLangka")


            )

            val adapter = GalleryAdapter(items, this)
            recyclerView.adapter = adapter
        }
    }


