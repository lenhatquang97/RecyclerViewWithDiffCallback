package com.quangln2.listviewvsrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.quangln2.listviewvsrecyclerview.adapter.ProductRecyclerViewAdapter
import com.quangln2.listviewvsrecyclerview.databinding.ActivityMainBinding
import com.quangln2.listviewvsrecyclerview.model.Product

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listProducts = mutableListOf<Product>()
    private lateinit var productLs: MutableList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listProducts.apply {
            add(Product(1,"Iphone X",1000000))
            add(Product(2,"Iphone XS",2000000))
            add(Product(3,"Iphone XR",3000000))
            add(Product(4,"Iphone XS Max",4000000))
        }
        productLs = listProducts.toMutableList()
        val productRecyclerViewAdapter = ProductRecyclerViewAdapter(listProducts)
        binding.recyclerView.apply {
            adapter = productRecyclerViewAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        binding.buttonAdd.setOnClickListener {
            //random price
            val price = (1..10000000).random()
            val product = Product(listProducts.size + 1,"New Product",price)
            productLs.add(product)
            productRecyclerViewAdapter.addNewProductWithDiffCallback(productLs)
            binding.recyclerView.post(Runnable { // Call smooth scroll
                binding.recyclerView.smoothScrollToPosition(binding.recyclerView.adapter?.itemCount!! - 1)
            })
        }

    }
}