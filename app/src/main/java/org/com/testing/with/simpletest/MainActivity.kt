package org.com.testing.with.simpletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        recyclerView = findViewById(R.id.mRecyclerView)
        viewModel.data.observe(this, Observer { list->
            run{
                recyclerView?.apply {
                    val rvAdapter = RVCustomAdapter()
                    rvAdapter.articleList = list
                    adapter = rvAdapter
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

        })
    }
}