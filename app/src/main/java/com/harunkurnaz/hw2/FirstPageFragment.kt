package com.harunkurnaz.hw2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.harunkurnaz.hw2.ToDoDataModel
import com.harunkurnaz.hw2.ToDoAdapter
import com.harunkurnaz.hw2.databinding.FragmentFirstPageBinding

class FirstPageFragment : Fragment() {
    private lateinit var binding: FragmentFirstPageBinding
    private val todoList = mutableListOf<ToDoDataModel>()
    private lateinit var adapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ToDoAdapter(todoList)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = adapter

        binding.btnAdd.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val description = binding.etDescription.text.toString()
            if (title.isNotBlank() && description.isNotBlank()) {
                val newItem = ToDoDataModel(title, description)
                todoList.add(newItem)
                adapter.notifyItemInserted(todoList.size - 1)

                binding.etTitle.text.clear()
                binding.etDescription.text.clear()
            } else {
                Toast.makeText(requireContext(), "Fill all the blanks", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
