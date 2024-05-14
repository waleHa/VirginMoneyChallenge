package com.example.virginmoneychallenge.ui.people

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.virginmoneychallenge.R
import com.example.virginmoneychallenge.core.Constant.PEOPLE_DTO_PARCELIZED_KEY
import com.example.virginmoneychallenge.databinding.FragmentDetailedPeopleBinding
import com.example.virginmoneychallenge.data.dto.PeopleDTO


class DetailedPeopleFragment : Fragment() {
    private var _binding: FragmentDetailedPeopleBinding? = null
    private val binding get() = _binding!!
    val TAG = "TAG: DetailedPeopleFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG,"onCreateView")
        _binding = FragmentDetailedPeopleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val peopleDTO = it.getParcelable(PEOPLE_DTO_PARCELIZED_KEY, PeopleDTO::class.java)
            if (peopleDTO != null) {
                updateUI(peopleDTO)
            } else {
                // Handle the case where peopleDTO is null
                showError()
            }
        }
    }

    private fun updateUI(people: PeopleDTO) {
        with(binding) {
            Glide.with(binding.avatarImageView.context)
                .load(people.avatar)
                .placeholder(R.drawable.icon_people) // Make sure you have this placeholder in your drawables
                .into(avatarImageView)

            firstNameTextView.text = "First Name: ${people.firstName}" ?: "N/A"
            lastNameTextView.text = "Last Name: ${people.lastName}" ?: "N/A"
            emailTextView.text = "Email ${people.email?.lowercase()}" ?: "N/A"
            jobTitleTextView.text = "Role: ${people.jobtitle?.capitalize()}" ?: "N/A"
            favouriteColorTextView.text = "Favorite Color: ${people.favouriteColor}" ?: "N/A"
            createdAtTextView.text = "Created AT: ${people.createdAt}" ?: "N/A"
        }
    }

    private fun showError() {
        // Implement error handling logic here
        Toast.makeText(context, "Failed to load person details.", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}