package com.hello.hellodoc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hello.hellodoc.databinding.ItemDoctorBinding

/**
 * @author arifk
 * @date 1/28/2022
 */
public class DoctorAdapter(var data: List<String>, var itemClickListener: () -> Unit) :
    RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoctorAdapter.DoctorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDoctorBinding.inflate(inflater, parent, false)

        return DoctorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            itemClickListener()
        }
    }


    override fun getItemCount() = data.size


    inner class DoctorViewHolder(var binding: ItemDoctorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.tvDoctorName.text = item
        }
    }
}