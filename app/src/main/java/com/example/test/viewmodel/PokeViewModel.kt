package com.example.test.viewmodel

import android.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.test.R

class PokeViewModel() : ViewModel() {

    private var colorRCount = 0
    private var colorGCount = 0
    private var colorBCount = 0

    val pokeList = mutableListOf<PokeItem>()

    init {
        pokeList.addAll(getList())
    }

    private fun getColor(value: Int): Int{

        if(colorRCount == 4){
            colorRCount = 0
            colorGCount = 0
            colorBCount = 0
        }

        if(value == 1) return Color.RED

        return when {
            colorGCount < 4 -> {
                colorGCount += 1
                Color.GREEN
            }
            colorBCount < 4 -> {
                colorBCount += 1
                Color.BLUE
            }
            colorRCount < 4 -> {
                colorRCount += 1
                Color.RED
            }
            else -> Color.WHITE
        }

    }

    private fun getList() : List<PokeItem> {
        val list = mutableListOf<PokeItem>()
        for(i in 1..5){
            for(x in i..49 step 5){
                val color = getColor(x)
                val backgroundColor = when(color){
                    Color.RED -> R.color.a_rad
                    Color.BLUE -> R.color.a_blue
                    Color.GREEN -> R.color.a_green
                    else -> 0
                }
                list.add(PokeItem(String.format("%02d", x), color, backgroundColor))
            }
        }
        return list.sortedBy { it.number }
    }

    fun setItemClick(position : Int) {
        pokeList[position].isClicked = !pokeList[position].isClicked
    }

    data class PokeItem(val number: String, val color: Int, val backgroundColor: Int, var isClicked : Boolean = false)
}