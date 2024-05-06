package com.example.virginmoneychallenge.ui.people

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneychallenge.R
import com.example.virginmoneychallenge.core.Constant.PEOPLE_DTO_PARCELIZED_KEY
import com.example.virginmoneychallenge.databinding.FragmentPeopleBinding
import com.example.virginmoneychallenge.domain.people.model.PeopleDTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {
    lateinit var binding: FragmentPeopleBinding
    private val viewModel: PeopleViewModel by viewModels()
    val TAG = "TAG: PeopleFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PeopleAdapter {
            navigateToPeopleDetails(it)
        }
        adpaterSetter(adapter)
        observe(adapter)

    }

    private fun observe(adapter: PeopleAdapter) {
        viewModel.people.observe(viewLifecycleOwner) {
            Log.i(TAG, it.toString())
            adapter.submitList(it)
        }
        viewModel.loading.observe(viewLifecycleOwner) {
            if (it == false) {
                binding.progressBarPeople.clearAnimation()
                binding.progressBarPeople.visibility = View.GONE

            } else {
                binding.progressBarPeople.visibility = View.VISIBLE
                val rotateAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.progress_animation)
                binding.progressBarPeople.startAnimation(rotateAnimation)

            }
        }
    }

    fun adpaterSetter(adapter: PeopleAdapter) {
        binding.recyclerViewPeople.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewPeople.adapter = adapter
    }

    private fun navigateToPeopleDetails(peopleDTO: PeopleDTO) {
        val bundle = Bundle().also {
            it.putParcelable(PEOPLE_DTO_PARCELIZED_KEY, peopleDTO)
        }
        findNavController().navigate(R.id.action_peopleFragment_to_detailedPeopleFragment,bundle)
    }
}