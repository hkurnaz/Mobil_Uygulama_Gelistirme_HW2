package com.harunkurnaz.hw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunkurnaz.hw2.databinding.FragmentCardviewBinding

class ToDoAdapter(private val list: List<ToDoDataModel>): RecyclerView.Adapter<ToDoAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: FragmentCardviewBinding   ):RecyclerView.ViewHolder(binding.root){
        fun bind(getList: ToDoDataModel){
            binding.tvTitle.text = getList.title
            binding.tvDescription.text = getList.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdapter.MyViewHolder {
        val binding = FragmentCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoAdapter.MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}