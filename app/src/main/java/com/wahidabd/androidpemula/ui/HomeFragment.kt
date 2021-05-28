package com.wahidabd.androidpemula.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.wahidabd.androidpemula.R
import com.wahidabd.androidpemula.adapter.DataAdapter
import com.wahidabd.androidpemula.databinding.FragmentHomeBinding
import com.wahidabd.androidpemula.model.Entity

class HomeFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
            val data = viewModel.getAllData()

            val adapter = DataAdapter()
            adapter.setData(data)

            with(binding.rvHome){
                setHasFixedSize(true)
                this.adapter = adapter
                layoutManager = LinearLayoutManager(context)
            }

            adapter.setOnItemClick(object : DataAdapter.OnItemClick{
                override fun onItemClicked(data: Entity) {
                    val toDetail = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data.id)
                    view.findNavController().navigate(toDetail)
                }
            })

            binding.fabAbout.setOnClickListener {
                Navigation.findNavController(binding.fabAbout).navigate(R.id.action_homeFragment_to_aboutFragment)
            }
        }
    }
}