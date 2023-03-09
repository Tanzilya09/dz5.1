package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.model.CatModel
import com.example.myapplication.ui.adapter.CatAdapter

class FirstFragment : Fragment() {

    private var viewModel: CatViewModel? = null
    private val listCat = mutableListOf<CatModel>()
    private lateinit var binding: FragmentFirstBinding
    private var adapterCat = CatAdapter(listCat,this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CatViewModel::class.java]
        initialize()
        setUpList()
    }

    private fun initialize() {
        viewModel?.let { listCat.addAll(it.getListOfCatHTP()) }
        binding.rvCat.adapter = adapterCat
    }

    private fun setUpList() {
        binding.btn.setOnClickListener {
            binding.rvCat.isVisible = true
            binding.btn.isVisible = false
        }
    }

    private fun onItemClick(catModel: CatModel) {
        val action: NavDirections =
            FirstFragmentDirections.actionFirstFragmentToDetailFragment(
                catModel.name,
                catModel.image
            )
        findNavController().navigate(action)
    }

}
