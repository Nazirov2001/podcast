package uz.bdm.podcast.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.bdm.podcast.model.CategoriesModel
import uz.bdm.podcast.databinding.CategoriesItemLayoutBinding

class CategoriesAdapter(val items: ArrayList<CategoriesModel>) :
    RecyclerView.Adapter<CategoriesAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: CategoriesItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemHolder(
        CategoriesItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = items[position]

        holder.binding.tvTitle.text = item.title
        holder.binding.imgRectangle.setImageResource(item.image)
    }

    override fun getItemCount() = items.size

}