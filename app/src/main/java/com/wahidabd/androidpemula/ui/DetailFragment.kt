package com.wahidabd.androidpemula.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.wahidabd.androidpemula.R
import com.wahidabd.androidpemula.databinding.FragmentDetailBinding
import com.wahidabd.androidpemula.model.Entity

class DetailFragment : Fragment() {

    private lateinit var data: Entity
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
        val id = DetailFragmentArgs.fromBundle(arguments as Bundle).id

        viewModel.selectedId(id)
        data = viewModel.setData()

        with(binding){
            Glide.with(root)
                .load(data.img)
                .into(img)

            title.text = data.title
            level.text = "Level: ${data.level}"
            estimasi.text = "Estimasi: ${data.estimasi}"
            deskripsi.text = data.deskripsi

            toolbar.title = data.title

            toolbar.setNavigationOnClickListener {
                Navigation.findNavController(toolbar).navigate(R.id.action_detailFragment_to_homeFragment)
            }
        }
    }
}