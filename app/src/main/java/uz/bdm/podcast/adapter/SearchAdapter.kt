package uz.bdm.podcast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.model.PodcastModel
import uz.bdm.podcast.databinding.SearchItemLayoutBinding

class SearchAdapter(val items: List<PodcastModel>) :
    RecyclerView.Adapter<SearchAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: SearchItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemHolder(
        SearchItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        holder.binding.tvTitle.text = item.name
        holder.binding.tvAuthor.text = item.author.title
        holder.binding.tvDuration.text = item.duration
        holder.binding.imgPodcast.setImageResource(item.image)
    }

    override fun getItemCount() = items.size
}