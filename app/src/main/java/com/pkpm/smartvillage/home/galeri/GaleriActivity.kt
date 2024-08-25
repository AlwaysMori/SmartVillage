package com.pkpm.smartvillage.home.galeri

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pkpm.smartvillage.R


class GaleriActivity : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_galeri)
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            // Contoh data untuk galeri
            val items = listOf(
                GalleryAdapter.GalleryItem(R.drawable.slide3, "Tugu Masuk Desa SungaiLangka"),
                GalleryAdapter.GalleryItem(R.drawable.slide4, "Balai Desa SungaiLangka"),
                GalleryAdapter.GalleryItem(R.drawable.lapangan, "Lapangan Bola SungaiLangka"),
                GalleryAdapter.GalleryItem(R.drawable.voli, "Lapangan Voli SungaiLangka"),
                GalleryAdapter.GalleryItem(R.drawable.img_4, "Kolam Pemandian Pekon Janda"),
                GalleryAdapter.GalleryItem(R.drawable.img_5, "Camping Sukma Ilang")



            )

            window.statusBarColor = ContextCompat.getColor(this, R.color.navy)
            val adapter = GalleryAdapter(items, this)
            recyclerView.adapter = adapter
        }


    }


