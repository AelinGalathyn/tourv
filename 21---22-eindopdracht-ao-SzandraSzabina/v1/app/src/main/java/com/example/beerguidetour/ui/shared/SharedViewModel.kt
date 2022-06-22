package com.example.beerguidetour.ui.shared

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beerguidetour.data.Tour

class SharedViewModel: ViewModel()
{
    private var _tour = MutableLiveData<Tour?>()
    val tour: LiveData<Tour?>
        get()
        {
            return _tour
        }

    fun onTourClicked(tour: Tour)
    {
        _tour.value = tour
    }

    fun navigateToDetailFinished()
    {
        _tour.value = null
    }
}