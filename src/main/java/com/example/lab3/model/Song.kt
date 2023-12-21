package com.example.lab3.model

 class Song (
    val name: String,

    val album: Album,

    val singer: Singer, ): ItemTypeInterface{
    var idSong: Long = 0

    override fun getItemType(): Int {
        return ItemTypeInterface.songType
    }

}