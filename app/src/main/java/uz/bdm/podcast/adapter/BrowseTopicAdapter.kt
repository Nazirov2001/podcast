package uz.bdm.podcast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.model.BrowseTopicModel
import uz.bdm.podcast.R
import uz.bdm.podcast.databinding.BrowseCategoryItemLayoutBinding


interface BrowseTopicListener{
    fun onSelected(item: BrowseTopicModel)
}

class BrowseTopicAdapter(val items: ArrayList<BrowseTopicModel>, val listener: BrowseTopicListener) :
    RecyclerView.Adapter<BrowseTopicAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: BrowseCategoryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            BrowseCategoryItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        listener.onSelected(item)
        if (item.checked) {
            holder.binding.imgTopic.setColorFilter(
                ContextCompat.getColor(
                    holder.itemView.context, R.color.white
                )
            )
            holder.binding.tvTitle.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context, R.color.white
                )
            )
            holder.binding.btnTopic.background =
                ContextCompat.getDrawable(holder.itemView.context, R.drawable.browse_topic_selected)
        } else {
            holder.binding.imgTopic.setColorFilter(
                ContextCompat.getColor(
                    holder.itemView.context, R.color.textColor
                )
            )
            holder.binding.tvTitle.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context, R.color.textColor
                )
            )
            holder.binding.btnTopic.background =
                ContextCompat.getDrawable(holder.itemView.context, R.drawable.browse_topic)
        }

        holder.binding.imgTopic.setImageResource(item.image)
        holder.binding.tvTitle.text = item.title

        holder.itemView.setOnClickListener {
            items.forEach {
                it.checked = false
            }

            item.checked = true
            if (item.checked) {
                holder.binding.imgTopic.setColorFilter(
                    ContextCompat.getColor(
                        it.context, R.color.white
                    )
                )
                holder.binding.tvTitle.setTextColor(
                    ContextCompat.getColor(
                        it.context, R.color.white
                    )
                )
                holder.binding.btnTopic.background =
                    ContextCompat.getDrawable(it.context, R.drawable.browse_topic_selected)
            } else {
                holder.binding.imgTopic.setColorFilter(
                    ContextCompat.getColor(
                        it.context, R.color.textColor
                    )
                )
                holder.binding.tvTitle.setTextColor(
                    ContextCompat.getColor(
                        it.context, R.color.textColor
                    )
                )
                holder.binding.btnTopic.background =
                    ContextCompat.getDrawable(it.context, R.drawable.browse_topic)
            }
            listener.onSelected(item)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}