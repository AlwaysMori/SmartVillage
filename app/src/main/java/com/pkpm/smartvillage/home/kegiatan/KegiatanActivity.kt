package com.pkpm.smartvillage.home.kegiatan

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pkpm.smartvillage.R

class KegiatanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kegiatan)
        enableEdgeToEdge()

        val kegiatanList = listOf(
            Kegiatan(R.drawable.avatar, "Judul Kegiatan 1", "Tanggal 1", "Caption Kegiatan 1"),
            Kegiatan(R.drawable.avatar, "Judul Kegiatan 2", "Tanggal 2", "Caption Kegiatan 2"),
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = KegiatanAdapter(kegiatanList)
    }
}
