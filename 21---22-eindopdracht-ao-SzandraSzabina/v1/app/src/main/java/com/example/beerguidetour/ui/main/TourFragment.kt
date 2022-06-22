package com.example.beerguidetour.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beerguidetour.R
import com.example.beerguidetour.data.Tour
import com.example.beerguidetour.databinding.FragmentTourBinding
import com.example.beerguidetour.ui.shared.SharedViewModel
import com.example.beerguidetour.ui.main.TourFragmentDirections.actionNavTourdetail

class TourFragment : Fragment()
{

    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: FragmentTourBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tour, container, false)
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = TourRecyclerAdapter(TourItemListener{
            viewModel.onTourClicked(it)
        })
        binding.recycleView.adapter = adapter
        val manager = LinearLayoutManager(activity)
        binding.recycleView.layoutManager = manager

        viewModel.tour.observe(viewLifecycleOwner, Observer{
            it?.let {
                navigateToTourDetail(it)
                viewModel.navigateToDetailFinished()
            }
        })

        binding.lifecycleOwner = this
        return binding.root
    }

    fun navigateToTourDetail(tour: Tour){
        requireView().findNavController().navigate(actionNavTourdetail(tour))
    }
}