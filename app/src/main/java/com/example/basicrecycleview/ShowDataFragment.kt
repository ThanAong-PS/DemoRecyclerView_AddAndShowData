package com.example.basicrecycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicrecycleview.databinding.FragmentShowDataBinding


class ShowDataFragment(private var itemViewModels: ArrayList<ItemViewModel>) : Fragment() {
    private lateinit var binding: FragmentShowDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowDataBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btBack.setOnClickListener {
            val fragmentInput = InputDataFragment()
            loadFragment(fragmentInput)
        }
        println(itemViewModels)
        setRecycleView()
    }

    private fun setRecycleView() {
        val adapter = ExampleAdapter(itemViewModels)
        //adapter.setListener(this)
        binding.rcShowData.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rcShowData.layoutManager = GridLayoutManager(  requireContext(), 2)
        binding.rcShowData.adapter = adapter


    }
    private fun loadFragment(fragment: Fragment) {

        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.flShowFragment, fragment)
        fragmentTransaction.commit()

    }
}