package com.example.beerguidetour.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beerguidetour.data.Tour

class TourDetailModel(__tour: Tour) :ViewModel()
{
    private var _tour=MutableLiveData<Tour>()
    val tour:LiveData<Tour>
    get()
    {
        return _tour
    }

    init
    {
        _tour.value = __tour
    }
}