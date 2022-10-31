package uz.bdm.podcast.screen.main

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import jp.wasabeef.blurry.Blurry
import uz.bdm.podcast.R
import uz.bdm.podcast.adapter.*
import uz.bdm.podcast.databinding.ActivityMainBinding
import uz.bdm.podcast.model.PodcastModel
import uz.bdm.podcast.screen.browse.BrowseActivity
import uz.bdm.podcast.utils.Blanks
import uz.bdm.podcast.utils.PrefUtils

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    var id=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blanks = Blanks()
        blanks.savePodcastTopic()
        blanks.saveAuthors()
        blanks.savePodcasts()
        blanks.saveTopicAuthor()
        blanks.saveNewAuthor()

        binding.imgSearch.setOnClickListener {
            binding.lySearch.visibility = View.VISIBLE
        }

        binding.lySearch.setOnClickListener {
            binding.lySearch.visibility = View.GONE
        }


        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val list = PrefUtils.getPodcasts() ?: arrayListOf()
                val edtText = binding.edtSearch.text.toString()
                val resultList = arrayListOf<PodcastModel>()


                list.forEach {
                    for (i in 0 until it.name.length - edtText.length) {
                        if (it.name.substring(i, i + edtText.length) == edtText) {
                            resultList.add(it)
                            break
                        }
                    }
                }
                binding.recyclerSearch.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.recyclerSearch.adapter = SearchAdapter(resultList)

            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        val bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.podcast_cover)

        Blurry.with(this).sampling(7).from(bitmap).into(binding.imgBlur)

        val toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()
        binding.navigation.setNavigationItemSelectedListener(this)

        binding.imgMenu.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.END)
        }

        binding.recyclerOffer.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
        binding.recyclerOffer.adapter = OfferAdapter(PrefUtils.getPodcasts() ?: arrayListOf())

        val listenList = PrefUtils.getPodcastTopic() ?: arrayListOf()

        val topicList = PrefUtils.getAuthorTopic() ?: arrayListOf()
        binding.recyclerListen.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerPodcast.layoutManager = LinearLayoutManager(
            this@MainActivity, LinearLayoutManager.HORIZONTAL, false
        )

binding.recyclerListen.isNestedScrollingEnabled=false
binding.recyclerListen.setHasFixedSize(false)
        binding.recyclerListen.adapter = TopicAdapter(PrefUtils.getPodcastTopic() ?: arrayListOf(),
            object : TopicAdapterListener {
                override fun onSelected(index: Int) {
                    id=index
                    when (listenList[id].title) {
                        "Recent" -> {
                            binding.recyclerPodcast.adapter =
                                PodcastAdapter(PrefUtils.getPodcasts() ?: arrayListOf())
                        }

                        "Topic" -> {
                            val list = PrefUtils.getPodcasts() ?: arrayListOf()
                            list.sortByDescending {
                                it.topic.title
                            }

                            binding.recyclerPodcast.adapter = PodcastAdapter(list)
                        }

                        "Authors" -> {
                            val list = PrefUtils.getPodcasts() ?: arrayListOf()
                            list.sortByDescending {
                                it.author.title
                            }
                            binding.recyclerPodcast.adapter = PodcastAdapter(list)
                        }

                        "Episodes" -> {
                            val list = PrefUtils.getPodcasts() ?: arrayListOf()
                            val l1 = arrayListOf<PodcastModel>()
                            list.sortByDescending {
                                it.duration
                            }
                            list.forEachIndexed { index, it ->
                                l1.add(
                                    PodcastModel(
                                        it.id,
                                        "Ep. ${index + 1}: ${it.name}",
                                        it.image,
                                        it.duration,
                                        it.author,
                                        it.trackSrc,
                                        it.topic,
                                        //    it.title,
                                        it.listened
                                    )
                                )
                            }
                            binding.recyclerPodcast.adapter = PodcastAdapter(l1)
                        }

                    }
                }
            })
        when (listenList[id].title) {
            "Recent" -> {
                binding.recyclerPodcast.adapter =
                    PodcastAdapter(PrefUtils.getPodcasts() ?: arrayListOf())
            }

            "Topic" -> {
                val list = PrefUtils.getPodcasts() ?: arrayListOf()
                list.sortByDescending {
                    it.topic.title
                }

                binding.recyclerPodcast.adapter = PodcastAdapter(list)
            }

            "Authors" -> {
                val list = PrefUtils.getPodcasts() ?: arrayListOf()
                list.sortByDescending {
                    it.author.title
                }
                binding.recyclerPodcast.adapter = PodcastAdapter(list)
            }

            "Episodes" -> {
                val list = PrefUtils.getPodcasts() ?: arrayListOf()
                val l1 = arrayListOf<PodcastModel>()
                list.sortByDescending {
                    it.duration
                }
                list.forEachIndexed { index, it ->
                    l1.add(
                        PodcastModel(
                            it.id,
                            "Ep. ${index + 1}: ${it.name}",
                            it.image,
                            it.duration,
                            it.author,
                            it.trackSrc,
                            it.topic,
                            //    it.title,
                            it.listened
                        )
                    )
                }
                binding.recyclerPodcast.adapter = PodcastAdapter(l1)
            }

        }

        binding.recyclerAuthorTopic.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerAuthor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerAuthorTopic.adapter = AuthorTopicAdapter(
                PrefUtils.getAuthorTopic() ?: arrayListOf(),
                object : AuthorTopicAdapterListener {
                    override fun onSelected(index: Int) {
                        index
                        when (topicList[index].title) {
                            "Recent" -> {
                                binding.recyclerAuthor.adapter = AuthorAdapter(PrefUtils.getAuthors() ?: arrayListOf())

                            }
                            "Most podcasts" -> {
                                val list = PrefUtils.getAuthors() ?: arrayListOf()
                                list.sortByDescending { it.podcastCount }
                                binding.recyclerAuthor.adapter = AuthorAdapter(list)

                            }
                            "Most followed"->{
                                val list = PrefUtils.getAuthors() ?: arrayListOf()
                                list.sortByDescending { it.followers }
                                binding.recyclerAuthor.adapter = AuthorAdapter(list)

                            }
                        }
                    }
                })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.browse -> startActivity(Intent(this, BrowseActivity::class.java))
        }
        return true
    }
}