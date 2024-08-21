package com.pkpm.smartvillage.home.umkm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
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
            UMKM("Bubuk Cabai", "KWT Mawar Indah", "Rp. 15.000,00/botol", R.drawable.cabe, "https://wa.me/62895621754776"),
            UMKM("Rengginang", "Tuti Puji Astuti", "Rp. 35.000,00", R.drawable.rengginang, "https://wa.me/62895621754776"),
            UMKM("Coksula", "KWT Mawar Indah", "Rp. 15.000,00/botol", R.drawable.coksula, "https://wa.me/62895621754776"),
            UMKM("Gorengan, Pecel, Karedok, Soto, Ketoprak, Geblek", "Warung Kedai Yama", "Rp. 500,00 - 10.000,00", R.drawable.yama, "https://wa.me/62895385270457"),
            UMKM("Minuman Bubuk Jahe", "KWT Srikandi", " - ", R.drawable.umkm21, "https://wa.me/62895605899753"),
            UMKM("Perlengkapan Tani", "Saminem", "Rp. 5.000,00 - 200.000,00", R.drawable.saminem, "https://wa.me/628981732844"),
            UMKM("Craft, Snack, dan Cookies", "Andah Tatrawati", "-", R.drawable.umkm11, "https://wa.me/6288287807524"),
            UMKM("UMKM 8", "Pemilik 8", "Harga 8", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 9", "Pemilik 9", "Harga 9", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 10", "Pemilik 10", "Harga 10", R.drawable.umkm, "https://wa.me/6285809781024")
        )

        adapter = UMKMAdapter(umkmList)
        binding.recyclerView.adapter = adapter
        binding.edSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        setupEdgeToEdge()

    }
    private fun setupEdgeToEdge() {
        enableEdgeToEdge()
    }
    private fun hideNavigationBar() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                )
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideNavigationBar()
        }
    }

}
