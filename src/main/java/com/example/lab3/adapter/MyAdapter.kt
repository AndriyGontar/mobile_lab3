package com.example.lab3.adapter

import AlbumsAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.lab3.databinding.AlbumItemBinding
import com.example.lab3.databinding.SingerItemBinding
import com.example.lab3.databinding.SongItemBinding
import com.example.lab3.dataprovider.MyDataProvider
import com.example.lab3.model.Album
import com.example.lab3.model.ItemTypeInterface
import com.example.lab3.model.Singer
import com.example.lab3.model.Song

class MyAdapter(
    private val myList: LiveData<List<ItemTypeInterface>>,
) : RecyclerView.Adapter<MyAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return when (viewType) {
            ItemTypeInterface.songType -> SongHolder(
                SongItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            ItemTypeInterface.albumsType -> AlbumHolder(
                AlbumItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            else -> SingerHolder(
                SingerItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return myList.value!!.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(myList.value!![position])
    }

    override fun getItemViewType(position: Int): Int {
        return myList.value!![position].getItemType()
    }

    abstract class MyHolder(itemBinding: ViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        abstract fun bind(item: ItemTypeInterface)
    }

    class SingerHolder(private val itemBinding: SingerItemBinding) : MyHolder(itemBinding) {
        override fun bind(item: ItemTypeInterface) {
            item as Singer
            itemBinding.tvFirstName.text = item.firstName ?:"empty"
            itemBinding.tvLastName.text = item.lastName ?:"empty"
            itemBinding.tvNickName.text = item.nickName ?:"empty"
                val albumsForSinger = MyDataProvider.getAlbumData().filter { x -> x.singer.equals(item) }
            val albumsAdapter = AlbumsAdapter(albumsForSinger)
            itemBinding.incAlbum.tvAlbums.adapter = albumsAdapter
            itemBinding.incAlbum.tvAlbums.layoutManager = LinearLayoutManager(itemBinding.root.context)
        }
    }

    class AlbumHolder(private val itemBinding: AlbumItemBinding) : MyHolder(itemBinding) {
        override fun bind(item: ItemTypeInterface) {
            item as Album
            itemBinding.tvName.text = item.name
            itemBinding.tvSinger.text = item.singer.nickName
        }
    }

    class SongHolder(private val itemBinding: SongItemBinding) : MyHolder(itemBinding) {
        override fun bind(item: ItemTypeInterface, ) {
            item as Song
            itemBinding.tvName.text = item.name
            itemBinding.tvSinger.text = item.singer.nickName
            itemBinding.tvAlbum.text = item.album.name
        }
    }

}
