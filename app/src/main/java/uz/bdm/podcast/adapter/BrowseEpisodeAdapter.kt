package uz.bdm.podcast.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.databinding.BrowseEpisodeItemLayoutBinding
import uz.bdm.podcast.model.PodcastModel
import uz.bdm.podcast.screen.player.PlayerActivity
import uz.bdm.podcast.utils.Constants

class BrowseEpisodeAdapter(val items: ArrayList<PodcastModel>) :
    RecyclerView.Adapter<BrowseEpisodeAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: BrowseEpisodeItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemHolder(
        BrowseEpisodeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        holder.binding.tvEpisodeNo.text = "Episode: ${position + 1}"
        holder.binding.tvTitle.text = item.name
        holder.binding.tvDuration.text = item.duration

        holder.binding.btnPlay.setOnClickListener {
            val intent = Intent(it.context, PlayerActivity::class.java)
            intent.putExtra(Constants.EXTRA_DATA, item)
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount() = items.size
}