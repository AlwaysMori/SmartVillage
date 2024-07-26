package com.pkpm.smartvillage.home.umkm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pkpm.smartvillage.R
import com.pkpm.smartvillage.databinding.ActivityUmkmBinding

class UmkmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUmkmBinding
    private lateinit var adapter: UMKMAdapter
    private lateinit var umkmList: List<UMKM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUmkmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        umkmList = listOf(
            UMKM("UMKM 1", "Pemilik 1", "Harga 1", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 2", "Pemilik 2", "Harga 2", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 3", "Pemilik 3", "Harga 3", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 4", "Pemilik 4", "Harga 4", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 5", "Pemilik 5", "Harga 5", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 6", "Pemilik 6", "Harga 6", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("Kerupuk", "Pemilik 7", "Harga 7", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 8", "Pemilik 8", "Harga 8", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 9", "Pemilik 9", "Harga 9", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 10", "Pemilik 10", "Harga 10", R.drawable.umkm, "https://wa.me/6285809781024")
        )

        adapter = UMKMAdapter(umkmList)
        binding.recyclerView.adapter = adapter

        // Implementing TextWatcher to filter the list
        binding.edSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Filter the list as text changes
                adapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                // No action needed
            }
        })
    }
}
