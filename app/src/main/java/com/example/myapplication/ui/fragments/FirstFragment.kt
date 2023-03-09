package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.model.CatModel
import com.example.myapplication.ui.adapter.CatAdapter
import com.example.myapplication.ui.viewModel.CatViewModel

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
        setUpListeners()
        clear()
        initialization()
    }

    private fun setUpListeners() {
        binding.btn.setOnClickListener{
            binding.btn.isInvisible = true
            binding.rvCat.isInvisible = false
        }
    }

    private fun clear() {
        listCat.clear()
    }

    private fun initialization() {
        viewModel?.let { listCat.addAll(it.getListOfCatHTP())}
        binding.rvCat.adapter = adapterCat
    }

    private fun onItemClick(modelCat:CatModel) {
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToDetailFragment(
            modelCat.image,
            modelCat.name)
        )
    }
}
