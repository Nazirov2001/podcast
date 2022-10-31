package uz.bdm.podcast.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.model.NewTopicsModel
import uz.bdm.podcast.databinding.BrowseTopicItemLayoutBinding
import uz.bdm.podcast.screen.browse.topic.TopicActivity
import uz.bdm.podcast.screen.player.PlayerActivity
import uz.bdm.podcast.utils.Constants
import java.text.NumberFormat
import java.util.*

class BrowseTopicsAdapter(val items: ArrayList<NewTopicsModel>) :
    RecyclerView.Adapter<BrowseTopicsAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: BrowseTopicItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemHolder(
        BrowseTopicItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        val authors = NumberFormat.getInstance(Locale.ROOT).format(item.authors)
        val podcasts = NumberFormat.getInstance(Locale.ROOT).format(item.podcasts)

        holder.binding.topicCover.setImageResource(item.image)
        holder.binding.tvTitle.text = item.title
        holder.binding.tvAuthors.text = "Authors: $authors"
        holder.binding.tvPodcasts.text = "Podcasts: $podcasts"
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, TopicActivity::class.java)
            intent.putExtra(Constants.EXTRA_DATA, item)
            it.context.startActivity(intent)
        }
    }

        override fun getItemCount() = items.size
}