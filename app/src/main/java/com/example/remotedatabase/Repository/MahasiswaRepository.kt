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

class NetworkMahasiswaRepository(
    private val mahasiswaApiService: MahasiswaService
): MahasiswaRepository {
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        mahasiswaApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(nim)
            if (!response.isSuccessful) {
                throw IOException(
                    "Failed to delete mahasiswa. Http error code:" +
                            "${response.code()}"
                )
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> = mahasiswaApiService.getMahasiswa()

    override suspend fun getMahasiswaBynim(nim: String): Mahasiswa {
        return mahasiswaApiService.getMahasiswaBynim(nim)
    }
}