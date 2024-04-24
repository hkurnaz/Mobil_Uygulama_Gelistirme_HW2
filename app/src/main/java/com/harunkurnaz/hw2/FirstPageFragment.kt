package com.harunkurnaz.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.harunkurnaz.hw2.databinding.FragmentCardviewBinding

class FirstPageFragment : Fragment() {

    private lateinit var binding: FragmentCardviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCardviewBinding.inflate(inflater,container,false)
        return binding.root
    }


}