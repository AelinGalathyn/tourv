package com.example.guidedtours.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guidedtours.R

class TourListFragment : Fragment()
{

    companion object
    {
        fun newInstance() = TourListFragment()
    }

    private lateinit var viewModel: TourListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fragment_tour_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TourListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}