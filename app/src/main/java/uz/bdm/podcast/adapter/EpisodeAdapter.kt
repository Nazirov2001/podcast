package uz.bdm.podcast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.model.PodcastModel
import uz.bdm.podcast.databinding.EpisodeItemLayoutBinding

class EpisodeAdapter(val items: ArrayList<PodcastModel>) :
    RecyclerView.Adapter<EpisodeAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: EpisodeItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemHolder(
        EpisodeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        holder.binding.tvEpisodeNo.text = item.name
        holder.binding.tvDate.text = "25.10.2020"
        holder.binding.tvDuration.text = item.duration

    }

    override fun getItemCount() = items.size
}