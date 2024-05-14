package com.example.virginmoneychallenge.ui.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoneychallenge.R
import com.example.virginmoneychallenge.databinding.ItemRoomBinding
import com.example.virginmoneychallenge.domain.model.room.RoomModel

class RoomAdapter : ListAdapter<RoomModel, RoomAdapter.RoomViewHolder>(DiffCallBack) {

    // This method is called when the RecyclerView needs a new ViewHolder of the given type to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    // This method binds the data to the ViewHolder. This is where you populate the data into the ViewHolder.
    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = getItem(position)
        holder.bind(room)
    }

    // ViewHolder class for Room items, holding each item's view details.
    class RoomViewHolder(private val binding: ItemRoomBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RoomModel) {
            binding.textViewRoomId.text = "Room ID: ${item.id}"
            binding.textViewCreatedAt.text = "Created At: ${item.createdAt?.substringBefore("T")}"
            binding.textViewMaxOccupancy.text = "Max Occupancy: ${item.maxOccupancy}"
            item.isOccupied?.let {
                if (it) {
                    binding.textViewOccupancyStatus.text = "Occupied"
                    binding.cardViewRoom.setBackgroundColor(
                        ContextCompat.getColor(
                            binding.cardViewRoom.context,
                            R.color.red
                        )
                    )
                } else {
                    binding.textViewOccupancyStatus.text = "Available"
                    binding.cardViewRoom.setBackgroundColor(
                        ContextCompat.getColor(
                            binding.cardViewRoom.context,
                            R.color.green
                        )
                    )
                }
            }

        }
    }

    // Object for determining the difference between two objects to optimize updates
    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<RoomModel>() {
            override fun areItemsTheSame(oldItem: RoomModel, newItem: RoomModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: RoomModel, newItem: RoomModel) =
                oldItem == newItem

        }
    }

}