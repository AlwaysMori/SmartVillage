package com.pkpm.smartvillage.home.struktur

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.pkpm.smartvillage.R
import com.pkpm.smartvillage.databinding.ActivityStrukturBinding

class StrukturActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStrukturBinding

    private lateinit var kadesAdapter: StrukturAdapter
    private lateinit var sekdesAdapter: StrukturAdapter
    private lateinit var kasiAdapter: StrukturAdapter
    private lateinit var kadusAdapter: StrukturAdapter

    private val kadesList = mutableListOf<Struktur>()
    private val kasiList = mutableListOf<Struktur>()
    private val sekdesList = mutableListOf<Struktur>()
    private val kadusList = mutableListOf<Struktur>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStrukturBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.navy)

        kadesList.apply {
            add(Struktur("Erwan Sukijo.SP", R.drawable.pns, "628123456789"))
        }

        sekdesList.apply {
            add(Struktur("Junaedi Abdullah", R.drawable.pns, "628123456789"))
        }

        kasiList.apply {
            add(Struktur("Rois Adi Irawan, S.Pd", R.drawable.pns, "628123456789", bagian = "Kasi Pemerintahan"))
            add(Struktur("Soleman, ST", R.drawable.pns, "628123456789", bagian = "Kasi Kesejahteraan"))
            add(Struktur("Erfangi", R.drawable.pns, "628123456789", bagian = "Kasi Pelayanan"))
        }

        kadusList.apply {
            add(Struktur("Sukarjo", R.drawable.pns, "628987654321", "I"))
            add(Struktur("Prastio Handoko", R.drawable.pns, "628987654321", "II"))
            add(Struktur("Alvi Robi Taroreh", R.drawable.pns, "628987654321", "III"))
            add(Struktur("Suwardi", R.drawable.pns, "628987654321", "IV"))
            add(Struktur("Bibit Suyanto", R.drawable.pns, "62895355014929", "V"))
            add(Struktur("Budi Antriono", R.drawable.pns, "628987654321", "VI"))
            add(Struktur("Sukardi", R.drawable.pns, "62895640123362", "VII"))
            add(Struktur("Priyo Sutoto", R.drawable.pns, "628987654321", "VIII"))
            add(Struktur("Sumariyanto", R.drawable.pns, "628987654321", "IX"))
            add(Struktur("Marsudi", R.drawable.pns, "628987654321", "X"))
        }


        binding.kadesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.kasiRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.sekdesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.kadusRecyclerView.layoutManager = LinearLayoutManager(this)

        kadesAdapter = StrukturAdapter(kadesList, false, false)
        sekdesAdapter = StrukturAdapter(sekdesList, false, false)
        kasiAdapter = StrukturAdapter(kasiList, false, true)
        kadusAdapter = StrukturAdapter(kadusList, true, false)

        binding.kadesRecyclerView.adapter = kadesAdapter
        binding.sekdesRecyclerView.adapter = sekdesAdapter
        binding.kadusRecyclerView.adapter = kadusAdapter
        binding.kasiRecyclerView.adapter = kasiAdapter

        binding.edSearch.addTextChangedListener { text ->
            val query = text.toString()
            kadesAdapter.filter(query)
            sekdesAdapter.filter(query)
            kadusAdapter.filter(query)
            kasiAdapter.filter(query)
        }
    }
}
