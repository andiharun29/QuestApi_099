package com.example.remotedatabase.container

import com.example.remotedatabase.Repository.MahasiswaRepository
import com.example.remotedatabase.Repository.NetworkMahasiswaRepository
import com.example.remotedatabase.Service.MahasiswaService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val mahasiswaRepository: MahasiswaRepository
}

