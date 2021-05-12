package com.iamshekhargh.mypizzaapp.ui.dashboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iamshekhargh.mypizzaapp.R
import com.iamshekhargh.mypizzaapp.databinding.RvItemPromotinBinding
import com.iamshekhargh.mypizzaapp.models.PromotionalOfferModel

class PromotionalOffersAdapter :
    ListAdapter<PromotionalOfferModel, PromotionalOffersAdapter.PromotionalOfferViewHolder>(
        AreItemsDifferent()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionalOfferViewHolder {
        val b = RvItemPromotinBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PromotionalOfferViewHolder(b)
    }

    override fun onBindViewHolder(holder: PromotionalOfferViewHolder, position: Int) {
        val item: PromotionalOfferModel = getItem(position)
        holder.bind(item)
    }

    class PromotionalOfferViewHolder(private val binding: RvItemPromotinBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PromotionalOfferModel) {

            binding.apply {
                Glide.with(binding.root).load(item.url)
                    .placeholder(R.drawable.placeholder_banner_logo_img)
                    .into(rvItemImageviewPromotion)
            }
        }
    }

    class AreItemsDifferent : DiffUtil.ItemCallback<PromotionalOfferModel>() {

        override fun areItemsTheSame(
            oldItem: PromotionalOfferModel,
            newItem: PromotionalOfferModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PromotionalOfferModel,
            newItem: PromotionalOfferModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}