package com.quangln2.listviewvsrecyclerview.diffcall

import androidx.recyclerview.widget.DiffUtil
import com.quangln2.listviewvsrecyclerview.model.Product

class MyDiffUtil : DiffUtil.Callback {
    private var oldProductList: List<Product> ?= null
    private var newProductList: List<Product> ?= null
    constructor(oldProductList: List<Product>, newProductList: List<Product>) : super() {
        this.oldProductList = oldProductList
        this.newProductList = newProductList
    }

    override fun getOldListSize(): Int {
        return oldProductList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newProductList?.size ?: 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldProductList?.get(oldItemPosition)?.productId == newProductList?.get(newItemPosition)?.productId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldProduct = oldProductList?.get(oldItemPosition)
        val newProduct = newProductList?.get(newItemPosition)
        return oldProduct?.name == newProduct?.name && oldProduct?.price == newProduct?.price
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}