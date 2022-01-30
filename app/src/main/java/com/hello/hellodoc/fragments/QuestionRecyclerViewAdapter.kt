package com.hello.hellodoc.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hello.hellodoc.R
import com.hello.hellodoc.databinding.FragmentQuestionItemBinding

import com.hello.hellodoc.fragments.placeholder.PlaceholderContent.PlaceholderItem


class QuestionRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<QuestionRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentQuestionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.contentView.text = item.content
        holder.qs.text = item.details
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentQuestionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.content
        val qs: TextView = binding.tvQuestion

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}