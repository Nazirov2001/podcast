package uz.bdm.podcast.screen.browse.topic


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.bdm.podcast.adapter.BrowsePodcastAdapter
import uz.bdm.podcast.adapter.TopicAdapter
import uz.bdm.podcast.adapter.TopicAdapterListener
import uz.bdm.podcast.databinding.ActivityTopicBinding
import uz.bdm.podcast.model.NewTopicsModel
import uz.bdm.podcast.utils.Blanks
import uz.bdm.podcast.utils.Constants
import uz.bdm.podcast.utils.PrefUtils

class TopicActivity : AppCompatActivity() {
    lateinit var binding: ActivityTopicBinding
    lateinit var item: NewTopicsModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        item = intent.getSerializableExtra(Constants.EXTRA_DATA) as NewTopicsModel

        Blanks().saveTopicActivity()

        binding.tvTitle.text = item.title

        binding.recTopic.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recTopic.adapter =
            TopicAdapter(PrefUtils.getTopicActivity(), object : TopicAdapterListener {
                override fun onSelected(index: Int) {
                    binding.recPodcast.layoutManager = LinearLayoutManager(this@TopicActivity)
                    binding.recPodcast.adapter =
                        BrowsePodcastAdapter(PrefUtils.getPodcasts() ?: arrayListOf())
                }
            })
    }
}