package com.example.myapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.model.CatModel
import com.example.myapplication.ui.adapter.CatAdapter
@Suppress("CAST_NEVER_SUCCEEDS")
class FirstFragment : Fragment() {

    private var viewModel: FirstViewModel? = null
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
        viewModel = ViewModelProvider(this)[FirstViewModel::class.java]
        initialize()
        observes()
        setUpList()
    }

    private fun initialize() {
        binding.rvCat.adapter = adapterCat
    }

    private fun observes() {
        viewModel?.getCat()?.observe(viewLifecycleOwner) { it ->
            adapterCat.observes(it as ArrayList<CatModel>)
    }
    }


    private fun setUpList() {
        binding.btn.setOnClickListener {
            binding.rvCat.isVisible = true
            binding.btn.isVisible = false
        }
    }

    private fun onItemClick(modelCatModel: CatModel) {
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToDetailFragment(
            modelCatModel.image,
            modelCatModel.name
        )
        )
    }

}
