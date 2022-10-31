package uz.bdm.podcast.screen.browse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.bdm.podcast.adapter.*
import uz.bdm.podcast.utils.Blanks
import uz.bdm.podcast.utils.PrefUtils
import uz.bdm.podcast.databinding.ActivityBrowseBinding
import uz.bdm.podcast.model.BrowseTopicModel

class BrowseActivity : AppCompatActivity() {
    lateinit var binding: ActivityBrowseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Blanks().saveBrowseTopics()
        Blanks().saveCategories()
        Blanks().saveNewTopics()
        Blanks().saveNewAuthor()

        binding.recyclerBrowse.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerBrowse.adapter =
            BrowseTopicAdapter(PrefUtils.getBrowseTopic(), object : BrowseTopicListener {
                override fun onSelected(item: BrowseTopicModel) {
                    if (item.checked) {
                        setRecycler(item.id, item.title)
                    }
                }
            })
    }

    fun setRecycler(id: Int, title: String) {
        when (id) {
            1 -> {
                binding.tvTitleCat.text = title
                binding.recyclerTopic.layoutManager = GridLayoutManager(this, 2)
                binding.recyclerTopic.adapter = CategoriesAdapter(PrefUtils.getCategories())
            }

            2 -> {
                binding.tvTitleCat.text = "$title (${PrefUtils.getNewTopics().size})"
                binding.recyclerTopic.layoutManager = LinearLayoutManager(this)
                binding.recyclerTopic.adapter = BrowseTopicsAdapter(PrefUtils.getNewTopics())
            }

            3 -> {
                binding.tvTitleCat.text = "$title (${PrefUtils.getNewAuthor().size})"
                binding.recyclerTopic.layoutManager = LinearLayoutManager(this)
                binding.recyclerTopic.adapter = NewAuthorsAdapter(PrefUtils.getNewAuthor())
            }

            4 -> {
                binding.tvTitleCat.text = "$title (${PrefUtils.getPodcasts()?.size ?: 0})"
                binding.recyclerTopic.layoutManager = LinearLayoutManager(this)
                binding.recyclerTopic.adapter =
                    BrowsePodcastAdapter(PrefUtils.getPodcasts() ?: arrayListOf())
            }

            5 -> {
                binding.tvTitleCat.text = "$title (${PrefUtils.getPodcasts()?.size ?: 0})"
                binding.recyclerTopic.layoutManager = LinearLayoutManager(this)
                binding.recyclerTopic.adapter =
                    BrowseEpisodeAdapter(PrefUtils.getPodcasts() ?: arrayListOf())
            }
        }
    }
}