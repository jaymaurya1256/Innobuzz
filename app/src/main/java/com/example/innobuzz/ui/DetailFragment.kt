package com.example.innobuzz.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.innobuzz.R
import com.example.innobuzz.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()
    private val viewModel: DetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDetails(args.id)

        viewModel.postDetailLiveData.observe(viewLifecycleOwner) {
            binding.idDetail.text = "Id: " + it?.id.toString()
            binding.userIdDetail.text = "UserId: " + it?.userId.toString()
            binding.titleDetail.text = it?.title
            binding.bodyDetail.text = it?.body
        }
    }
}