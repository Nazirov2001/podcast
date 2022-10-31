package uz.bdm.podcast.model

data class PodcastModel(
    val id: Int,
    val name: String,
    val image: Int,
    val duration: String,
    val author: AuthorModel,
    val trackSrc: Int,
    val topic: NewTopicsModel,
  //  val title: String,
    val listened: Int,
    var date: String = "27.10.2018"
) : java.io.Serializable
