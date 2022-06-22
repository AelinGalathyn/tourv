package com.example.guidedbeertours.main.tours

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.guidedbeertours.data.TourAPI
import com.example.guidedbeertours.model.TourItem
import kotlinx.coroutines.launch

class TourViewModel : ViewModel() {

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
    val tourItem : LiveData<TourItem?>
        get() {
            return _tour
        }

    private var _tours = MutableLiveData<List<TourItem>?>()
    public val tours: LiveData<List<TourItem>?> = _tours

    init{
        _error.value = ""
        _loadingFinished.value = false
        viewModelScope.launch {
            try{
                _tours .value = TourAPI.retrofitService.getTourList()
                _loadingFinished.value = true
            } catch (e: Exception){
                _error.value = e.localizedMessage
                _tours.value = listOf()
            }
        }

    }
    fun onTourClicked(tourItem: TourItem){
        _tour.value = tourItem
    }

    fun navigateToDetailFinished() {
        _tour.value = null
    }
}