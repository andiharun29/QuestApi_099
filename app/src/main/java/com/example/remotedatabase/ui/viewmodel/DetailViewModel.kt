package com.example.remotedatabase.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remotedatabase.Repository.MahasiswaRepository
import com.example.remotedatabase.model.Mahasiswa
import kotlinx.coroutines.launch



data class DetailUiState(
    val detailUiEvent: InsertUiEvent = InsertUiEvent(),
    val isLoding: Boolean = false,
    val isError: Boolean = false,
    val errorMessages: String = ""
){
    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != InsertUiEvent()
}

fun Mahasiswa.toDetailUiEvent(): InsertUiEvent{
    return InsertUiEvent(
        nim = nim,
        nama = nama,
        alamat = alamat,
        jeniskelamin = jeniskelamin,
        kelas = kelas,
        angkatan = angkatan
    )
}