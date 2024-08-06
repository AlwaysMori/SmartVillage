package com.pkpm.smartvillage


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.pkpm.smartvillage.databinding.ActivityMainBinding
import com.pkpm.smartvillage.home.about.AboutActivity
import com.pkpm.smartvillage.home.galeri.GaleriActivity
import com.pkpm.smartvillage.home.kegiatan.KegiatanActivity
import com.pkpm.smartvillage.home.kwt.TaniActivity
import com.pkpm.smartvillage.home.profil.ProfilActivity
import com.pkpm.smartvillage.home.struktur.StrukturActivity
import com.pkpm.smartvillage.home.umkm.UmkmActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pieChart: PieChart
    private lateinit var profesichart: PieChart

    private val slideInterval: Long = 3000
    private val handler = Handler(Looper.getMainLooper())

    private val runnable = object : Runnable {
        override fun run() {
            val currentItem = binding.bannerViewPager.currentItem
            val nextItem = if (adapter.itemCount - 1 == currentItem) 0 else currentItem + 1
            binding.bannerViewPager.setCurrentItem(nextItem, true)
            handler.postDelayed(this, slideInterval)
        }
    }

    private lateinit var adapter: BannerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupEdgeToEdge()
        setupPieChart()
        setupViewPager()
        setupClickListeners()
        setupProfesichart()
    }

    private fun setupEdgeToEdge() {
        enableEdgeToEdge()
        window.statusBarColor = getColor(R.color.blue_light2)
        hideNavigationBar()
    }
    private fun setupProfesichart() {
        profesichart = findViewById(R.id.profesichart)

        val pieEntries = listOf(
            PieEntry(30f, "Petani"),
            PieEntry(25f, "Pegawai"),
            PieEntry(20f, "PNS"),
            PieEntry(10f, "Lain")
        )

        val dataSet = PieDataSet(pieEntries, "").apply {
            colors = listOf(
                ContextCompat.getColor(this@MainActivity, R.color.green_light),
                ContextCompat.getColor(this@MainActivity, R.color.blue),
                ContextCompat.getColor(this@MainActivity, R.color.red),
                ContextCompat.getColor(this@MainActivity, R.color.yellow),
            )
        }

        profesichart.data = PieData(dataSet)

        // Set properties for profesichart
        profesichart.description.isEnabled = false
        profesichart.legend.isEnabled = true
        profesichart.setDrawEntryLabels(false)
        profesichart.animateY(1000)
    }
    private fun setupPieChart() {
        pieChart = findViewById(R.id.pieChart)

        val pieEntries = listOf(
            PieEntry(60f, "Pria"),
            PieEntry(40f, "Wanita")
        )

        val dataSet = PieDataSet(pieEntries, "").apply {
            colors = listOf(
                ContextCompat.getColor(this@MainActivity, R.color.red),
                ContextCompat.getColor(this@MainActivity, R.color.blue)
            )
        }

        pieChart.data = PieData(dataSet)

        // Set properties directly on the PieChart
        pieChart.description.isEnabled = false
        pieChart.legend.isEnabled = true
        pieChart.setDrawEntryLabels(false)
        pieChart.animateY(1000)
    }


    private fun setupViewPager() {
        val bannerImages = listOf(R.drawable.profil, R.drawable.avatar, R.drawable.img)
        adapter = BannerAdapter(bannerImages)
        binding.bannerViewPager.adapter = adapter
        handler.postDelayed(runnable, slideInterval)
    }

    private fun setupClickListeners() {
        binding.ai.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }


        binding.profil.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }

        binding.about.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        binding.umkm.setOnClickListener {
            val intent = Intent(this, UmkmActivity::class.java)
            startActivity(intent)
        }
        binding.struktur.setOnClickListener {
            val intent = Intent(this, StrukturActivity::class.java)
            startActivity(intent)
        }
        binding.kegiatan.setOnClickListener {
            val intent = Intent(this, KegiatanActivity::class.java)
            startActivity(intent)
        }
        binding.tani.setOnClickListener {
            val intent = Intent(this, TaniActivity::class.java)
            startActivity(intent)
        }
        binding.galeri.setOnClickListener {
            val intent = Intent(this, GaleriActivity::class.java)
            startActivity(intent)
        }
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
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}
