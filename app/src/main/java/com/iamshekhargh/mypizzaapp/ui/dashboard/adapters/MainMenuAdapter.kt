package com.iamshekhargh.mypizzaapp.ui.dashboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iamshekhargh.mypizzaapp.databinding.RvItemMainMenuBinding
import com.iamshekhargh.mypizzaapp.models.MainMenuItemModel

class MainMenuAdapter :
    ListAdapter<MainMenuItemModel, MainMenuAdapter.MainMenuItemViewHolder>(DiffUtilMainMenuItem()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuItemViewHolder {
        val view = RvItemMainMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MainMenuItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainMenuItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class MainMenuItemViewHolder(binding: RvItemMainMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MainMenuItemModel) {

        }

    }

    class DiffUtilMainMenuItem : DiffUtil.ItemCallback<MainMenuItemModel>() {
        override fun areItemsTheSame(
            oldItem: MainMenuItemModel,
            newItem: MainMenuItemModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MainMenuItemModel,
            newItem: MainMenuItemModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}