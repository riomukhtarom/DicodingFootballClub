package com.example.user.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.rv_clublist)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items){
            //toast("${it.name}")
            startActivity(intentFor<DetailActivity>("name" to "${it.name}"))
            Log.e("MainActivity", "${it.name}")
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.clubname)
        val image = resources.obtainTypedArray(R.array.clublogo)
        items.clear()

        for (i in name.indices){
            items.add(Item(name[i], image.getResourceId(i, 0)))
        }

        image.recycle()
    }
}
