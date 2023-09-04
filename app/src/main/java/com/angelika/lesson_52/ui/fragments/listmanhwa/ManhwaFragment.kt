package com.angelika.lesson_52.ui.fragments.listmanhwa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.angelika.lesoon_52.R
import com.angelika.lesoon_52.databinding.FragmentManhwaBinding
import com.angelika.lesson_52.ui.adapters.ManhwaAdapter

class ManhwaFragment : Fragment() {

    private var _binding: FragmentManhwaBinding? = null
    private val binding get()  = _binding!!
    private val manhwaAdapter = ManhwaAdapter()
    private val viewModel by viewModels<ManhwaViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManhwaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        subscribeToManhwas()
        getManhwas()
    }

    private fun initialize() {
        binding.rvManhwa.adapter = manhwaAdapter
    }

    private fun setupListeners() {
        transition()
    }

    private fun subscribeToManhwas() {
        viewModel.manhwa.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it.isLoading.toString()  , Toast.LENGTH_SHORT).show()
            Log.e("pon", it.toString())
            manhwaAdapter.setManhwas(it.success)
        }
    }

    private fun transition() = with(binding){
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_manhwaFragment_to_addManhwaFragment)
        }
    }

    private fun getManhwas() {
        viewModel.getManhwas()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}