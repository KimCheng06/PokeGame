package com.example.test.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.test.R
import com.example.test.viewmodel.PokeViewModel

class GridViewAdapter(
        private val context: Context,
        private val list: List<PokeViewModel.PokeItem>,
) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): PokeViewModel.PokeItem {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val grid: View
        if (convertView == null) {
            grid = LayoutInflater.from(parent.context).inflate(R.layout.gridview_item, parent, false)
            val cardView = grid.findViewById<View>(R.id.card_view) as CardView
            val textView = grid.findViewById<View>(R.id.txt_number) as TextView

            val item = getItem(position)
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, item.backgroundColor))
            textView.text = item.number
            textView.setTextColor(item.color)

        } else {
            grid = convertView
        }
        return grid
    }
}



