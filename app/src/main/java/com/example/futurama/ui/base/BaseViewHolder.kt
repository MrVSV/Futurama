package com.example.futurama.ui.base

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.example.futurama.domain.tools.ClickableView

abstract class BaseViewHolder<T : Any>(binding: ViewBinding) :
    ViewHolder(binding.root) {
    abstract fun bind(item: T, onClick: (ClickableView, item: T) -> Unit)

}