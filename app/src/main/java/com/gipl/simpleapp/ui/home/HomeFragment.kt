package com.gipl.simpleapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gipl.simpleapp.R
import com.gipl.simpleapp.Utility.Status
import com.gipl.simpleapp.base.ViewModelFactory
import com.gipl.simpleapp.models.ApiUser
import com.gipl.simpleapp.ui.adapter.UserListItem
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(){

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory }
    private lateinit var adapter: UserListItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupViewModel()
        setupObserver()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter =
            UserListItem(
                arrayListOf()
            )
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.getUsers().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                   progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<ApiUser>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        /*
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory()).get(HomeViewModel::class.java)*/
    }

}