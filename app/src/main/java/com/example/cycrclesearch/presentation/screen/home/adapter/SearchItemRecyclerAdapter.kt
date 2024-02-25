package com.example.cycrclesearch.presentation.screen.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cycrclesearch.R
import com.example.cycrclesearch.databinding.RecyclerSearchItemBinding
import com.example.cycrclesearch.presentation.model.SearchItem

class SearchItemRecyclerAdapter :
    ListAdapter<SearchItem, SearchItemRecyclerAdapter.SearchItemViewHolder>(SearchDiffUtils()) {

    inner class SearchItemViewHolder(private val binding: RecyclerSearchItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {

            val item = currentList[adapterPosition]
            binding.tvName.text = item.name

            binding.circleContainer.removeAllViews()

            val numberOfCirclesToDraw = item.children?.let { minOf(item.children.size, 4) }
            repeat(numberOfCirclesToDraw ?: 0) {
                val circle = createCircleView()
                binding.circleContainer.addView(circle)
            }

        }

        private fun createCircleView(): View {
            val circleView = View(binding.root.context)
            val size = 34
            val layoutParams = LinearLayout.LayoutParams(size, size)
            layoutParams.marginEnd = 5
            circleView.layoutParams = layoutParams
            circleView.background = ContextCompat.getDrawable(binding.root.context, R.drawable.circle_background)
            return circleView
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        return SearchItemViewHolder(
            RecyclerSearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        holder.bind()
    }

    class SearchDiffUtils : DiffUtil.ItemCallback<SearchItem>() {
        override fun areItemsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
            return oldItem == newItem
        }

    }

}