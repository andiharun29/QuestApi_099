package com.example.remotedatabase.model

import kotlinx.serialization.Serializable

@Serializable
data class Mahasiswa(
    val nim: String,
    val nama: String,
    val jeniskelamin: String,
    val alamat: String,
    val kelas: String,
    val angkatan: String
)
