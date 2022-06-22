package com.example.guidedtours.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beercafesv1.services.TourAPIService
import com.example.beercafesv1.services.TourAPIService.retrofitService
import com.example.guidedtours.model.TourItem
import kotlinx.coroutines.launch
import java.lang.Exception

class TourListViewModel : ViewModel()
{
    private var _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() {
            return _error
        }
    private var _loadingFinished = MutableLiveData<Boolean>()
    val loadingFinished : LiveData<Boolean>
        get() {
            return _loadingFinished
        }
    private var _tour = MutableLiveData<TourItem?>()
    val tour : LiveData<TourItem?>
        get() {
            return _tour
        }

    private var _tours = MutableLiveData<List<TourItem>?>()
    val tours: LiveData<List<TourItem>?> = _tours

    init{
        _error.value = ""
        _loadingFinished.value = false
        viewModelScope.launch {
            try{
                _tours .value = TourAPIService.retrofitService.getTourList()
                _loadingFinished.value = true
            } catch (e: Exception){
                _error.value = e.localizedMessage
                _tours.value = listOf()
            }
        }

    }
    fun onCafeClicked(tourItem: TourItem){
        _tour.value = tourItem
    }

    fun navigateToDetailFinished() {
        _tour.value = null
    }
}