package com.example.remotedatabase.Repository

import com.example.remotedatabase.Service.MahasiswaService
import com.example.remotedatabase.model.Mahasiswa
import java.io.IOException

interface MahasiswaRepository{
    suspend fun getMahasiswa(): List<Mahasiswa>

    suspend fun getMahasiswaBynim(nim: String): Mahasiswa

    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    suspend fun deleteMahasiswa(nim: String)
}

