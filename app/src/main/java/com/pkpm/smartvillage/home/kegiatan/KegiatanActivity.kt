package com.pkpm.smartvillage.home.kegiatan

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pkpm.smartvillage.R
import com.pkpm.smartvillage.databinding.ActivityKegiatanBinding

class KegiatanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKegiatanBinding
    private lateinit var adapter: KegiatanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityKegiatanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kegiatanList = listOf(
            Kegiatan(R.drawable.avatar, "Judul Kegiatan 1", "Tanggal 1", "Caption Kegiatan 1"),
            Kegiatan(R.drawable.avatar, "Judul Kegiatan 2", "Tanggal 2", "Caption Kegiatan 2"),
        )

        adapter = KegiatanAdapter(kegiatanList)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.edSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
