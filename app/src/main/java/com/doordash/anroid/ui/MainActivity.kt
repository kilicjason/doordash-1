package com.doordash.anroid.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.doordash.anroid.R
import com.doordash.anroid.base.BaseActivity
import com.doordash.anroid.databinding.ActivityMainBinding
import com.doordash.anroid.model.DoordashRestaurant
import com.doordash.anroid.util.LATITUDE
import com.doordash.anroid.util.LIMIT
import com.doordash.anroid.util.LONGITUDE
import com.doordash.anroid.util.OFFSET
import com.doordash.anroid.viewmodel.SearchResultListViewModel
import com.doordash.anroid.viewmodel.SearchResultListViewModelFactory
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


class MainActivity : BaseActivity(), ItemCLickListener {

    @Inject
    lateinit var viewModelFactory: SearchResultListViewModelFactory

    @Inject
    lateinit var viewModel: SearchResultListViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchResultListViewModel::class.java)
        setSupportActionBar(binding.toolbar)

        initUI(LATITUDE, LONGITUDE)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_favorite) {
            Snackbar.make(binding.recyclerViewResultList, getString(R.string.read_me), Snackbar.LENGTH_SHORT)
                .show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initUI(lat: Double, lng: Double, offset: Int = OFFSET, limit: Int = LIMIT) {
        binding.recyclerViewResultList.adapter = SearchResultAdapter(this)
        binding.viewModel = viewModel
        binding.welcome.setOnClickListener { binding.viewModel?.getRestaurantList(lat, lng, offset, limit) }
    }


    override fun onItemCLick(entitySearchResult: DoordashRestaurant) {
        val detail =
            if (entitySearchResult.address?.printableAddress.isNullOrBlank()) getString(R.string.nothing_to_show) else entitySearchResult.address?.printableAddress
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.details))
            .setMessage(detail)
            .setPositiveButton(getString(R.string.ok)) { dialogInterface, i -> }
            .setCancelable(true)
            .create()
            .show()
    }


}
