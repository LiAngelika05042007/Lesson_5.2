package com.angelika.lesson_52.ui.fragments.listmanhwa

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.angelika.lesson_52.models.Manhwa
import com.angelika.lesson_52.models.repositories.ManhwaRepository

class ManhwaViewModel: ViewModel() {
    private val repository = ManhwaRepository()

    private val _manhwaLiveData = MutableLiveData(ManwhaUiState())
    val manhwa: LiveData<ManwhaUiState> = _manhwaLiveData

    fun getManhwas() {
        val data = repository.getManhwas()

        Handler().postDelayed(
            {
                val newValue = _manhwaLiveData.value?.copy(isLoading = false, success = data)
                _manhwaLiveData.value = newValue
            },3000
        )
    }

}
data class ManwhaUiState(
    val isLoading: Boolean = true,
    val error: String = "Error",
    val success: List<Manhwa> = emptyList()
)