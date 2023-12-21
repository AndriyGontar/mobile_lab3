package com.example.lab3.model


 class Singer(

    val firstName: String,

    val lastName: String,

    val nickName: String,

    var idAuthor: Long = 0
): ItemTypeInterface {
    override fun getItemType(): Int {
        return ItemTypeInterface.singerType
    }
     override fun equals(other: Any?): Boolean {
         return if (this === other) true
         else if (other !is Singer) false
         else idAuthor == other.idAuthor
     }
}
