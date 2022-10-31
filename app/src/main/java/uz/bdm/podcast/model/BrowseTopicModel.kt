package uz.bdm.podcast.model

data class BrowseTopicModel(
    val id: Int,
    val image: Int,
    val title: String,
    var checked: Boolean = false
) : java.io.Serializable
