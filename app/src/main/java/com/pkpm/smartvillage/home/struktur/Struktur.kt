package com.pkpm.smartvillage.home.struktur

data class Struktur(
    val nama: String,
    val masaJabatan: String,
    val gambar: Int,
    val nomorWa: String,
    val dusun: String? = null,
    val bagian: String? = null
)
