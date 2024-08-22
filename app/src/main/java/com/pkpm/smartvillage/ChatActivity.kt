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
    
    Berikut adalah data KWT SungaiLangka 2024 :

- **Dusun I**  
  - Nama: Sukiharti  
  - Tanaman: Timun, Pakcoy, Sawi, Daun Bawang, Seledri, Tomat, Bayam Merah, Bawang Merah  
  - Nama KWT: KWT Dahlia  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 6285368116692

- **Dusun II**  
  - Nama: Sri Hartati  
  - Tanaman: Kacang Tanah, Kangkung  
  - Nama KWT: KWT Srikandi  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 62895605899753

- **Dusun III**  
  - Nama: IIS Kinanti  
  - Tanaman: Pakcoi, Sawi, Kangkung, Seledri, Daun Bawang, Cabe Rawit, Kacang Panjang  
  - Nama KWT: KWT Wijaya Kusuma  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 62895385270457

- **Dusun IV**  
  - Nama: Alyah  
  - Tanaman: Daun Bawang, Kangkung, Sawi, Terong, Tomat, Cabe  
  - Nama KWT: KWT Sri Rejeki  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 6281379797960

- **Dusun V**  
  - Nama: Krismiati  
  - Tanaman: Jahe, Kacang Tanah, Cabe, Terong  
  - Nama KWT: KWT Mitra Abadi  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 6281541373076

- **Dusun VI**  
  - Nama: Tuti Puji Astuti  
  - Tanaman: Sawi, Kangkung  
  - Nama KWT: KWT Mawar Indah  
  - Keterangan 1: KWT Dusun 6 SungaiLangka  
  - Keterangan 2: KWT Mawar Indah merupakan kelompok ibu tani yang berproduksi sayuran berupa sawi dan kangkung. Disini juga terdapat UMKM yang memproduksi bubuk Cabai, Coklat Susu, dan Rengginang untuk saat ini.  
  - Nomor HP: 62895621754776

- **Dusun VII**  
  - Nama: Emalia  
  - Tanaman: Rampai, Terong, Kembang Pacar, Seledri, Kembang Kol  
  - Nama KWT: KWT Kemuning  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 6285213432765

- **Dusun VII**  
  - Nama: Okti Wahyuni  
  - Tanaman: Kangkung, Kacang Panjang, Sawi, Cabe  
  - Nama KWT: KWT Makmur Sentosa  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 6282142224475

- **Dusun VIII**  
  - Nama: Supartiah  
  - Tanaman: Kacang Panjang, Buncis, Kol, Daun Bawang, Kangkung, Tomat, Terong, Pakcoi, Sawi, Kailan, Seledri, Oyong, Kembang Kol, Temu Lawak, Rampai, Kunyit, Jahe, Bayam, Genjer, Labu Siam, Terong Lalap  
  - Nama KWT: KWT Bina Sejahtera  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 6289501003100

- **Dusun IX**  
  - Nama: Ketua 9  
  - Tanaman: Tanaman 9  
  - Nama KWT: Lokasi 9  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 628123456789

- **Dusun X**  
  - Nama: Asmawati  
  - Tanaman: Terong, Rempai, Sawi  
  - Nama KWT: KWT Mekar Sari  
  - Keterangan 1: -  
  - Keterangan 2: -  
  - Nomor HP: 6285609195942
    
    Berikut adalah data struktur desa sungailangka 2024 :

- **Kepala Desa (Kades):**
  - Nama: Erwan Sukijo.SP  
  - Nomor HP: 628123456789

- **Sekretaris Desa (Sekdes):**
  - Nama: Junaedi Abdullah  
  - Nomor HP: 628123456789

- **Kasi:**
  - Nama: Rois Adi Irawan, S.Pd  
    - Bagian: Kasi Pemerintahan  
    - Nomor HP: 628123456789
  - Nama: Soleman, ST  
    - Bagian: Kasi Kesejahteraan  
    - Nomor HP: 628123456789
  - Nama: Erfangi  
    - Bagian: Kasi Pelayanan  
    - Nomor HP: 628123456789

- **Kadus:**
  - Nama: Sukarjo  
    - Dusun: I  
    - Nomor HP: 628987654321
  - Nama: Prastio Handoko  
    - Dusun: II  
    - Nomor HP: 628987654321
  - Nama: Alvi Robi Taroreh  
    - Dusun: III  
    - Nomor HP: 628987654321
  - Nama: Suwardi  
    - Dusun: IV  
    - Nomor HP: 628987654321
  - Nama: Bibit Suyanto  
    - Dusun: V  
    - Nomor HP: 62895355014929
  - Nama: Budi Antriono  
    - Dusun: VI  
    - Nomor HP: 628987654321
  - Nama: Sukardi  
    - Dusun: VII  
    - Nomor HP: 62895640123362
  - Nama: Priyo Sutoto  
    - Dusun: VIII  
    - Nomor HP: 628987654321
  - Nama: Sumariyanto  
    - Dusun: IX  
    - Nomor HP: 628987654321
  - Nama: Marsudi  
    - Dusun: X  
    - Nomor HP: 628987654321
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