package com.example.basicrecycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basicrecycleview.databinding.FragmentInputDataBinding


class InputDataFragment : Fragment() {

    private  lateinit var binding: FragmentInputDataBinding
    private val itemViewModels = ArrayList<ItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputDataBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        binding.btSendData.setOnClickListener {
            val name= binding.edtName.text.toString()
            val description = binding.edtDescription.text.toString()
            itemViewModels.add(ItemViewModel(name,description))
           // println(itemViewModels)
            binding.edtName.text = null
            binding.edtDescription.text = null
        }
        binding.btNextShow.setOnClickListener {
            val fragmentShowData = ShowDataFragment(itemViewModels)
            loadFragment(fragmentShowData)
        }
    }




    private fun loadFragment(fragment: Fragment) {

        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.flShowFragment, fragment)
        fragmentTransaction.commit()

    }
}