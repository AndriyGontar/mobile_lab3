package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab3.adapter.MyAdapter
import com.example.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var vm: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MyViewModel::class.java]

        val rv = binding.rvMyList
        rv.layoutManager = LinearLayoutManager(this)

        val myAdapter =  MyAdapter(vm.myList, )

        rv.adapter = myAdapter
        rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        vm.myList.observe(this){
            myAdapter.notifyDataSetChanged()
        }
    }
}