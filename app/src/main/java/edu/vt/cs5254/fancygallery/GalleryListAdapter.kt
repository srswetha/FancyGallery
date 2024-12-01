package edu.vt.cs5254.fancygallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import edu.vt.cs5254.fancygallery.api.GalleryItem
import edu.vt.cs5254.fancygallery.databinding.ListItemGalleryBinding

class GalleryListAdapter(
    private val galleryItems: List<GalleryItem>
) : RecyclerView.Adapter<GalleryListAdapter.GalleryItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return GalleryItemHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryItemHolder, position: Int) {
        holder.bind(galleryItems[position])
    }

    override fun getItemCount() = galleryItems.size

    class GalleryItemHolder(
        private val binding: ListItemGalleryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(galleryItem: GalleryItem) {
            binding.itemImageView.load(galleryItem.url) {
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_placeholder)
                diskCachePolicy(CachePolicy.DISABLED)
            }
        }
    }
}
