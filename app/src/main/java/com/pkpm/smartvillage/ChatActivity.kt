package com.pkpm.smartvillage

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.res.colorResource
import com.pkpm.smartvillage.databinding.ActivityChatBinding
import indie.jithinjude.dev.GeminiContent
import java.util.Locale

class ChatActivity : AppCompatActivity() {
    private var _binding: ActivityChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        window.statusBarColor = getColor(R.color.white)
        hideNavigationBar()
        binding.composeView.setContent {
            GeminiChatView(
                apiKey = "AIzaSyDQKICc9Ij_UMKa32lAJnv7SbEjY-8ihyI",
                appThemeColor = colorResource(R.color.blue_light2),
                chatContext = listOf(
                    GeminiContent(
                        role = "user",
                        text = """
                            Anda adalah sebuah bernamamodel yang digunakan sebagai program PKPM IIB darmajaya mendatang.
                            
                            Bagi IIB Darmajaya
                            Program PKPM ini memberikan wacana baru dengan perubahan paradigma bahwa mahasiswa dengan pengembangan kepribadian harus dapat memberikan umpan balik dalam pengembangan ilmu yang telah ditekuni serta memelihara kerjasama yang berkelanjutan dengan pemerintah daerah, khususnya pada daerah atau wilayah sasaran PKPM.
                            Bagi Mahasiswa
                            
                            Pengembangan kompetensi dalam diri mahasiswa diharapkan dapat mengimplementasikan ilmunya dan memberdayakan kemampuan yang langsung menyentuh kebutuhan masyarakat maupun pemerintah setempat. Dengan demikian, mahasiswa dapat menciptakan empati melalui program interaksi dan sosialisasi terhadap masyarakat desa sasaran.
                            
                            Bagi Masyarakat dan Pemerintah
                            Program ini memberikan kontribusi tenaga dan pemikiran untuk memajukan dan mengembangkan cara berpikir, sehingga dapat menciptakan usaha produktif di masyarakat desa sasaran. Program ini juga membuka peluang usaha dan meningkatkan potensi sumber daya manusia (SDM) guna mempercepat proses pembangunan serta meningkatkan tingkat kesejahteraan masyarakat desa sasaran.
                            
                            PKPM KELOMPOK 29, BERADA DI SUNGAI LANGKA, YANG ADA DI GEDONGTATAAN LAMPUNG
                            
                            
                            
                        """.trimIndent()

                    )
                )
            )
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
}