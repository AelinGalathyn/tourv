package com.example.guidedbeertours.main.tours

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.guidedbeertours.model.TourItem
import com.example.guidedbeertours.databinding.FragmentTourItemBinding
import com.example.guidedbeertours.databinding.FragmentTourBinding
import com.example.guidedbeertours.main.tours.TourFragmentAdapter.*

import okhttp3.internal.Util

class TourFragmentAdapter(val clickListener: TourClickListener) :
    ListAdapter<TourItem, TourFragmentAdapter.ViewHolder>(ToDoDiffCallback()){



    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        return ViewHolder(FragmentTourItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }
    class ViewHolder (private var binding: FragmentTourItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(
            tourItem: TourItem,
            clickListener: TourClickListener
        ) {
            binding.tourItem = tourItem
            binding.clickListener = clickListener

            binding.executePendingBindings()
        }

    }
}


class ToDoDiffCallback: DiffUtil.ItemCallback<TourItem>(){
    override fun areItemsTheSame(oldItem: TourItem, newItem: TourItem): Boolean {
        return oldItem.Name_en == newItem.Name_en
    }

    override fun areContentsTheSame(oldItem: TourItem, newItem: TourItem): Boolean {
        return oldItem == newItem
    }
}

class TourClickListener(val clickListener: (tourItem: TourItem) -> Unit){
    fun onClick(tourItem: TourItem) = clickListener(tourItem)
}



