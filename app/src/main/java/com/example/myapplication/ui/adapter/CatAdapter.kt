package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.model.CatModel
import com.example.myapplication.setImage

class CatAdapter(private val listCat: MutableList<CatModel>, val onItemClick:(modelCat: CatModel) ->Unit)
    : RecyclerView.Adapter<CatAdapter.AdapterViewHolder>() {

    inner class AdapterViewHolder( var binding: ItemBinding)
        :RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener{
                onItemClick(listCat[adapterPosition])
            }
        }

        fun onBind (modelCat: CatModel){
            binding.txtName.text = modelCat.name
            binding.itImage.setImage(modelCat.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.onBind(listCat[position])
    }

    override fun getItemCount(): Int = listCat.size

}
