package com.example.beerguidetour.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beerguidetour.data.Tour
import java.lang.IllegalArgumentException

class TourDetailModelFactory(private val tour: Tour):
    ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(TourDetailModel::class.java)){
            return TourDetailModel(tour) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}