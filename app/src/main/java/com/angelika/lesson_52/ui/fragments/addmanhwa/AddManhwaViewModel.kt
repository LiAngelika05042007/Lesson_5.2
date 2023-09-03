package com.angelika.lesson_52.ui.fragments.addmanhwa

import androidx.lifecycle.ViewModel
import com.angelika.lesson_52.models.Manhwa
import com.angelika.lesson_52.models.repositories.ManhwaRepository

class AddManhwaViewModel: ViewModel() {

    private val repository = ManhwaRepository()

    fun addManhwa(manhwa: Manhwa){
        repository.addManhwa(manhwa)
    }
}
