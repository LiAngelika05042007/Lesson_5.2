package com.angelika.lesson_52.ui.fragments.addmanhwa

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.angelika.lesoon_52.R
import com.angelika.lesoon_52.databinding.FragmentAddManhwaBinding
import com.angelika.lesoon_52.databinding.FragmentManhwaBinding
import com.angelika.lesson_52.models.Manhwa
import com.angelika.lesson_52.ui.fragments.listmanhwa.ManhwaFragment

class AddManhwaFragment : Fragment() {

    private var _binding: FragmentAddManhwaBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<AddManhwaViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddManhwaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addManhwa()
    }

    private fun addManhwa() {
        binding.textReady.setOnClickListener {
            val url = binding.etLink.text.toString().trim()
            val name = binding.etName.text.toString().trim()
            val manhwa = Manhwa(name, url)

            binding.progress.isVisible = true
            binding.etLink.isVisible = false
            binding.etName.isVisible = false
            binding.textReady.isVisible = false
            viewModel.addManhwa(manhwa)

            android.os.Handler().postDelayed(
                {
                    findNavController().navigateUp()
                }, 3000
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}