package uz.bdm.podcast.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.databinding.NewAuthorItemLayoutBinding
import uz.bdm.podcast.model.NewAuthorModel
import uz.bdm.podcast.screen.browse.author.AuthorActivity
import uz.bdm.podcast.screen.player.PlayerActivity
import uz.bdm.podcast.utils.Constants

class NewAuthorsAdapter(val  items: ArrayList<NewAuthorModel>):
        RecyclerView.Adapter<NewAuthorsAdapter.ItemHolder>() {
    inner class ItemHolder(val binding: NewAuthorItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ItemHolder(
    NewAuthorItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]


        holder.binding.imgAuthor.setImageResource(item.image)
        holder.binding.tvTitleCat.text = item.title
        holder.binding.frame.setBackgroundResource(item.bgAthor)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, AuthorActivity::class.java)
            intent.putExtra(Constants.EXTRA_DATA, item)
            it.context.startActivity(intent)
        }

    }
    override fun getItemCount() = items.size
}