import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.lab3.databinding.AlbumItemBinding
import com.example.lab3.databinding.AlbumsListItemBinding
import com.example.lab3.model.Album
import com.example.lab3.model.ItemTypeInterface

class AlbumsAdapter(private val albums: List<Album>) :
     RecyclerView.Adapter<AlbumsAdapter.MyHolder>(){



    class AlbumHolder(private val itemBinding: AlbumItemBinding) : MyHolder(itemBinding) {
        override fun bind(item: ItemTypeInterface) {
            item as Album
            itemBinding.tvName.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemBinding =
            AlbumsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return when (viewType) {
            ItemTypeInterface.albumsType -> AlbumsAdapter.AlbumHolder(
                AlbumItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            else -> AlbumsAdapter.AlbumHolder(
                AlbumItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        }
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    abstract class MyHolder(itemBinding: ViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        abstract fun bind(item: ItemTypeInterface)
    }
}