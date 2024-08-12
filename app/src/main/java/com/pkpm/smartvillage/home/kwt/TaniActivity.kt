package com.pkpm.smartvillage.home.kwt

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pkpm.smartvillage.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        enableEdgeToEdge()

        val items = listOf(
            KWTItem(
                "Dusun I",
                R.drawable.avatar,
                "Ketua 1",
                "Tanaman 1",
                "Lokasi 1",
                "Kontak 1",
                "Deskripsi 1",
                "628123456789"
            ),
            KWTItem(
                "Dusun II",
                R.drawable.avatar,
                "Ketua 2",
                "Tanaman 2",
                "Lokasi 2",
                "Kontak 2",
                "Deskripsi 2",
                "628123456789"
            ),
            KWTItem(
                "Dusun III",
                R.drawable.kwt3,
                "IIS Kinanti",
                "Pakcoi, Sawi, Kangkung, Seledri, Daun Bawang, Cabe Rawit, Kacang Panjang.",
                "KWT Wijaya Kusuma",
                "Kontak 3",
                "Deskripsi 3",
                "62895385270457"
            ),
            KWTItem(
                "Dusun IV",
                R.drawable.avatar,
                "Ketua 4",
                "Tanaman 4",
                "Lokasi 4",
                "Kontak 4",
                "Deskripsi 4",
                "628123456789"
            ),
            KWTItem(
                "Dusun V",
                R.drawable.avatar,
                "Ketua 5",
                "Tanaman 5",
                "Lokasi 5",
                "Kontak 5",
                "Deskripsi 5",
                "628123456789"
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
                "Kontak 7",
                "Deskripsi 7",
                "6285213432765"
            ), KWTItem(
                "Dusun VII",
                R.drawable.kwt72,
                "Okti Wahyuni",
                "Kangkung, Kacang Panjang, Sawi, Cabe",
                "KWT Makmur Sentosa",
                "Kontak 7",
                "Deskripsi 7",
                "6282142224475"
            ),
            KWTItem(
                "Dusun VIII",
                R.drawable.kwt8,
                "Supartiah",
                "Kacang Panjang, Buncis, Kol, Daun Bawang, Kangkung, Tomat, Terong, Pakcoi, Sawi, Kailan, Seledri, Oyong, Kembang Kol, Temu Lawak, Rampai, Kunyit, Jahe, Bayam, Genjer, Labu Siam, Terong Lalap.",
                "Lokasi 8",
                "Kontak 8",
                "Deskripsi 8",
                " 6289501003100"
            ),
            KWTItem(
                "Dusun IX",
                R.drawable.avatar,
                "Ketua 9",
                "Tanaman 9",
                "Lokasi 9",
                "Kontak 9",
                "Deskripsi 9",
                "628123456789"
            ),
            KWTItem(
                "Dusun X",
                R.drawable.avatar,
                "Ketua 10",
                "Tanaman 10",
                "Lokasi 10",
                "Kontak 10",
                "Deskripsi 10",
                "628123456789"
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
