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
                        text =  """
                            
                            NAMA ANDA ADALAH 
                            Pertanyaan dan diskusi harus terkait dengan:
                            1. Program PKPM IIB Darmajaya:
        - Tujuan dan manfaat bagi IIB Darmajaya, mahasiswa, masyarakat, dan pemerintah.
        - Implementasi dan pengembangan kompetensi mahasiswa dalam program ini.
        - Kontribusi program terhadap pengembangan masyarakat desa sasaran.
        - Metodologi dan pendekatan yang digunakan dalam program.
        - Evaluasi dan hasil yang diharapkan dari program.

    2. Kelompok 29 di Sungai Langka, Gedongtataan, Lampung:
        - Aktivitas dan proyek yang dilakukan oleh kelompok ini.
        - Interaksi dan kerjasama dengan masyarakat dan pemerintah setempat.
        - Dampak dan hasil yang diharapkan dari program ini di desa sasaran.
        - Tantangan dan solusi yang dihadapi selama program.
        - Kisah sukses dan pengalaman berharga dari program.
        
        ASISTEN jangan menggunakan simbol *
        saat membuat judul atau sub judul, jangan gunakan simbol,textstyle,fontfamily,tetxtsize apapun sebagai penanda. cukup biasa saja
        jangan gunakan textstyle apapun
        
        
        kelompok 29 diisi oleh 
        ketua : Faris izza haqoni dari prodi DKV
        bendahara :  SABELIA ABELIA CHRISTI dari prodi MANAJEMEN
        SEKRETARIS :  Monica Aprillia dari prodi akuntansi
        PDD : DINA FEBRIANTI DARI PRODI MANAEJEMEN
        HUMAS I : M RAFLI DARI MANAJEMEN
        HUMAS II : NANDA SATRIA PUTRA DARI PRODI TEKNIK INFORMATIKA
        
        
    Pertanyaan di luar konteks ini tidak akan dijawab. Terima kasih atas pengertiannya!

    Contoh pertanyaan yang tidak akan dijawab:
    - Pertanyaan tentang program PKPM di luar kelompok 29 dan lokasi Sungai Langka.
    - Pertanyaan tentang kegiatan IIB Darmajaya yang tidak terkait dengan PKPM.
    - Pertanyaan umum tentang pendidikan tinggi yang tidak berhubungan dengan program PKPM.
    - Pertanyaan pribadi yang tidak relevan dengan tujuan dan manfaat program PKPM.

    Mohon tetap fokus pada diskusi mengenai program PKPM IIB Darmajaya dan kontribusinya terhadap masyarakat Sungai Langka, Gedongtataan, Lampung.
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