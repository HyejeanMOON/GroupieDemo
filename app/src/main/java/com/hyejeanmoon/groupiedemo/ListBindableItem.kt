package com.hyejeanmoon.groupiedemo

import com.hyejeanmoon.groupiedemo.databinding.ItemListBinding
import com.xwray.groupie.databinding.BindableItem

data class ListBindableItem(
    val str: String,
    val onClick: (String) -> Unit
) : BindableItem<ItemListBinding>() {

    override fun getLayout(): Int {
        return R.layout.item_list
    }

    override fun bind(viewBinding: ItemListBinding, position: Int) {
        viewBinding.textview.text = str
        viewBinding.textview.setOnClickListener { onClick(str) }
    }
}
