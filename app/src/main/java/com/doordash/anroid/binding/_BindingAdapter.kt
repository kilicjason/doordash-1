package com.doordash.anroid.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.doordash.anroid.R
import com.doordash.anroid.model.DoordashRestaurant
import com.doordash.anroid.ui.SearchResultAdapter


@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, imgUrl: String?) {
    Glide.with(view.context).load(imgUrl).apply(RequestOptions().placeholder(R.drawable.ic_restaurant_placeholder))
        .into(view)
}

@BindingAdapter("setRestaurants")
fun setRestaurants(view: RecyclerView, restaurants: List<DoordashRestaurant>?) {
    restaurants?.apply {
        (view.adapter as SearchResultAdapter).apply {
            submitList(restaurants)
            notifyDataSetChanged()
        }
    }
}

@BindingAdapter("isVisibleOrGone")
fun bindVisibility(view: View, isVisible: Boolean) {
    view?.visibility = if (isVisible) View.VISIBLE else View.GONE
}
