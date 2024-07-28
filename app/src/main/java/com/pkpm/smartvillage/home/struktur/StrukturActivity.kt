package com.pkpm.smartvillage.home.struktur

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.pkpm.smartvillage.R
import com.pkpm.smartvillage.databinding.ActivityStrukturBinding

class StrukturActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStrukturBinding

    private lateinit var kadesAdapter: StrukturAdapter
    private lateinit var sekdesAdapter: StrukturAdapter
    private lateinit var kadusAdapter: StrukturAdapter

    private val kadesList = mutableListOf<Struktur>()
    private val sekdesList = mutableListOf<Struktur>()
    private val kadusList = mutableListOf<Struktur>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStrukturBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        kadesList.apply {
            add(Struktur("Nama", "Jabatan", R.drawable.avatar, "628123456789"))
        }

        sekdesList.apply {
            add(Struktur("Nama", "Jabatan", R.drawable.avatar, "628123456789"))
        }

        kadusList.apply {

            add(Struktur("ahmad ", "Jabatan", R.drawable.avatar, "628987654321", "I"))
            add(Struktur("jono ", "Jabatan", R.drawable.avatar, "628987654321", "II"))
            add(Struktur("bima ", "Jabatan", R.drawable.avatar, "628987654321", "III"))
            add(Struktur("sion ", "Jabatan", R.drawable.avatar, "628987654321", "IV"))
            add(Struktur("lala ", "Jabatan", R.drawable.avatar, "628987654321", "V"))
            add(Struktur("nanda ", "Jabatan", R.drawable.avatar, "628987654321", "VI"))
            add(Struktur("soni ", "Jabatan", R.drawable.avatar, "628987654321", "VII"))
            add(Struktur("bian ", "Jabatan", R.drawable.avatar, "628987654321", "VIII"))
            add(Struktur("roni ", "Jabatan", R.drawable.avatar, "628987654321", "IX"))
            add(Struktur("Iwan ", "Jabatan", R.drawable.avatar, "628987654321", "X"))

        }

        binding.kadesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.sekdesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.kadusRecyclerView.layoutManager = LinearLayoutManager(this)

        kadesAdapter = StrukturAdapter(kadesList, false)
        sekdesAdapter = StrukturAdapter(sekdesList, false)
        kadusAdapter = StrukturAdapter(kadusList, true)

        binding.kadesRecyclerView.adapter = kadesAdapter
        binding.sekdesRecyclerView.adapter = sekdesAdapter
        binding.kadusRecyclerView.adapter = kadusAdapter

        binding.edSearch.addTextChangedListener { text ->
            val query = text.toString()
            kadesAdapter.filter(query)
            sekdesAdapter.filter(query)
            kadusAdapter.filter(query)
        }
    }
}
