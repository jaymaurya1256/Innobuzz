package com.example.innobuzz.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.innobuzz.R
import com.example.innobuzz.databinding.ListItemHomeBinding
import com.example.innobuzz.network.entity.Post

class HomeAdapter(private val dataList: List<Post>, private val Onclick: (Int) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private lateinit var binding: ListItemHomeBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        binding.cardView.setOnClickListener {
            Onclick(data.id)
        }
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.title_recycler_view_home)

        fun bindData(data: Post) {
            textView.text = data.title
        }
    }
}
