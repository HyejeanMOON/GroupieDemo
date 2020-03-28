package com.hyejeanmoon.groupiedemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hyejeanmoon.groupiedemo.databinding.ActivityMainBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter: GroupAdapter<GroupieViewHolder> = GroupAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerview.adapter = adapter

        val sections = generateData()

        adapter.update(sections)

    }


    private fun generateData(): List<Section> {
        val prefix = "MOON"
        val result: ArrayList<Section> = arrayListOf()
        for (i in 0..40) {
            val section = Section().apply {
                if (i % 2 == 0) {
                    add(ListBindableItem(prefix + i, onClick))
                } else {
                    add(ListTwoBindableItem(prefix + i, onClick))
                }
            }
            result.add(section)
        }
        return result
    }

    private val onClick: (String) -> Unit = {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}
