package com.quangln2.listviewvsrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.quangln2.listviewvsrecyclerview.R
import com.quangln2.listviewvsrecyclerview.diffcall.MyDiffUtil
import com.quangln2.listviewvsrecyclerview.model.Product

class ProductRecyclerViewAdapter(private val listProduct: MutableList<Product>):
    RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productId: TextView
        val productName: TextView
        val productPrice: TextView
        init {
            productId = view.findViewById(R.id.idproduct)
            productName = view.findViewById(R.id.nameproduct)
            productPrice = view.findViewById(R.id.priceproduct)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_view,parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productId.text = String.format("ID = %d", listProduct[position].productId)
        holder.productName.text = String.format("Name = %s", listProduct[position].name)
        holder.productPrice.text = String.format("Price = %d", listProduct[position].price)
    }

    override fun getItemCount() = listProduct.size

    fun addNewProductWithDiffCallback(products: List<Product>) {
        val myDiffUtil: MyDiffUtil = MyDiffUtil(listProduct, products)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(myDiffUtil)
        listProduct.clear()
        listProduct.addAll(products)
        diffResult.dispatchUpdatesTo(this)
    }
}