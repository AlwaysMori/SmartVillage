package com.pkpm.smartvillage.home.kegiatan

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.pkpm.smartvillage.R
import com.pkpm.smartvillage.databinding.ActivityKegiatanBinding

class KegiatanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKegiatanBinding
    private lateinit var adapter: KegiatanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.navy)
        binding = ActivityKegiatanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kegiatanList = listOf(
            Kegiatan(R.drawable.keg1, "Proses Pengemasan UMKM Coksula di KWT Mawar Indah", "Selasa, 06 Agustus 2024", "Mahasiswa PKPM turut serta dalam kegiatan pengemasan produk UMKM Coksula di KWT Mawar Indah. Proses pengemasan ini dilakukan dengan cermat untuk memastikan produk siap dipasarkan dengan tampilan yang menarik dan berkualitas. Melalui kegiatan ini, mahasiswa berperan aktif dalam mendukung pemberdayaan ekonomi lokal serta meningkatkan nilai tambah produk-produk UMKM di masyarakat."),
            Kegiatan(R.drawable.sos2, "Sosialisasi SD Kelas 5 Terkait Bullying", "Jumat, 09 Agustus 2024", "Hari ini, siswa kelas 5 mendapatkan pembekalan penting tentang bullying. Melalui kegiatan sosialisasi ini, diharapkan siswa lebih memahami dampak negatif dari bullying dan belajar untuk saling menghargai serta menghormati sesama. Mari bersama-sama ciptakan lingkungan sekolah yang aman, nyaman, dan bebas dari bullying!"),
            Kegiatan(R.drawable.pan1, "Ikut Serta Menjadi Panitia Pada Lomba 17 Agustus di dusun 3", "Senin, 12 Agustus 2024", "Menjelang perayaan Hari Kemerdekaan, panitia di Dusun 3 berkumpul untuk mempersiapkan hadiah-hadiah menarik bagi para pemenang lomba 17 Agustus. Bersama-sama, kami membungkus kado dengan penuh semangat dan kebersamaan, demi memeriahkan acara dan menyebarkan kegembiraan kepada semua peserta. Semoga perayaan kali ini menjadi momen yang penuh makna dan kebahagiaan bagi seluruh warga dusun!"),
            Kegiatan(R.drawable.sos1, "Sosialisasi SD Kelas 6 Terkait Menjaga Lingkungan", "Selasa, 13 Agustus 2024", "Hari ini, siswa kelas 6 belajar tentang pentingnya menjaga lingkungan melalui sosialisasi yang penuh inspirasi. Dalam kegiatan ini, mereka diajak untuk menjadi pahlawan lingkungan dengan melakukan tindakan sederhana namun berdampak besar, seperti mengurangi sampah, menanam pohon, dan menjaga kebersihan sekitar. Ayo, jadilah pahlawan lingkungan demi masa depan yang lebih hijau dan sehat!"),
            Kegiatan(R.drawable.cat1, "Melakukan Pengecatan Ulang Gardu Dusun 3 Jelang Kemerdekaan", "Rabu, 14 Agustus 2024", "Mahasiswa PKPM dengan semangat gotong royong melakukan pengecatan ulang gardu di Dusun 3 sebagai persiapan menyambut Hari Kemerdekaan. Dengan warna-warna yang lebih cerah, gardu kini menjadi simbol kebanggaan dan semangat nasionalisme yang terus menyala. Aksi ini tidak hanya mempercantik lingkungan, tetapi juga menjadi bukti nyata kontribusi mahasiswa dalam menjaga dan merayakan nilai-nilai kemerdekaan di masyarakat."),
            Kegiatan(R.drawable.sosumkm, "Sosialisasi dari Dosen Kampus Darmajaya ke UMKM Desa Sungai Langka", "Kamis, 15 Agustus 2024", "Dalam rangka pemberdayaan ekonomi desa, dosen dari Kampus Darmajaya mengadakan sosialisasi kepada para pelaku UMKM di Desa Sungai Langka. Kegiatan ini bertujuan untuk memberikan wawasan dan strategi dalam mengembangkan usaha, meningkatkan kualitas produk, serta memanfaatkan teknologi digital untuk memperluas pasar. Kehadiran dosen memberikan motivasi dan pengetahuan baru yang sangat berharga bagi kemajuan UMKM di desa ini."),
            Kegiatan(R.drawable.tujubelas, "Ikut Serta menjadi Panitia 17 Agustus dan memeriahkannya", "Sabtu, 17 Agustus 2024", "Mahasiswa PKPM dengan penuh semangat bergabung sebagai panitia dalam perayaan Hari Kemerdekaan 17 Agustus di Dusun 3. Bersama dengan warga, mereka berperan aktif dalam mempersiapkan berbagai lomba dan acara hiburan untuk memeriahkan momen bersejarah ini. Keterlibatan mereka tidak hanya menambah keceriaan acara, tetapi juga memperkuat ikatan antara mahasiswa dan masyarakat. Dengan gotong royong dan kebersamaan, perayaan 17 Agustus tahun ini menjadi lebih meriah dan penuh makna."),
            Kegiatan(R.drawable.bultang, "Pembentukan Panitia Bulutangkis SULA Cup 2024", "Senin, 19 Agustus 2024", "Untuk menyukseskan perhelatan SULA Cup 2024, mahasiswa PKPM bersama warga Desa Sungai Langka mengadakan rapat pembentukan panitia bulutangkis. Dengan semangat kebersamaan, panitia dibentuk untuk memastikan jalannya turnamen dengan lancar dan meriah. Setiap anggota panitia siap memberikan kontribusi terbaik mereka dalam mempersiapkan segala kebutuhan acara, mulai dari pendaftaran peserta hingga penyediaan hadiah. SULA Cup 2024 diharapkan menjadi ajang yang tidak hanya mengasah kemampuan, tetapi juga mempererat persatuan dan semangat olahraga di desa."),

        )




        adapter = KegiatanAdapter(kegiatanList)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.edSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
