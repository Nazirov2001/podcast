package uz.bdm.podcast.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.model.PodcastModel
import uz.bdm.podcast.screen.player.PlayerActivity
import uz.bdm.podcast.utils.Constants
import uz.bdm.podcast.databinding.PodcastItemLayoutBinding

class PodcastAdapter(val list: ArrayList<PodcastModel>) :
    RecyclerView.Adapter<PodcastAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: PodcastItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder = ItemHolder(
        PodcastItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = list[position]

        holder.binding.tvTime.text = item.duration
        holder.binding.tvTitle.text = item.name
        holder.binding.tvAuthor.text = item.author.title
        holder.binding.imgCover.setImageResource(item.image)
        holder.binding.imgAuthor.setImageResource(item.author.image)

        holder.binding.btnPlay.setOnClickListener {
            val intent = Intent(it.context, PlayerActivity::class.java)
            intent.putExtra(Constants.EXTRA_DATA, item)
            it.context.startActivity(intent)
        }
//        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}