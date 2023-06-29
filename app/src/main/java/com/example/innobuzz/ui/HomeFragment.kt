package com.example.innobuzz.ui

import android.graphics.Path.Direction
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.innobuzz.MyApplication
import com.example.innobuzz.R
import com.example.innobuzz.databinding.FragmentHomeBinding
import com.example.innobuzz.databinding.ListItemHomeBinding
import com.example.innobuzz.utils.ApiResult
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        viewModel.getUsers()

        viewModel.postLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {

                is ApiResult.Success -> {
                    val post = result.data
                    viewModel.saveListToLocalDatabase(post)
                    lifecycleScope.launch {
                        MyApplication.database.dao().insertData(viewModel.posts)
                    }
                    binding.recyclerView.adapter = HomeAdapter(post) { id ->
                        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
                        findNavController().navigate(action)
                    }
                }

                is ApiResult.Error -> {
                    val errorMessage = result.message
                }

                is ApiResult.Loading -> {

                }
            }
        }

    }
}