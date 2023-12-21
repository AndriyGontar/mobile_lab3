package com.example.lab3.dataprovider

import com.example.lab3.model.Album
import com.example.lab3.model.Singer
import com.example.lab3.model.Song

class MyDataProvider {
    companion object {
        fun getSingerData(): List<Singer> {
            val singerData = mutableListOf<Singer>()

            singerData.add(Singer("Sergiy", "Zhadan","Zhadan and dogs", 0))
            singerData.add(Singer("Oleksandr", "Yarmak","Yarmak", 1))
            singerData.add(Singer("Volodymyr", "Samoliuk ","Skofka", 2))
            return singerData
        }

        fun getAlbumData(): List<Album> {
            val albumData = mutableListOf<Album>()
            val singers: List<Singer> = getSingerData();

            albumData.add(Album("Радіопромінь", singers[0], 0))
            albumData.add(Album("Мадонна", singers[0], 1))
            albumData.add(Album("Red Line", singers[1], 2))
            albumData.add(Album("ЙО-ЙО", singers[2], 3))

            return albumData
        }

        fun getSongData(): List<Song> {
            val songData = mutableListOf<Song>()
            val albums: List<Album> = getAlbumData();

            songData.add(Song("Кокаїн", albums[0], albums[0].singer))
            songData.add(Song("Наркомани на городі", albums[0], albums[0].singer))
            songData.add(Song("Бухло", albums[1], albums[1].singer))
            songData.add(Song("Троєщина", albums[1], albums[1].singer))
            songData.add(Song("Наступит день", albums[2], albums[2].singer))
            songData.add(Song("Custom", albums[2], albums[2].singer))
            songData.add(Song("Otaman", albums[3], albums[3].singer))
            return songData

        }
    }
}