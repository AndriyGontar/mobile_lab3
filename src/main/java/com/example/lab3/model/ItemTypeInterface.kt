package com.example.lab3.model

interface ItemTypeInterface {
    fun getItemType(): Int

    companion object{
        const val singerType: Int = 1
        const val songType: Int = 2
        const val albumsType: Int = 3
    }
}