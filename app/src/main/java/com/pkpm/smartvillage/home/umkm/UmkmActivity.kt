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
            UMKM("UMKM 1", "Pemilik 1", "Harga 1", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 2", "Pemilik 2", "Harga 2", R.drawable.umkm, "https://wa.me/6283170334470"),
            UMKM("UMKM 3", "Pemilik 3", "Harga 3", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 4", "Pemilik 4", "Harga 4", R.drawable.umkm, "https://wa.me/6283170334470"),
            UMKM("UMKM 5", "Pemilik 5", "Harga 5", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 6", "Pemilik 6", "Harga 6", R.drawable.umkm, "https://wa.me/6283170334470"),
            UMKM("Kerupuk", "Pemilik 7", "Harga 7", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 8", "Pemilik 8", "Harga 8", R.drawable.umkm, "https://wa.me/6283170334470"),
            UMKM("UMKM 9", "Pemilik 9", "Harga 9", R.drawable.umkm, "https://wa.me/6285809781024"),
            UMKM("UMKM 10", "Pemilik 10", "Harga 10", R.drawable.umkm, "https://wa.me/6283170334470")
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
                // No action needed
            }
        })
        setupEdgeToEdge()

    }
    private fun setupEdgeToEdge() {
        enableEdgeToEdge()
        window.statusBarColor = getColor(R.color.white)
        hideNavigationBar()
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
