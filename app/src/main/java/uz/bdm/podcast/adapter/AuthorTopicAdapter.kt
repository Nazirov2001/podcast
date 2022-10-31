package uz.bdm.podcast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.R
import uz.bdm.podcast.databinding.TopicItemLayoutBinding
import uz.bdm.podcast.model.TopicModel


interface AuthorTopicAdapterListener {
    fun onSelected(index: Int)
}


class AuthorTopicAdapter(val list: ArrayList<TopicModel>, val listener: AuthorTopicAdapterListener) :
    RecyclerView.Adapter<AuthorTopicAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: TopicItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder = ItemHolder(
        TopicItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = list[position]

        if (item.checked) {
            holder.binding.tvTitle.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context, R.color.selectedText
                )
            )
            listener.onSelected(position)
        } else {
            holder.binding.tvTitle.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context, R.color.textColor
                )
            )
        }

        holder.binding.tvTitle.text = item.title
//        listener.onSelected(position)

        holder.itemView.setOnClickListener {
            list.forEach {
                it.checked = false
            }

            list[position].checked = true
            item.checked = true
            listener.onSelected(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = list.size

}