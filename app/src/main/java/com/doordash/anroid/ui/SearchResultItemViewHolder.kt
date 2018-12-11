package com.doordash.anroid.ui

import androidx.recyclerview.widget.RecyclerView
import com.doordash.anroid.databinding.ItemSearchResultBinding
import com.doordash.anroid.model.DoordashRestaurant

class SearchResultItemViewHolder(val binding: ItemSearchResultBinding) : RecyclerView.ViewHolder(binding.root) {

    fun favoriteItemClicked(entitySearchResult: DoordashRestaurant, listener: ItemCLickListener) {
        listener.onItemCLick(entitySearchResult)
        binding.executePendingBindings()
    }

}