package com.hyejeanmoon.groupiedemo

import com.hyejeanmoon.groupiedemo.databinding.ItemListTwoBinding
import com.xwray.groupie.databinding.BindableItem

data class ListTwoBindableItem(
    val str: String,
    val onClick: (String) -> Unit
) : BindableItem<ItemListTwoBinding>() {

    override fun getLayout(): Int {
        return R.layout.item_list_two
    }

    override fun bind(viewBinding: ItemListTwoBinding, position: Int) {
        viewBinding.textview.text = str
        viewBinding.textview.setOnClickListener { onClick(str) }
    }
}
