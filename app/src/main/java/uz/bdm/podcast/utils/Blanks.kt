package uz.bdm.podcast.utils

import uz.bdm.podcast.R
import uz.bdm.podcast.model.*

class Blanks {

    private val listenTopicList = arrayListOf(
        TopicModel("Recent", true),
        TopicModel("Topic"),
        TopicModel("Authors"),
        TopicModel("Episodes")
    )

    fun savePodcastTopic() {
        if (PrefUtils.getPodcastTopic()
                .isNullOrEmpty() || PrefUtils.getPodcastTopic() != listenTopicList
        ) {
            PrefUtils.setPodcastTopic(listenTopicList)
        }
    }

    val topic = arrayListOf(
        TopicModel("Recent", true),
        TopicModel("Authors", ),
        TopicModel("Popular", )
    )

    fun saveTopicActivity(){
        if (PrefUtils.getTopicActivity().isNotEmpty()||PrefUtils.getTopicActivity() != topic
        ){
            PrefUtils.setTopicActivity((topic))

        }
    }

    val authorsList = arrayListOf(
        AuthorModel("Mitchell Hawkins", R.drawable.podcast_author_eg, 7286, 123),
        AuthorModel("Rosemary Richards", R.drawable.rosemary_richards, 4156, 3244),
        AuthorModel("Gregory Miles", R.drawable.gregory_miles, 3123,3245),
        AuthorModel("Leslie Fisher", R.drawable.leslie_fisher, 5412, 3456)
    )

    fun saveAuthors() {
        if (PrefUtils.getAuthors()!!.isEmpty()) {
            PrefUtils.setAuthors(authorsList)
        }
    }

    val newauthorsList = arrayListOf(
        NewAuthorModel("Robert Dugoni", R.drawable.author_3, R.drawable.auth_bg_1, "Mary Beth Keane"),
        NewAuthorModel("J.K. Rowling", R.drawable.author_1, R.drawable.auth_bg_2, "J.K. Rowling"),
        NewAuthorModel("Mary Beth Keane", R.drawable.author_2, R.drawable.auth_bg_3, "Robert Dugoni"),
    )
    fun saveNewAuthor() {
        if (PrefUtils.getNewAuthor().isNullOrEmpty()||PrefUtils.getNewAuthor() != newauthorsList)
            PrefUtils.setNewAuthor(newauthorsList)
    }

    fun savePodcasts() {

        val authors = PrefUtils.getAuthors() ?: arrayListOf()
        val podcastList = arrayListOf(
            PodcastModel(
                1,
                "Miam isn't the best place to live",
                R.drawable.podcast_4,
                "02:45",
                authors[0],
                R.raw.elyor,
                newTopicsList[2],
            342

            ), PodcastModel(
                2,
                "Malesuada elementum ipsum",
                R.drawable.podcast_3,
                "12:03",
                authors[2],
                R.raw.nashida,
                newTopicsList[1],
                1342
            ), PodcastModel(
                3,
                "Massa turpis eget  habitant sed sed at",
                R.drawable.podcast_1,
                "12:11",
                authors[3],
                R.raw.qiyomat,
                newTopicsList[0],
                4523

            ), PodcastModel(
                4,
                "Ipsum varius imperdiet volutpat",
                R.drawable.listen_img4,
                "23:56",
                authors[1],
                R.raw.elyor,
                newTopicsList[2],
                5232
            ),
            PodcastModel(
                5,
                "Condimuntem at in tempus justo pretium",
                R.drawable.listen_img5,
                "32:36",
                authors[1],
                R.raw.nashida,
                newTopicsList[2],
                5432
            )
        )

        PrefUtils.setPodcasts(podcastList)
    }

    private val topicAuthor = arrayListOf(
        TopicModel("Recent", true),
        TopicModel("Most podcasts"),
        TopicModel("Most followed")
    )

    fun saveTopicAuthor() {
        PrefUtils.setAuthorTopic(topicAuthor)
    }

    private val browseTopicList = arrayListOf(
        BrowseTopicModel(1, R.drawable.ic_categories, "Categories", true),
        BrowseTopicModel(2, R.drawable.browse, "Topics"),
        BrowseTopicModel(3, R.drawable.authors, "Authors"),
        BrowseTopicModel(4, R.drawable.podcasts, "Podcasts"),
        BrowseTopicModel(5, R.drawable.episodes, "Episodes")
    )

    fun saveBrowseTopics() {
        if (PrefUtils.getBrowseTopic().isEmpty() || PrefUtils.getBrowseTopic() != browseTopicList) {
            PrefUtils.setBrowseTopic(browseTopicList)
        }
    }

    private val categoriesList = arrayListOf(
        CategoriesModel("Art and entertainment", R.drawable.rectangle_1),
        CategoriesModel("Bussiness and technology", R.drawable.rectangle_2),
        CategoriesModel("Health and lifestyle", R.drawable.rectangle_3),
        CategoriesModel("Society and culture", R.drawable.rectangle_4),
        CategoriesModel("Education", R.drawable.rectangle_5),
        CategoriesModel("Sport and recreation", R.drawable.rectangle_6),
        CategoriesModel("Travels and adventures", R.drawable.rectangle_7),
        CategoriesModel("News and politics", R.drawable.rectangle_8)
    )

    fun saveCategories() {
        if (PrefUtils.getCategories().isEmpty() || PrefUtils.getCategories() != categoriesList) {
            PrefUtils.setCategories(categoriesList)
        }
    }

    private val newTopicsList = arrayListOf(
        NewTopicsModel("Positive psychology and our motivations", R.drawable.topic_1, 84, 1386),
        NewTopicsModel("At massa nulla ultricies aliquam aenean lacus", R.drawable.topic_2, 71, 5275),
        NewTopicsModel("Eget suspendisse sem posuere mauris ligula", R.drawable.topic_3, 75, 7204),
        NewTopicsModel("Id sed urna cursus sed felis lacus gravida.", R.drawable.topic_4, 423, 1523)
    )

    fun saveNewTopics(){
        if(PrefUtils.getNewTopics().isEmpty() || PrefUtils.getNewTopics() != newTopicsList){
            PrefUtils.setNewTopics(newTopicsList)
        }
    }

}