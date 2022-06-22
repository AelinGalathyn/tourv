package com.example.beerguidetour.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.beerguidetour.databinding.FragmentTourDetailBinding
import com.example.beerguidetour.R

class TourDetailFragment : androidx.fragment.app.Fragment()
{
    private lateinit var binding: FragmentTourDetailBinding
    private lateinit var viewModel: TourDetailModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tour_detail, container, false)

        val tour = TourDetailFragmentArgs.fromBundle(requireArguments()).tour
        val guided = TourDetailModelFactory(tour)
        viewModel = ViewModelProvider(this, guided).get(TourDetailModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }
}