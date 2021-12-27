package com.example.hwproduct_with_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hwproduct_with_fragment.databinding.FragmentDetialsBinding
import com.example.hwproduct_with_fragment.databinding.FragmentListBinding


class DetialsFragment : Fragment() {

    private var _binding : FragmentDetialsBinding? = null
    private val binding get() = _binding !!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetialsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            binding.phoneImageSmartPhoneActivity.setImageResource(it.getInt("image"))
            binding.phoneNameSmartphoneActivity.setText(it.getInt("name"))
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}