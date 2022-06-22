package com.example.guidedbeertours.main.tours

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guidedbeertours.R
import com.example.guidedbeertours.databinding.FragmentTourBinding
import com.example.guidedbeertours.model.TourItem

class TourFragment : Fragment() {

    private val viewModel: TourViewModel by viewModels()
    private lateinit var binding: FragmentTourBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tour, container, false)
        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        val adapter = TourFragmentAdapter(TourClickListener {
            viewModel.onTourClicked(it) })

        binding.recycleView.adapter = adapter

        val manager = LinearLayoutManager(activity)
        binding.recycleView.layoutManager = manager

        viewModel.tours.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it.toList())
            }
        })

        viewModel.tourItem.observe(viewLifecycleOwner, Observer {
            it?.let {
                navigateToTourItem(it!!)
                viewModel.navigateToDetailFinished()
            }
        })

        return binding.root
    }
    private fun navigateToTourItem(tourItem: TourItem){
        requireView().findNavController().navigate(TourFragmentDirections.actionListtodetails(tourItem))
    }
}
