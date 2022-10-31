package uz.bdm.podcast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.model.AuthorModel
import uz.bdm.podcast.databinding.AuthorItemLayoutBinding

class AuthorAdapter(val list: List<AuthorModel>) :
    RecyclerView.Adapter<AuthorAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: AuthorItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder = ItemHolder(
        AuthorItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = list[position]

       holder.binding.imgAuthor.setImageResource(item.image)
        holder.binding.tvName.text = item.title
        holder.binding.tvPodcasts.text = "Podcasts: " + item.podcastCount.toString()
    }

    override fun getItemCount(): Int = list.size
}