package com.harunkurnaz.hw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harunkurnaz.hw2.databinding.FragmentCardviewBinding

class ToDoAdapter(private var list: MutableList<ToDoDataModel>) : RecyclerView.Adapter<ToDoAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: FragmentCardviewBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnDelete.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    list.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }

        fun bind(getList: ToDoDataModel) {
            binding.tvTitle.text = getList.title
            binding.tvDescription.text = getList.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdapter.MyViewHolder {
        val binding = FragmentCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoAdapter.MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
