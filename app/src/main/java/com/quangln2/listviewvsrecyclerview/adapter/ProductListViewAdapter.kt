package com.quangln2.listviewvsrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.quangln2.listviewvsrecyclerview.R
import com.quangln2.listviewvsrecyclerview.databinding.ProductViewBinding
import com.quangln2.listviewvsrecyclerview.model.Product

class ProductListViewAdapter: BaseAdapter {
    val listProduct = mutableListOf<Product>()
    constructor(listProduct: MutableList<Product>): super() {
        this.listProduct.addAll(listProduct)
    }
    override fun getCount(): Int {
        return listProduct.size
    }

    override fun getItem(position: Int): Any {
        return listProduct.get(position)
    }

    override fun getItemId(position: Int): Long {
       return listProduct.get(position).productId.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val product = listProduct.get(position)
        val binding = ProductViewBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        binding.idproduct.text = String.format("ID = %d", product.productId)
        binding.nameproduct.text = String.format("Name = %s", product.name)
        binding.priceproduct.text = String.format("Price = %d", product.price)
        return binding.root!!
    }
}