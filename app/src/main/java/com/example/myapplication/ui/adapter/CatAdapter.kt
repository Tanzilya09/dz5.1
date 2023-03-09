package com.example.myapplication.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.model.CatModel
import com.example.myapplication.setImage

class CatAdapter(private var listCat: MutableList<CatModel>, val onItemClick:(modelCat: CatModel) ->Unit)
    : RecyclerView.Adapter<CatAdapter.AdapterViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun observes(list: MutableList<CatModel>){
        this.listCat = list
        notifyDataSetChanged()
    }

    inner class AdapterViewHolder(private var binding: ItemBinding)
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
