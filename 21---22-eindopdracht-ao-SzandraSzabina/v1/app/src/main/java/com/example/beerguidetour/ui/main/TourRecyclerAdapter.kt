package com.example.beerguidetour.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.beerguidetour.data.Tour
import com.example.beerguidetour.databinding.TourGridItemBinding

class TourRecyclerAdapter(val clickListener: TourItemListener) :
    ListAdapter<Tour, TourRecyclerAdapter.ViewHolder>(ToDoDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: TourGridItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(
            tour: Tour,
            clickListener: TourItemListener
        )
        {
            binding.tour = tour
            binding.clickListener = clickListener

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TourGridItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }



}

class ToDoDiffCallback: DiffUtil.ItemCallback<Tour>(){
    override fun areItemsTheSame(oldItem: Tour, newItem: Tour): Boolean
    {
        return oldItem.Name_en==newItem.Name_en
    }

    override fun areContentsTheSame(oldItem: Tour, newItem: Tour): Boolean
    {
        return oldItem==newItem
    }
}

class TourItemListener(val itemListener: (tour: Tour) -> Unit){
    fun onClick(tour: Tour) = itemListener(tour)
}