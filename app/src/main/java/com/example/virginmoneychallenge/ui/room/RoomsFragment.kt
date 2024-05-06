package com.example.virginmoneychallenge.ui.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneychallenge.R
import com.example.virginmoneychallenge.databinding.FragmentRoomsBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : Fragment() {
    lateinit var binding: FragmentRoomsBinding
    private val viewModel : RoomViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRoomsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RoomAdapter()
        adapterSetter(adapter)
        initiateObservables(adapter)
    }

    private fun adapterSetter(adapter: RoomAdapter) {
        binding.recyclerViewRoom.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewRoom.adapter = adapter
    }

    private fun initiateObservables(adapter: RoomAdapter) {
        viewModel.roomList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        viewModel.loading.observe(viewLifecycleOwner){
            if (it == false) {
                binding.progressBarRoom.clearAnimation()
                binding.progressBarRoom.visibility = View.GONE

            } else {
                binding.progressBarRoom.visibility = View.VISIBLE
                val rotateAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.progress_animation)
                binding.progressBarRoom.startAnimation(rotateAnimation)

            }
        }

    }

}