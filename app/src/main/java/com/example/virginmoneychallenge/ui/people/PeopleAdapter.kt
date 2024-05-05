package com.example.virginmoneychallenge.ui.people

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoneychallenge.R
import com.example.virginmoneychallenge.databinding.ItemPeopleBinding
import com.example.virginmoneychallenge.domain.people.model.PeopleDTO

class PeopleAdapter(private val onPeopleItemClicked: (PeopleDTO) -> Unit) :
    ListAdapter<PeopleDTO, PeopleAdapter.PeopleViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = ItemPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val list = getItem(position)
        holder.bind(list)
        holder.itemView.setOnClickListener {
            onPeopleItemClicked(list)
        }
    }

    class PeopleViewHolder(private val binding: ItemPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val TAG = "TAG: PeopleAdapter"

        fun bind(item: PeopleDTO) {
            Glide.with(binding.imageViewPeople.context)
                .load(item.avatar)
                .override(200, 200) // Resize images to reduce memory usage
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.icon_people) // Error placeholder
                .into(binding.imageViewPeople)

            binding.textViewFirstName.text = item.firstName
            binding.textViewLastName.text = item.lastName
            Log.i(TAG,item.toString())
        }
    }

    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<PeopleDTO>() {
            override fun areItemsTheSame(oldItem: PeopleDTO, newItem: PeopleDTO) =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: PeopleDTO, newItem: PeopleDTO) =
                oldItem == newItem

        }
    }
}