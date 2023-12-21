package com.example.lab3.model

 class Album (
    val name: String,

    val singer: Singer,
    var idAlbum: Long = 0): ItemTypeInterface{


    override fun getItemType(): Int {
        return ItemTypeInterface.albumsType
    }

}