package com.example.guidedbeertours.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.guidedbeertours.R
import com.example.guidedbeertours.databinding.FragmentHomeBinding

class HomeFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val binding=DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home, container, false)

        binding.tourButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_hometolist)
        }
        binding.favoriteButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_hometofavorite)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}