package uz.bdm.podcast.screen.browse.author

import android.graphics.Paint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import uz.bdm.podcast.R
import uz.bdm.podcast.adapter.BrowseEpisodeAdapter
import uz.bdm.podcast.adapter.TopicAdapter
import uz.bdm.podcast.adapter.TopicAdapterListener
import uz.bdm.podcast.databinding.ActivityAuthorBinding
import uz.bdm.podcast.model.NewAuthorModel
import uz.bdm.podcast.utils.Blanks
import uz.bdm.podcast.utils.Constants
import uz.bdm.podcast.utils.PrefUtils

class AuthorActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthorBinding
    lateinit var item: NewAuthorModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Blanks().saveTopicAuthor()

        item = intent.getSerializableExtra(Constants.EXTRA_DATA) as NewAuthorModel

        binding.tvAuthor.text = item.name

        when (item.name) {
            "Robert Dugoni" -> binding.authorBg.setBackgroundColor(
                ContextCompat.getColor(
                    this, R.color.author_1
                )
            )
            "J. K. Rowling" -> binding.authorBg.setBackgroundColor(
                ContextCompat.getColor(
                    this, R.color.author_2
                )
            )
            "Mary Beth Keane" -> binding.authorBg.setBackgroundColor(
                ContextCompat.getColor(
                    this, R.color.author_3
                )
            )
        }

        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.tvRating.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        binding.imgAuthor.setImageResource(item.image)

        binding.recTopic.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recTopic.adapter =
            PrefUtils.getAuthorTopic()?.let {
                TopicAdapter(it, object : TopicAdapterListener {
                    override fun onSelected(index: Int) {
                        binding.recEpisodes.layoutManager = LinearLayoutManager(this@AuthorActivity)
                        binding.recEpisodes.adapter =
                            BrowseEpisodeAdapter(PrefUtils.getPodcasts() ?: arrayListOf())
                    }
                })
            }

    }
}