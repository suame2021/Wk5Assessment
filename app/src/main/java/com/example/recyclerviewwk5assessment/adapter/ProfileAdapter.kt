package com.example.recyclerviewwk5assessment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwk5assessment.adapter.ProfileAdapter.*
import com.example.recyclerviewwk5assessment.databinding.ProfileItemBinding
import com.example.recyclerviewwk5assessment.models.Profile

class ProfileAdapter(val allProfile: List<Profile>, var clickListener: OnItemClickListener) :
    RecyclerView.Adapter<ProfileViewHolder>() {
    class ProfileViewHolder(var binding: ProfileItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun initialize(profile: Profile, action: OnItemClickListener) {
            binding.profileImages.setImageResource(profile.profileImage)
            binding.firstName.text = profile.firstName
            binding.lastName.text = profile.lastName

            itemView.setOnClickListener {
                action.onItemClick(profile, adapterPosition)
            }
        }

        fun bind(profile: Profile) {
            binding.apply {
                firstName.text = profile.firstName
                lastName.text = profile.lastName
                profileImages.setImageResource(profile.profileImage)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        var binding = ProfileItemBinding.inflate(LayoutInflater.from(parent.context))
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = allProfile[position]
        holder.bind(profile)
        holder.initialize(allProfile.get(position), clickListener)
    }

    override fun getItemCount(): Int {
        return allProfile.size
    }

}


interface OnItemClickListener {
    fun onItemClick(profile: Profile, position: Int)
}