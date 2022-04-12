package com.enriqif.globallogicapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.enriqif.domain.model.Notebook
import com.enriqif.globallogicapp.R
import com.enriqif.globallogicapp.common.Constants.ERROR_MESSAGE
import com.enriqif.globallogicapp.databinding.NotebookRowBinding

class NotebookRecyclerAdapter (
    private val context: Context,
    private val notebookList: List<Notebook>,
    private val listener: NotebookClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface NotebookClickListener {
        fun onItemClick(notebook: Notebook)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return NotebookViewHolder(
            LayoutInflater.from(
                context
            ).inflate(
                R.layout.notebook_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is NotebookViewHolder -> holder.bind(notebookList[position], position)
            else -> throw IllegalArgumentException(ERROR_MESSAGE)
        }
    }

    override fun getItemCount(): Int = notebookList.size

    inner class NotebookViewHolder(itemView: View) : BaseViewHolder<Notebook>(itemView) {
        override fun bind(item: Notebook, position: Int) {
            val binding = NotebookRowBinding.bind(itemView)
            binding.root.setOnClickListener { listener.onItemClick(item) }
            binding.notebookRowTitle.text = item.title
            binding.notebookRowDetail.text = item.description

            Glide
                .with(context)
                .load(item.image)
                .placeholder(R.drawable.icon_notebook)
                .into(binding.notebookImage)
        }
    }

}