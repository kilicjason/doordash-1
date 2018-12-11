package com.doordash.anroid.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.doordash.anroid.R
import com.doordash.anroid.databinding.ItemSearchResultBinding
import com.doordash.anroid.model.DoordashRestaurant

/**
 * Adapter to display the list items.
 */

class SearchResultAdapter(private var listener: ItemCLickListener) : PagedListAdapter<DoordashRestaurant,
        SearchResultItemViewHolder>(RESTAURANT_COMPARATOR) {

    private var resultList = mutableListOf<DoordashRestaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemSearchResultBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_search_result, parent, false)
        return SearchResultItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return resultList?.size ?: 0
    }

    override fun onBindViewHolder(holder: SearchResultItemViewHolder, position: Int) {
        holder.binding.doordashRestaurant = resultList[position]
        holder.binding.executePendingBindings()

        holder.binding.root.setOnClickListener {
            holder.favoriteItemClicked(resultList[position], listener)
        }
    }

    fun submitList(entitySearchResultList: List<DoordashRestaurant>) {
        this.resultList.addAll(entitySearchResultList)
        notifyDataSetChanged()
    }


    companion object {
        val RESTAURANT_COMPARATOR = object : DiffUtil.ItemCallback<DoordashRestaurant>() {
            override fun areContentsTheSame(oldItem: DoordashRestaurant, newItem: DoordashRestaurant): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: DoordashRestaurant, newItem: DoordashRestaurant): Boolean =
                oldItem.name == newItem.name


        }
    }
}

interface ItemCLickListener {
    fun onItemCLick(entitySearchResult: DoordashRestaurant)
}