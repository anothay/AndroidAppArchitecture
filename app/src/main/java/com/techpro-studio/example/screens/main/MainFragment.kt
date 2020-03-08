package com.wolvesstudio.example.screens.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.wolvesstudio.example.R
import com.wolvesstudio.example.screens.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment: Fragment() {

    private val mainViewModel: MainViewModel by viewModel()
    private val adapter = ModelListAdapter()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler.adapter = adapter

        adapter.onItemClickListener = { item ->
            this.showDetail(item.id)
        }

        refresher.setOnRefreshListener {
            mainViewModel.refresh()
            refresher.isRefreshing = false
        }

        mainViewModel.list.observe(this, Observer { values ->
            adapter.list = values
            adapter.notifyDataSetChanged()
        })
    }

    private fun showDetail(id: String) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("id", id)
        activity!!.startActivity(intent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}