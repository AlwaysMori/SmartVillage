package com.pkpm.smartvillage.home.kwt

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pkpm.smartvillage.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.pkpm.smartvillage.databinding.ActivityMainBinding
import com.pkpm.smartvillage.databinding.ActivityTaniBinding

class TaniActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaniBinding
    private lateinit var adapter: KWTAdapter
    private lateinit var items: List<KWTItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaniBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.navy)

        val items = listOf(
            KWTItem(
                "Dusun I",
                R.drawable.kwt1,
                "Sukiharti",
                "Timun, Pakcoy, Sawi, Daun Bawang, Seledri, Tomat, Bayam Merah, Bawang Merah",
                "KWT Dahlia",
                " - ",
                " - ",
                "6285368116692"
            ),
            KWTItem(
                "Dusun II",
                R.drawable.kwt2,
                "Sri Hartati",
                "Kacang Tanah, Kangkung",
                "KWT Srikandi",
                " - ",
                " - ",
                "62895605899753"
            ),
            KWTItem(
                "Dusun III",
                R.drawable.kwt3,
                "IIS Kinanti",
                "Pakcoi, Sawi, Kangkung, Seledri, Daun Bawang, Cabe Rawit, Kacang Panjang.",
                "KWT Wijaya Kusuma",
                " - ",
                " - ",
                "62895385270457"
            ),
            KWTItem(
                "Dusun IV",
                R.drawable.kwt4,
                "Alyah",
                "Daun Bawang, Kangkung, Sawi, Terong, Tomat, Cabe",
                "KWT Sri Rejeki",
                " - ",
                " - ",
                "6281379797960"
            ),
            KWTItem(
                "Dusun V",
                R.drawable.kwt5,
                "Krismiati",
                "Jahe, Kacang Tanah, Cabe, Terong",
                "KWT Mitra Abadi",
                " - ",
                " - ",
                "6281541373076"
            ),
            KWTItem(
                "Dusun VI",
                R.drawable.kwt6,
                "Tuti Puji Astuti",
                "Sawi, Kangkung",
                "KWT Mawar Indah",
                "KWT Dusun 6 SungaiLangka",
                "KWT Mawar Indah merupakan kelompok ibu tani yang berproduksi sayuran berupa sawi dan kangkung. Disini juga terdapat UMKM yang memproduksi bubuk Cabai, Coklat Susu, dan Rengginang untuk saat ini.",
                "62895621754776"
            ),
            KWTItem(
                "Dusun VII",
                R.drawable.avatar,
                "Emalia",
                "Rampai, Terong, Kembang Pacar, Seledri, Kembang Kol.",
                "KWT Kemuning",
                " - ",
                " - ",
                "6285213432765"
            ), KWTItem(
                "Dusun VII",
                R.drawable.kwt72,
                "Okti Wahyuni",
                "Kangkung, Kacang Panjang, Sawi, Cabe",
                "KWT Makmur Sentosa",
                " - ",
                " - ",
                "6282142224475"
            ),
            KWTItem(
                "Dusun VIII",
                R.drawable.kwt8,
                "Supartiah",
                "Kacang Panjang, Buncis, Kol, Daun Bawang, Kangkung, Tomat, Terong, Pakcoi, Sawi, Kailan, Seledri, Oyong, Kembang Kol, Temu Lawak, Rampai, Kunyit, Jahe, Bayam, Genjer, Labu Siam, Terong Lalap.",
                "KWT Bina Sejahtera",
                " - ",
                " - ",
                " 6289501003100"
            ),
            KWTItem(
                "Dusun IX",
                R.drawable.avatar,
                "Ketua 9",
                "Tanaman 9",
                "Lokasi 9",
                " - ",
                " - ",
                "628123456789"
            ),
            KWTItem(
                "Dusun X",
                R.drawable.kwt10,
                "Asmawati",
                "Terong, Rempai, Sawi",
                "KWT Mekar Sari",
                " - ",
                " - ",
                "6285609195942"
            )
        )


        adapter = KWTAdapter(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.edSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter.filter(s)
            }

            override fun afterTextChanged(s: Editable?) {}
        })


    }

}
