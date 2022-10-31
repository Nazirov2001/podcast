package uz.bdm.podcast.utils

import com.orhanobut.hawk.Hawk
import uz.bdm.podcast.model.*

object PrefUtils {

    private const val PREF_PODCASTS = "pref_podcasts"
    private const val PREF_AUTHORS = "pref_authors"
    private const val PREF_PODCAST_TOPIC = "pref_podcast_topic"
    private const val PREF_AUTHOR_TOPIC = "pref_author_topic"
    private const val PREF_BROWSE_TOPIC = "pref_browse_topic"
    private const val PREF_CATEGORIES = "pref_categories"
    private const val PREF_NEW_TOPICS = "pref_new_topics"
    private const val PREF_NEW_AUTHOR = "pref_new_author"
    private const val PREF_TOPIC = "pref_topic"

    fun setPodcasts(value: ArrayList<PodcastModel>?) {
        Hawk.put(PREF_PODCASTS, value)
    }

    fun getPodcasts(): ArrayList<PodcastModel>? {
        return Hawk.get(PREF_PODCASTS)
    }

    fun setPodcastTopic(value: ArrayList<TopicModel>?) {
        Hawk.put(PREF_PODCAST_TOPIC, value)
    }

    fun getPodcastTopic(): ArrayList<TopicModel>? {
        return Hawk.get(PREF_PODCAST_TOPIC)
    }

    fun setAuthors(value: ArrayList<AuthorModel>?) {
        Hawk.put(PREF_AUTHORS, value)
    }

    fun getAuthors(): ArrayList<AuthorModel>? {
        return Hawk.get(PREF_AUTHORS, arrayListOf())
    }

    fun setAuthorTopic(value: ArrayList<TopicModel>) {
        Hawk.put(PREF_AUTHOR_TOPIC, value)
    }

    fun getAuthorTopic(): ArrayList<TopicModel>? {
        return Hawk.get(PREF_AUTHOR_TOPIC,  arrayListOf())
    }

    fun setBrowseTopic(value: ArrayList<BrowseTopicModel>) {
        Hawk.put(PREF_BROWSE_TOPIC, value)
    }

    fun getBrowseTopic(): ArrayList<BrowseTopicModel> {
        return Hawk.get(PREF_BROWSE_TOPIC, arrayListOf())
    }

    fun setCategories(value: ArrayList<CategoriesModel>) {
        Hawk.put(PREF_CATEGORIES, value)
    }

    fun getCategories(): ArrayList<CategoriesModel> {
        return Hawk.get(PREF_CATEGORIES, arrayListOf())
    }

    fun setNewTopics(value: ArrayList<NewTopicsModel>) {
        Hawk.put(PREF_NEW_TOPICS, value)
    }

    fun getNewTopics(): ArrayList<NewTopicsModel> {
        return Hawk.get(PREF_NEW_TOPICS, arrayListOf())
    }
    fun setNewAuthor(value: ArrayList<NewAuthorModel>){
         Hawk.put(PREF_NEW_AUTHOR, value)
    }
    fun getNewAuthor():ArrayList<NewAuthorModel>{
        return Hawk.get(PREF_NEW_AUTHOR, arrayListOf())
    }
    fun setTopicActivity(value: List<TopicModel>?){
        Hawk.put(PREF_TOPIC, value)
    }
    fun getTopicActivity():ArrayList<TopicModel>{
        return Hawk.get(PREF_TOPIC, arrayListOf())
    }
}