package com.example.test

import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.test.ui.GridViewAdapter
import com.example.test.viewmodel.PokeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val pokeViewModel: PokeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = GridViewAdapter(this, pokeViewModel.pokeList)

        gridview.adapter = adapter
        gridview.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val item = pokeViewModel.pokeList[position]
            val v = view.findViewById(R.id.ly_item) as LinearLayout
            val cardView = v.findViewById(R.id.card_view) as CardView
            val textView = v.findViewById(R.id.txt_number) as TextView

            if (!item.isClicked){
                cardView.setCardBackgroundColor(item.color)
                textView.setTextColor(Color.WHITE)
            }else{
                cardView.setCardBackgroundColor(ContextCompat.getColor(this, item.backgroundColor))
                textView.setTextColor(item.color)
            }

            pokeViewModel.setItemClick(position)
            adapter.notifyDataSetChanged()
        }
    }
}